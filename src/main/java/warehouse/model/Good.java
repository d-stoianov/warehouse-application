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

    public Good() {
    }

    public Good(String name) {
        this.name = name;
    }

    public Good(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Good(String name, Category category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Good(String name, Category category, double price, int quantity) {
        this.name = name;
        this.category = category;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Good good)) return false;
        return Double.compare(price, good.price) == 0 &&
                quantity == good.quantity &&
                Objects.equals(id, good.id) &&
                Objects.equals(name, good.name) &&
                Objects.equals(category, good.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, category);
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
