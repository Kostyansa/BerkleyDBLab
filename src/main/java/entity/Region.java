package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

@Entity
public class Region {
    @PrimaryKey(sequence="account_pk")
    private int id;
    private String name;
    private String eula;

    public Region() {
    }

    public Region(int id, String name, String eula) {
        this.id = id;
        this.name = name;
        this.eula = eula;
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

    public String getEula() {
        return eula;
    }

    public void setEula(String eula) {
        this.eula = eula;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eula='" + eula + '\'' +
                '}';
    }
}
