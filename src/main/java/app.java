import com.sleepycat.persist.EntityCursor;
import config.Database;
import entity.Customer;
import entity.Order;
import repository.CustomerDA;
import repository.OrderDA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class app {
    private static Random random = new Random();

    public static void test(){
        Database.setup();
        OrderDA orderDA = new OrderDA(Database.getStore());
        CustomerDA customerDA = new CustomerDA(Database.getStore());

        Customer customer = new Customer();
        customer.setId(0);

        customerDA.save(customer);

        Order one = new Order(
                0,
                new ArrayList<>(),
                customer.getId(),
                false
        );

        Order two = new Order(
                0,
                new ArrayList<>(),
                customer.getId(),
                false
        );

        Order three = new Order(
                0,
                new ArrayList<>(),
                customer.getId(),
                false
        );

        orderDA.save(one);
        orderDA.save(two);
        orderDA.save(three);

        List<Order> orders = orderDA.get();
        System.out.println(orders);

        System.out.println(orderDA.get(2));

        System.out.println(orderDA.getByCustomerId(1));

        System.out.println(orderDA.delete(2));
        one.setCancelled(true);
        System.out.println(orderDA.update(one));

        System.out.println(orderDA.get());
    }

    public static void main(String[] args) {
        Database.setup();
        OrderDA orderDA = new OrderDA(Database.getStore());
        CustomerDA customerDA = new CustomerDA(Database.getStore());

        Customer customer = new Customer();
        customerDA.save(customer);
        customer = new Customer();
        customerDA.save(customer);

        System.out.println(customerDA.get());

        System.out.println("First customer");
        for (int i = 0; i < 10; i++){
            Order order = new Order(
                    0,
                    new ArrayList<>(),
                    1,
                    random.nextBoolean()
            );
            orderDA.save(order);
        }
        System.out.println("Next customer");
        for (int i = 0; i < 10; i++){
            Order order = new Order(
                    0,
                    new ArrayList<>(),
                    2,
                    random.nextBoolean()
            );
            orderDA.save(order);
        }

        int target = 5;

        try (EntityCursor<Order> entityCursor = orderDA.cursor()) {
            for (Order order: entityCursor){
                if (order.getId() == target)
                {
                    System.out.println(order);
                }
            }
        }

        target = 2;

        System.out.println(orderDA.get(target));

        try (EntityCursor<Order> entityCursor = orderDA.cursor()) {
            for (Order order: entityCursor){
                if (order.getId() == 2)
                {
                    order.setCancelled(!order.isCancelled());
                    entityCursor.update(order);
                }
            }
        }

        System.out.println(orderDA.get(target));
        System.out.println(orderDA.getByCustomerId(1));
        System.out.println(orderDA.getCancelledOrdersForCustomer(1));
    }
}
