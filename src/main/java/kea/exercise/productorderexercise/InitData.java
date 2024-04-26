package kea.exercise.productorderexercise;

import kea.exercise.productorderexercise.models.Order;
import kea.exercise.productorderexercise.models.OrderLine;
import kea.exercise.productorderexercise.models.Product;
import kea.exercise.productorderexercise.repositories.OrderLineRepository;
import kea.exercise.productorderexercise.repositories.OrderRepository;
import kea.exercise.productorderexercise.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final OrderLineRepository orderLineRepository;
    private final OrderRepository orderRepository;

    public InitData(ProductRepository productRepository,
                    OrderLineRepository orderLineRepository,
                    OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
    }

    public void run(String... args) {
        System.out.println("InitData is running");

        // Products - With and without parameters
        Product product1 = new Product();
        product1.setName("Dry fruits");
        product1.setDescription("Delicious fruits");
        product1.setPrice(29.95);
        product1.setEan13("5701232098173");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Football");
        product2.setDescription("Round football");
        product2.setPrice(99.95);
        product2.setEan13("34643674674");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Pepsi Max");
        product3.setDescription("What a nice cola");
        product3.setPrice(18.95);
        product3.setEan13("898809090808");
        productRepository.save(product3);

        Product product4 = new Product("Toilet paper", "Just for you", 38.25,"53445434555");
        Product product5 = new Product("Goal", "Get a goal", 999.00, "808823344234");
        productRepository.save(product4);
        productRepository.save(product5);

        //OrderLines - Save all in once
        List<OrderLine> orderLines = new ArrayList<>() {{
            add(new OrderLine(product3, 7));
            add(new OrderLine(product3, 10));
            add(new OrderLine(product1, 5));
            add(new OrderLine(product1, 5));
        }};
        orderLineRepository.saveAll(orderLines);

        // Orders - With parameters and save all in once
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(LocalDate.now(), true, List.of(orderLines.get(0), orderLines.get(1))));
        orders.add(new Order(LocalDate.now(), true, List.of(orderLines.get(2))));
        orders.add(new Order(LocalDate.now(), true, List.of(orderLines.get(3))));
        orderRepository.saveAll(orders);

        System.out.println("We are live - Enjoy!");
    }
}
