package kea.exercise.productorderexercise.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate orderDate;
    private boolean confirmed;
    @OneToMany
    private List<OrderLine> orderLines;


    public Order() {
    }

    // Create Order constructor with parameters
    public Order(LocalDate orderDate, boolean confirmed, List<OrderLine> orderLines) {
        this.orderDate = orderDate;
        this.confirmed = confirmed;
        this.orderLines = orderLines;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
