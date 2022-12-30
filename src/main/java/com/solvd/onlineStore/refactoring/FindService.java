package com.solvd.onlineStore.refactoring;

import com.solvd.onlineStore.order.Product;

import java.util.ArrayList;
import java.util.List;

public class FindService {

    public static List<Product> find() {
        int result = InputService.inputInt("1. Find by title \n2. Find by brand \n3. Find by Price");

        switch (result) {
            case 1:
                return findByTitle();
            case 2:
                return findByBrand();
            case 3:
                double from = InputService.inputDouble("From");
                double to = InputService.inputDouble("To");
                return findByPrice(from, to);
            default:
                find();
        }
        return new ArrayList<>();
    }

    private static List<Product> findByTitle() {
        String title = InputService.inputText("Input title");
        return ShopService.getShopService().findByTitle(title);
    }

    private static List<Product> findByBrand() {
        String brand = InputService.inputText("Input brand");
        return ShopService.getShopService().findByBrand(brand);
    }

    private static List<Product> findByPrice(double from, double to) {
        return ShopService.getShopService().findByPrice(from, to);
    }

}
