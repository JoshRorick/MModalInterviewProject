package hello.controller;

import hello.model.OrderManager;
import hello.model.ProductManager;
import hello.model.entities.Order;
import hello.model.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderManager orderManager;
    @Autowired
    private ProductManager productManager;

    @GetMapping("/list")
    public Iterable<Order> list(){
        return orderManager.getOrders();
    }

    @GetMapping("/createOrder/{id}")
    public @ResponseBody boolean createOrder(@PathVariable(value="id") String id){
        Order order = new Order(id);
        order.setId(id);
        return orderManager.addOrder(order);
    }

    @GetMapping("/deleteOrder/{id}")
    public @ResponseBody boolean deleteOrder(@PathVariable(value="id") String id){
        return orderManager.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public @ResponseBody Order getOrder(@PathVariable(value = "id") String id) {
        return orderManager.getOrder(id);
    }

    @GetMapping("/addProduct/{order}/{product}")
    public @ResponseBody boolean addProductToOrder(@PathVariable(value = "order") String orderId,
                                                   @PathVariable(value = "product") String productId){
        Order order = orderManager.getOrder(orderId);
        Product product = productManager.getProduct(productId);

        if(order != null && product != null){
            order.addProduct(product);
            orderManager.updateOrder(order);
            return true;
        }
        return false;
    }

    @GetMapping("/removeProduct/{order}/{product}")
    public @ResponseBody boolean removeProductFromOrder(@PathVariable(value = "order") String orderId,
                                                        @PathVariable(value = "product") String productId){
        Order order = orderManager.getOrder(orderId);
        Product product = productManager.getProduct(productId);

        if(order != null && product != null){
            order.removeProduct(productId);
            orderManager.updateOrder(order);
            return true;
        }
        return false;
    }
}
