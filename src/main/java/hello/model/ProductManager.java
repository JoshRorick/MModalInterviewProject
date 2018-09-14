package hello.model;

import hello.model.entities.Product;
import hello.model.entities.Utils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductManager {
    private Map<String, Product> products;

    public ProductManager() {
        products = new HashMap<>();
    }

    public Iterable<Product> getProducts() {
        return products.values();
    }

    public Product getProduct(String name){
        return products.get(name);
    }

    public boolean addProduct(Product product){
        if(!products.containsKey(product.getName())){
            products.put(product.getName(), product);
            Utils.saveToFile("product.json", products);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(String productName){
        if(products.containsKey(productName)){
            products.remove(productName);
            Utils.saveToFile("product.json", products);
            return true;
        }
        return false;
    }



}
