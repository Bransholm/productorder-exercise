package kea.exercise.productorderexercise.repositories;

import kea.exercise.productorderexercise.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
