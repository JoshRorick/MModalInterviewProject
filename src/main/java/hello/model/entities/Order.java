package hello.model.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.ArrayList;
import java.util.List;

public class Order {

    @JsonUnwrapped
    private List<Product> products;
    private String id;

    public Order(String id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(String identifier) {
        int productIndex = -1;
        int currentIndex = 0;
        for(Product product : products) {
            if(product.getName().equalsIgnoreCase(identifier)) {
                productIndex = currentIndex;
            }
            currentIndex++;
        }
        if(productIndex != -1) {
            products.remove(productIndex);
            return true;
        }
        return false;
    }
}
