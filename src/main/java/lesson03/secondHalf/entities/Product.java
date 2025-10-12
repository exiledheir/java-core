package lesson03.secondHalf.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final int code;
    private final String name;
    private double price;
    private long count;

    public Product(int code, String name, double price, long count) {
        if (code <= 0) {
            throw new IllegalArgumentException("Enter valid product code");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Enter valid product name");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Enter valid price for product");
        }
        if (count < 0) {
            throw new IllegalArgumentException("Enter valid product count");
        }

        this.code = code;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getProductInfo() {
        return "Product{" + "code=" + code + ", name='" + name + '\'' + ", price=" + price + ", count=" + count + '}';
    }

    public void buyProduct() {
        if (count <= 0) {
            System.out.println("Product not available");
        } else {
            this.count--;
        }
    }
}
