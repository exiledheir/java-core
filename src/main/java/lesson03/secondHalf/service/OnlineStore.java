package lesson03.secondHalf.service;

import lesson03.secondHalf.entities.Product;

public class OnlineStore {
    private Product[] products = new Product[16];
    private int current = 0;

    public Product[] getProducts() {
        Product[] valid = new Product[current];

        for (int i = 0; i < current; i++) {
            valid[i] = products[i];
        }
        return valid;
    }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Products cant be null");

        if (current >= products.length) {
            Product[] newProducts = new Product[products.length * 2];
            for (int i = 0; i < current; i++) {
                newProducts[i] = products[i];
            }
            products = newProducts;
        }
        products[current++] = product;
    }

    public void buyProduct(int code) {
        for (int i = 0; i < current; i++) {
            if (products[i].getCode() == code) {
                products[i].buyProduct();
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void printAllProducts() {
        for (int i = 0; i < current; i++) {
            System.out.println(products[i].getProductInfo());
        }
        System.out.println();
    }
}
