package com.solvd.onlineStore.order;

import com.solvd.onlineStore.client.Client;
import com.solvd.onlineStore.staff.Manager;
import com.solvd.onlineStore.util.ICalculator;
import com.solvd.onlineStore.util.Prototype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Order implements Prototype {
    private long id;
    private Date date;
    private Client client;
    private Manager manager;

    private PaymentType paymentType;
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order() {
    }

    public Order(List<OrderItem> orderItemList, Client client, PaymentType paymentType) {
        this.client = client;
        this.orderItemList = orderItemList;
        this.paymentType = paymentType;
        this.date = new Date();
    }

    public Order(long id, Date date, Client client, Manager manager, PaymentType paymentType, List<OrderItem> orderItemList) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.manager = manager;
        this.paymentType = paymentType;
        this.orderItemList = orderItemList;
    }

    public List<OrderItem> getOrderItemList() {
        return this.orderItemList;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public double totalPrice() {
        return orderItemList.stream().map((oi) -> oi.total()).reduce((o1, o2) -> o1 + o2).get();
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public Order copy() {
        Prototype prototype = () -> new Order(id, date, client.copy(), manager.copy(), paymentType,
                orderItemList.stream().peek(oi -> oi.copy()).collect(Collectors.toList()));
        return (Order) prototype;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        hashCode = hashCode * 7 + Long.hashCode(id);
        hashCode = hashCode * 7 + date.hashCode();
        hashCode = hashCode * 7 + client.hashCode();
        hashCode = hashCode * 7 + manager.hashCode();
        hashCode = hashCode * 7 + paymentType.hashCode();
        hashCode = hashCode * 7 + orderItemList.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Order)) {
            return false;
        }
        Order temp = (Order) object;
        return this.id == temp.id && this.date.equals(temp.date) && this.client.equals(temp.client) &&
                this.manager.equals(temp.manager) && this.orderItemList.equals(temp.orderItemList);
    }

    @Override
    public String toString() {
        return "\nId: " + id + "\nDate: " + date + "\n\nClient: " + client.showClientInfo() + "\n" +
                getOrderItemList();
        // + "\n--- Manager --- \n" + manager.showManagerInfo();
    }

    public void printOrderInfo() {
        System.out.println("\nId: " + id + "\nDate: " + date + "\n\n*** Client *** " + client.showClientInfo());
        System.out.println("~~~~ Order items in the order ~~~~");
        double totalSum = 0;
        for (int i = 0; i < orderItemList.size(); i++) {
            totalSum += orderItemList.get(i).total();
            System.out.println(i + ") " + orderItemList.get(i));
        }
        System.out.println("Total order sum =================== : " + totalSum + " y.e.");
        System.out.println("\n--- Manager --- \n" + manager.showManagerInfo());
    }


}

