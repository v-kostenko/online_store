package com.solvd.onlineStore.order;

import com.solvd.onlineStore.util.Prototype;

public class Product implements Prototype {
    private String title;
    private String brand;
    private double price;

    private ProductType productType;

    public Product() {
    }

    public Product(String title, String brand, double price, ProductType productType) {
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.productType = productType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Product copy(){
        Product product = new Product(this.title, this.brand, this.price, this.productType);
        return product;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        hashCode = hashCode * 7 + title.hashCode();
        hashCode = hashCode * 7 + brand.hashCode();
        hashCode = hashCode * 7 + Double.hashCode(price);
        hashCode = hashCode * 7 + productType.hashCode();
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product temp = (Product) object;
        return this.title.equals(temp.title) && this.brand.equals(temp.title) && this.price == temp.price && this.productType.equals(temp.productType);
    }

    @Override
    public String toString() {
        return "\n--- " + getClass().getSimpleName() + " ---" + "\nTitle: " + title + "\nBrand: "
                + brand + "\nPrice: " + price + " y.e." + "\nProductType: " + productType;
    }

}
