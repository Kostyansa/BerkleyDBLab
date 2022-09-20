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
}
