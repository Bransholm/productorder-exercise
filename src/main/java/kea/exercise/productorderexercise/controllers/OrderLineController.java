package kea.exercise.productorderexercise.controllers;


import kea.exercise.productorderexercise.models.OrderLine;
import kea.exercise.productorderexercise.repositories.OrderLineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderlines")
public class OrderLineController {

    private final OrderLineRepository orderLineRepository;

    public OrderLineController(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @GetMapping
    public List<OrderLine> getAll() {
        return orderLineRepository.findAll();
    }

    @PostMapping
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

}
