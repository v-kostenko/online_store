package com.solvd.onlineStore.util;

import com.solvd.onlineStore.client.Address;
import com.solvd.onlineStore.client.Client;
import com.solvd.onlineStore.human.Gender;
import com.solvd.onlineStore.order.*;
import com.solvd.onlineStore.staff.*;
import com.solvd.onlineStore.storage.ProductItem;

import java.util.*;

public class GenerateData {

    public static List<ProductItem> generateProducts() {
        List<ProductItem> productList = new ArrayList<>();

        Product product1 = new Product("Snickers", "Adidas", 200.88, ProductType.MEN_SHOES_S_E);
        Product product2 = new Product("Dress", "Zara", 1200.98, ProductType.WOMEN_DRESS_C_E);
        Product product3 = new Product("Underware", "Cotton", 1599.99, ProductType.MEN_UNDERWEAR_C_C);
        Product product4 = new Product("Shoes", "Lacoste", 99.99, ProductType.MEN_SHOES_S_E);

        Product product5 = new Product("Skirt", "Zara", 14.29, ProductType.WOMEN_DRESS_C_E);
        Product product6 = new Product("Mini skirt", "Reebok", 10.27, ProductType.WOMEN_DRESS_C_E);

        Product product7 = new Product("Chocolate", "Toblerone", 4.5, ProductType.MEN_UNDERWEAR_C_C);
        Product product8 = new Product("Paste", "Nutella", 5.99, ProductType.MEN_UNDERWEAR_C_C);

        productList.add(new ProductItem(product1, 100));
        productList.add(new ProductItem(product2, 200));
        productList.add(new ProductItem(product3, 50));
        productList.add(new ProductItem(product4, 0));

        productList.add(new ProductItem(product5, 10));
        productList.add(new ProductItem(product6, 20));

        productList.add(new ProductItem(product7, 20));
        productList.add(new ProductItem(product8, 20));

        return productList;
    }

    private static Manager getClient(int x){
        List<Employee> managers = new ArrayList<>();
        managers = generateEmployee();
        return (Manager) managers.get(x);
    }

    public static List<Order> generateOrders() {
        List<Order> ordersList = new ArrayList<>();

        Client client1 = new Client("Mila", "Kunis", new Date(1983 - 1900, 8, 14), Gender.FEMALE,
                "American", "USA 888772", 999888, "+380661113322", "client_mila_kunis@usa.com",
                new Address("New York", "snt. Patrik", "213/12A"));

        Client client2 = new Client("Ewa", "Kasprzyk", new Date(1959 - 1900, 6, 1), Gender.MALE,
                "Polish", "PL 234589", 111222, "+380661144779", "client_ewa_kasp@pl.com",
                new Address("Warszawa", "Galytska", "3/12B"));

        Manager manager1 = new Manager("Petro", "Larchenko", new Date(1991 - 1900, 10, 2), Gender.MALE,
                "Ukrainian", "UA 223311", 123456, "+380999667711", "manager_petro_larchenko@ukr.net",
                1500, new StaffId("Engineering", 1), null,
                new Date(1980 - 1900, 3, 20), 75);

        Manager manager2 = new Manager("Sergii", "Kalyna", new Date(1990 - 1900, 2, 12), Gender.MALE,
                "Ukrainian", "UA 990022", 14325, "+380667773322", "manager_sergii_kalyna@ukr.net",
                1700, new StaffId("Engineering", 1), null,
                new Date(1990 - 1900, 7, 5), 100);


        OrderItem orderItem1 = new OrderItem(new Product("HeadPhones", "Samsung", 100, ProductType.MEN_SHOES_S_E), 2, true);
        OrderItem orderItem2 = new OrderItem(new Product("HeadPhones", "LG", 50, ProductType.WOMEN_DRESS_C_E), 3, true);

        List<OrderItem> orderItemList1 = new ArrayList<>();
        orderItemList1.add(orderItem1);
        orderItemList1.add(orderItem2);

        Order order1 = new Order(1, new Date(2021 - 1900, 1, 1 ), client1 , manager1, PaymentType.CART, orderItemList1);
        ordersList.add(order1);

        OrderItem orderItem3 = new OrderItem(new Product("Milk", "Galychina", 1.99, ProductType.WOMEN_DRESS_C_E), 2, false);
        OrderItem orderItem4 = new OrderItem(new Product("Sweater", "LC WAIKIKI", 5.99, ProductType.WOMEN_DRESS_C_E), 3, false);

        List<OrderItem> orderItemList2 = new ArrayList<>();
        Collections.addAll(orderItemList2, orderItem3, orderItem4);

        Order order2 = new Order(2, new Date(2022 - 1900, 3, 12 ), client2 , manager2, PaymentType.CASH, orderItemList2);
        ordersList.add(order2);

        return ordersList;
    }

    public static Map<String, Client> generateClients() {
        Map<String, Client> clientMap = new HashMap<>();

        Client client1 = new Client("Mila", "Kunis", new Date(1983 - 1900, 8, 14), Gender.FEMALE,
                "American", "USA 888772", 999888, "+380661113322", "client_mila_kunis@usa.com",
                new Address("New York", "snt. Patrik", "213/12A"));

        Client client2 = new Client("Ewa", "Kasprzyk", new Date(1959 - 1900, 6, 1), Gender.MALE,
                "Polish", "PL 234589", 111222, "+380661144779", "client_ewa_kasp@pl.com",
                new Address("Warszawa", "Galytska", "3/12B"));

        clientMap.put("mkunis@usa.com", client1);
        clientMap.put("ekasp@pl.com", client2);

        return clientMap;
    }

    public static List<Employee> generateEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        Manager manager1 = new Manager("Petro", "Larchenko", new Date(1991 - 1900, 10, 2), Gender.MALE,
                "Ukrainian", "UA 223311", 123456, "+380999667711", "manager_petro_larchenko@ukr.net",
                1500, new StaffId("Engineering", 1), null,
                new Date(1980 - 1900, 3, 20), 75);

        Manager manager2 = new Manager("Sergii", "Kalyna", new Date(1990 - 1900, 2, 12), Gender.MALE,
                "Ukrainian", "UA 990022", 14325, "+380667773322", "manager_sergii_kalyna@ukr.net",
                1700, new StaffId("Engineering", 1), null,
                new Date(1990 - 1900, 7, 5), 100);

        Trainee trainee = new Trainee("Victor", "Pavlik", new Date(1980 - 1900, 5, 3),
                Gender.MALE, "Ukrainian", "UA99988877", 999111, "+380997773322",
                "trainee_victor_pavlik@ukr.net", 300, new StaffId("Sale", 5), manager1,
                new Date(2022 - 1900, 12, 1), 15);

        Worker worker = new Worker("Oksana", "Petrivna", new Date(1991 - 1900, 10, 1),
                Gender.FEMALE, "Slovakia", "SL1112233", 4443322, "+280335554433",
                "worker_oksana_petrivna@slov.com", 1000, new StaffId("Accountant", 4),
                manager2, new Date(1999 - 1900, 2, 5), 50);

        Collections.addAll(employeeList, manager1, manager2, trainee, worker);

        return employeeList;
    }


}
