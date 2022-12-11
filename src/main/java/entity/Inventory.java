package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

@Entity
public class Inventory {
    @PrimaryKey(sequence="сharacter_pk")
    private int id;
    private int amount;

    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Character.class, name = "character")
    private int character_id;
    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Item.class, name = "item")
    private int item_id;
}
