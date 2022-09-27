package entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.time.ZonedDateTime;

@Entity
public class Payment {

    @PrimaryKey(sequence = "payment_pk")
    private int id;

    private ZonedDateTime timestamp;

    @SecondaryKey(relate = Relationship.ONE_TO_ONE, relatedEntity = Payment.class, name = "id")
    private int paymentId;

    public Payment() {
    }

    public Payment(int id, ZonedDateTime timestamp, int paymentId) {
        this.id = id;
        this.timestamp = timestamp;
        this.paymentId = paymentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
