package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.List;

@Entity
public class Order {
    @PrimaryKey(sequence = "order_pk")
    private int id;

    @SecondaryKey(relate = Relationship.MANY_TO_MANY, relatedEntity = Service.class, name = "id")
    private List<Integer> serviceIds;

    private boolean cancelled;

    public Order(int id, List<Integer> serviceIds, boolean cancelled) {
        this.id = id;
        this.serviceIds = serviceIds;
        this.cancelled = cancelled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Integer> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
