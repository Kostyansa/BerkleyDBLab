package repository;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import entity.Region;

import java.util.List;

public class RegionDA {
    private PrimaryIndex<Integer, Region> id;

    public RegionDA(EntityStore store) throws DatabaseException {

        // Primary key for Region class
        id = store.getPrimaryIndex(Integer.class, Region.class);
    }

    public List<Region> get(){
        return this.id.map().values().stream().toList();
    }

    public Region save(Region Region){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        Region.setId(id);
        return this.id.put(Region);
    }

}