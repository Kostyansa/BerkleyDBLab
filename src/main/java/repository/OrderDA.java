package repository;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.*;
import entity.Customer;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class OrderDA {
    // Index Accessors
    PrimaryIndex<Integer, Order> id;
    SecondaryIndex<Integer, Integer, Order> customerId;

    public OrderDA(EntityStore store) throws DatabaseException {

        // Primary key for Customer class
        id = store.getPrimaryIndex(Integer.class, Order.class);
        customerId = store.getSecondaryIndex(id, Integer.class, "customer");
    }

    public List<Order> get(){
        return this.id.map().values().stream().toList();
    }

    public Order get(Integer id){
        return this.id.get(id);
    }

    public List<Order> getByCustomerId(Integer customerId){
        EntityJoin<Integer, Order> join = new EntityJoin<>(this.id);
        join.addCondition(this.customerId, customerId);
        try (ForwardCursor<Order> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false).toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public Order save(Order order){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        order.setId(id);
        return this.id.put(order);
    }

    public Order update(Order order){
        return this.id.put(order);
    }

    public boolean delete(Integer id){
        return this.id.delete(id);
    }
}
