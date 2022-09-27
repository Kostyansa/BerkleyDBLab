package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

@Entity
public class Customer {
    @PrimaryKey(sequence="customer_pk")
    private int id;
    private String mail;
    private String hashedPassword;
    private String firstName;
    private String lastName;
    private String address;

    public Customer() {
    }

    public Customer(int id, String mail, String hashedPassword, String firstName, String lastName, String address) {
        this.id = id;
        this.mail = mail;
        this.hashedPassword = hashedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
