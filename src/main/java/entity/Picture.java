package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.SecondaryKey;

import static com.sleepycat.persist.model.Relationship.MANY_TO_ONE;

@Entity
public class Picture {
    @PrimaryKey(sequence="picture_pk")
    private int id;
    private String path;

    @SecondaryKey(relate = MANY_TO_ONE, relatedEntity = Business.class, name = "id")
    private int serviceId;

    public Picture() {
    }

    public Picture(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Picture(int id, String path, int serviceId) {
        this.id = id;
        this.path = path;
        this.serviceId = serviceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
