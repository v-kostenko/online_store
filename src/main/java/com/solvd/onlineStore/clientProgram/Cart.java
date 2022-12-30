package com.solvd.onlineStore.clientProgram;

import com.solvd.onlineStore.order.OrderItem;
import com.solvd.onlineStore.exceptions.EmptyCartException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final Logger logger = LogManager.getLogger(Cart.class);
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Cart() {

    }

    public List<OrderItem> getOrderItemList() {
        List<OrderItem> tempList = new ArrayList<>(orderItemList);
        orderItemList.clear();
        return tempList;
    }

    public void addOrderItem(OrderItem orderItem) {
        int index = orderItemList.indexOf(orderItem);
        if (index == -1) {
            orderItemList.add(orderItem);
        } else {
            OrderItem oi = orderItemList.get(index);
            oi.setAmount(oi.getAmount() + orderItem.getAmount());
        }
    }

    public void showCart() throws EmptyCartException {


        if (orderItemList.isEmpty()) throw new EmptyCartException();

        System.out.println("~~~~ Order items in the cart ~~~~");
        double totalSum = 0;
        for (int i = 0; i < orderItemList.size(); i++) {
            totalSum += orderItemList.get(i).total();
            System.out.println(i + ") " + orderItemList.get(i));
        }
        System.out.println("Total sum________________: " + totalSum);

        //orderItemList.stream().forEach(oi -> oi.calculate());
        ////!!!!!!  Показать общую стоимость ордера
    }

    public void deleteOrderItem(OrderItem orderItem) {
        int index = orderItemList.indexOf(orderItem);
        if (index == -1) {
            return;
        }
        if (orderItemList.get(index).getAmount() < orderItem.getAmount()) {
            orderItemList.remove(orderItem);
        } else {
            orderItemList.get(index).setAmount(orderItemList.get(index).getAmount() - orderItem.getAmount());
        }
    }

     public boolean isEmpty() {
        return orderItemList.isEmpty();
    }

//    public void clearCart(){
//        orderItemList.clear();
//    }
}
