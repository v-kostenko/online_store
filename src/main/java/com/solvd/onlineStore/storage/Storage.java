package com.solvd.onlineStore.storage;

import com.solvd.onlineStore.exceptions.OrderCreationException;
import com.solvd.onlineStore.order.OrderItem;
import com.solvd.onlineStore.order.Product;
import com.solvd.onlineStore.util.GenerateData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Storage {
    private List<ProductItem> storage = new ArrayList<>();

    public Storage() {
        storage = GenerateData.generateProducts();
    }

    public void checkAmount(List<OrderItem> orderItemList) throws OrderCreationException {
        //logic check amount product in the storage
        for (OrderItem o : orderItemList) {
            for (ProductItem p : storage) {
                if (p.equals(o) && p.getAmount() < o.getAmount()) {
                    throw new OrderCreationException("Not enough in the storage.");
                }
            }
        }
    }

    public List<Product> getProducts() {
       return storage.stream().map(pi -> pi.getProduct().copy()).collect(Collectors.toList());
    }

    public List<Product> findProductByTitle(String title) {
        return storage.stream().map(pi -> pi.getProduct()).filter(oi -> oi.getTitle().equals(title)).collect(Collectors.toList());
    }

    public List<Product> findByBrand(String brand) {
        return storage.stream().map(pi -> pi.getProduct()).filter(pi -> pi.getBrand().equals(brand)).collect(Collectors.toList());
    }

    public List<Product> findByPrice(double from, double to) {
        return storage.stream().map(pi -> pi.getProduct()).filter(p -> p.getPrice() >= from && p.getPrice() <= to)
                .collect(Collectors.toList());
    }

    public List<ProductItem> findPresentProducts() {
        return storage.stream().filter(pi -> pi.getAmount() != 0).collect(Collectors.toList());
    }


}
