package kea.exercise.productorderexercise.repositories;

import kea.exercise.productorderexercise.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
