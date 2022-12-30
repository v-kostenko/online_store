package com.solvd.onlineStore.order;

import com.solvd.onlineStore.storage.ProductItem;

public class OrderItem extends ProductItem {
    private boolean isPaid;

    public OrderItem() {
    }

    public OrderItem(Product product, int amount, boolean isPaid) {
        super(product, amount);
        this.isPaid = isPaid;
    }

    public boolean isPaid() {
        return this.isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public OrderItem copy(){
        OrderItem orderItem = new OrderItem(this.getProduct().copy(), this.getAmount(), this.isPaid);
        return orderItem;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPaid: " + isPaid + "\n";
    }

}
