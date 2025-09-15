package warehouse.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Good {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Good() {
    }

    public Good(String name) {
        this.name = name;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Good(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Good setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Good setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                ", supplier=" + supplier +
                '}';
    }
}
