package kea.exercise.productorderexercise.repositories;

import kea.exercise.productorderexercise.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
