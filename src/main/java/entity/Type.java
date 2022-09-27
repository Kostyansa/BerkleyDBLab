package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.List;

@Entity
public class Type {

    @PrimaryKey
    private int id;

    private String name;

    @SecondaryKey(relate = Relationship.ONE_TO_MANY, relatedEntity = Type.class, name="id")
    private List<Integer> subtype_of;

    public Type() {
    }

    public Type(int id, String name, List<Integer> subtype_of) {
        this.id = id;
        this.name = name;
        this.subtype_of = subtype_of;
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

    public List<Integer> getSubtype_of() {
        return subtype_of;
    }

    public void setSubtype_of(List<Integer> subtype_of) {
        this.subtype_of = subtype_of;
    }
}
