package com.solvd.onlineStore.refactoring;

import com.solvd.onlineStore.client.Client;
import com.solvd.onlineStore.exceptions.OrderCreationException;
import com.solvd.onlineStore.order.Order;
import com.solvd.onlineStore.order.OrderItem;
import com.solvd.onlineStore.order.PaymentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderService {
    private static final Logger logger = LogManager.getLogger(ClientProgram.class);
    private static ShopService shopService = ShopService.getShopService();

    public static long createOrder(List<OrderItem> orderItemList, Client client) {
        try {
            int type = InputService.inputInt("$$$ Select payment type $$$ \n1. Cash \n2. Cart");
            PaymentType paymentType = PaymentType.CASH;

            while (type > 3) {
                type = InputService.inputInt("$$$ Select payment type $$$ \n1. Cash \n2. Cart");
            }

            if (type == 1) {
                paymentType = PaymentType.CASH;
            }
            if (type == 2) {
                paymentType = PaymentType.CART;
                //add input card number functional
            }

            Order order = new Order(orderItemList, client, paymentType);
            //System.out.println(order);
            // System.out.println(order); error manager is null

            long orderNumber = ShopService.getShopService().addOrder(order);
            if (orderNumber == -1) {
                logger.info("Something went wrong");
            } else {
                logger.info("Order was created successful. Order`s number is " + orderNumber);
                return orderNumber;
            }
        } catch (OrderCreationException e){
            e.getMessage();
        }
        //cart.clearCart();
        //
        return -1;

    }




}