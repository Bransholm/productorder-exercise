package kea.exercise.productorderexercise.controllers;

import kea.exercise.productorderexercise.models.Order;
import kea.exercise.productorderexercise.repositories.OrderLineRepository;
import kea.exercise.productorderexercise.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private  final  OrderLineRepository orderLineRepository;

    public OrderController(OrderRepository orderRepository, OrderLineRepository orderLineRepository) {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        orderLineRepository.saveAll(order.getOrderLines());
        return orderRepository.save(order);
    }
}
    // Example of a post object with an order with orderLines and products //
    /*
    {
            "id": 5,
            "orderDate": "2024-12-24",
            "confirmed": false,
            "orderLines": [
            {
            "id": 8,
            "product": {
            "id": 3,
            "name": null,
            "description": null,
            "price": 0.0,
            "ean13": null
            },
            "quantity": 24
            },
            {
            "id": 9,
            "product": {
            "id": 4,
            "name": null,
            "description": null,
            "price": 0.0,
            "ean13": null
            },
            "quantity": 12
            }
            ]
            }

     */
