package com.solvd.onlineStore.storage;

import com.solvd.onlineStore.order.Product;
import com.solvd.onlineStore.util.ICalculator;
import com.solvd.onlineStore.util.Prototype;

public class ProductItem implements Prototype {
    private Product product;
    private int amount;

    public ProductItem() {
    }

    public ProductItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isPresent() {
        return amount > 0;
    }


    public double total() {
        return product.getPrice() * amount;
    }

    @Override
    public ProductItem copy() {
        ProductItem productItem = new ProductItem(this.product, this.amount);
        return productItem;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        hashCode = hashCode * 7 + product.hashCode();
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
        if (!(object instanceof ProductItem)) {
            return false;
        }
        ProductItem temp = (ProductItem) object;
        return this.product.equals(temp.product);
    }

    @Override
    public String toString() {
        return product + "\nAmount: " + amount + "\nTotal: " + total();
    }


}
