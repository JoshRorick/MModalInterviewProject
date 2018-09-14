package hello.controller;

import hello.model.OrderManager;
import hello.model.ProductManager;
import hello.model.entities.Order;
import hello.model.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductManager productManager;
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private OrderController orderController;

    @GetMapping("/list")
    public Iterable<Product> list(){
        return productManager.getProducts();
    }

    @PostMapping("/createProduct")
    public @ResponseBody
    boolean createProduct(@RequestBody Product product){
        return productManager.addProduct(product);
    }

    @PostMapping("/createProducts")
    public @ResponseBody boolean[] createProducts(@RequestBody List<Product> productList){
        boolean[] results = new boolean[productList.size()];
        int index = 0;
        for(Product product : productList){
            results[index] = createProduct(product);
            index++;
        }
        return results;
    }

    @GetMapping("/deleteProduct/{id}")
    public @ResponseBody boolean deleteProduct(@PathVariable(value = "id") String id){
        Iterable<Order> allOrders = orderManager.getOrders();
        for(Order order : allOrders){
            orderController.removeProductFromOrder(order.getId(), id);
        }
        return productManager.deleteProduct(id);
    }
}
