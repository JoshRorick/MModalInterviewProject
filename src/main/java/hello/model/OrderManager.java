package hello.model;

import hello.model.entities.Order;
import hello.model.entities.Utils;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderManager {

    private Map<String, Order> orders;

    public OrderManager(){
        orders = new HashMap<>();
    }

    public Iterable<Order> getOrders() {
        return orders.values();
    }

    public Iterable<String> getOrderKeys(){
        return orders.keySet();
    }

    public boolean addOrder(Order order){
        if(orders.containsKey(order.getId())){
            return false;
        }
        orders.put(order.getId(), order);
        Utils.saveToFile("order.json", orders);
        return true;
    }

    public boolean deleteOrder(String id){
        if(orders.containsKey(id)){
            orders.remove(id);
            Utils.saveToFile("order.json", orders);
            return true;
        }
        return false;
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }

    public void updateOrder(Order order){
        orders.put(order.getId(), order);
        Utils.saveToFile("order.json", orders);
    }

}
