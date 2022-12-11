package repository;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.*;
import entity.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class ServerDA {
    private PrimaryIndex<Integer, Server> id;
    private SecondaryIndex<Integer, Integer, Server> region_id;
    public ServerDA(EntityStore store) throws DatabaseException {
        id = store.getPrimaryIndex(Integer.class, Server.class);
        region_id = store.getSecondaryIndex(id, Integer.class, "region");
    }
    public EntityCursor<Server> cursor(){
        return this.id.entities();
    }

    public List<Server> get(){
        return this.id.map().values().stream().toList();
    }

    public Server get(Integer id){
        return this.id.get(id);
    }

    public List<Server> getByRegionId(Integer regionId){
        EntityJoin<Integer, Server> join = new EntityJoin<>(this.id);
        join.addCondition(this.region_id, regionId);
        try (ForwardCursor<Server> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false).toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public List<Server> getServersForRegionStartingWith(Integer regionId, String prefix){
        EntityJoin<Integer, Server> join = new EntityJoin<>(this.id);
        join.addCondition(this.region_id, regionId);
        try (ForwardCursor<Server> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false)
                    .filter(server -> server.getName().startsWith(prefix))
                    .toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public Server save(Server Server){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        Server.setId(id);
        return this.id.put(Server);
    }

    public Server update(Server Server){
        return this.id.put(Server);
    }

    public boolean delete(Integer id){
        return this.id.delete(id);
    }
}
