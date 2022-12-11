package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

@Entity
public class Server {
    @PrimaryKey(sequence="account_pk")
    private int id;
    private String name;
    private String url;
    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Region.class, name = "region")
    private int region_id;

    public Server() {
    }

    public Server(int id, String name, String url, int region_id) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.region_id = region_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", region_id=" + region_id +
                '}';
    }
}
