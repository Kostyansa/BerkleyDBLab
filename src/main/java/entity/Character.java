package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

@Entity
public class Character {
    @PrimaryKey(sequence="сharacter_pk")
    private int id;
    private String name;
    private int level;
    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Server.class, name = "server")
    private int server_id;
    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Account.class, name = "account")
    private int account_id;
    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = CharacterClass.class, name = "character_class")
    private int class_id;
    @SecondaryKey(relate = Relationship.MANY_TO_ONE, relatedEntity = Location.class, name = "location")
    private int location_id;

    public Character() {
    }

    public Character(int id, String name, int level, int server_id, int account_id, int class_id, int location_id) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.server_id = server_id;
        this.account_id = account_id;
        this.class_id = class_id;
        this.location_id = location_id;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getServer_id() {
        return server_id;
    }

    public void setServer_id(int server_id) {
        this.server_id = server_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
}
