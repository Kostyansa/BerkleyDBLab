package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

@Entity
public class Service {
    @PrimaryKey(sequence="service_pk")
    private int id;
    private String description;
    private double price;

    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Business.class, name="id")
    private int businessId;

    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Type.class, name="id")
    private int typeId;

    public Service(int id, String description, double price, int businessId, int typeId) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.businessId = businessId;
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
