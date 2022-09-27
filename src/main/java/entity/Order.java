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

    @SecondaryKey(relate = Relationship.MANY_TO_MANY, relatedEntity = Service.class, name = "services")
    private List<Integer> serviceIds;

    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Customer.class, name = "customer")
    private int customerId;

    private boolean cancelled;

    public Order() {}

    public Order(int id, List<Integer> serviceIds, int customerId, boolean cancelled) {
        this.id = id;
        this.serviceIds = serviceIds;
        this.customerId = customerId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", serviceIds=" + serviceIds +
                ", customerId=" + customerId +
                ", cancelled=" + cancelled +
                '}';
    }
}
