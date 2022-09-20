package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

@Entity
public class Type {

    @PrimaryKey
    private int id;

    private String name;

    @SecondaryKey(relate = Relationship.ONE_TO_MANY, relatedEntity = Type.class, name="id")
    private int subtype_of;
}
