import config.Database;
import entity.Customer;
import entity.Order;
import repository.CustomerDA;
import repository.OrderDA;

import java.util.ArrayList;
import java.util.List;

public class app {

    public static void main(String[] args) {
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
}
