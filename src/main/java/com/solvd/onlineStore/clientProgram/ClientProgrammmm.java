package com.solvd.onlineStore.clientProgram;

import com.solvd.onlineStore.client.Client;
import com.solvd.onlineStore.controllers.InputController;
import com.solvd.onlineStore.eShop.Shop;
import com.solvd.onlineStore.exceptions.*;
import com.solvd.onlineStore.order.Order;
import com.solvd.onlineStore.order.OrderItem;
import com.solvd.onlineStore.order.PaymentType;
import com.solvd.onlineStore.order.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;


public class ClientProgrammmm {

    private static final Logger logger = LogManager.getLogger(ClientProgrammmm.class);

    private Cart cart;
    private Client client;
    private Shop shop;
    private InputController inputController = new InputController();
    private List<Product> productList;

    public ClientProgrammmm() {
    }

    public ClientProgrammmm(Shop shop) {
//        this.shop = shop;
//        cart = new Cart();
//        productList = shop.getProducts();
//        menu();
    }

    private void menu() {
        try {
            int result = inputController.inputInt("\n *** MAIN MENU *** " +
                    "\n1. Registration \n2. Log in \n3. Log out \n4. Find product " +
                    "\n5. Show all products " + "\n6. Add product to the cart " + "\n7. Show products in the cart" +
                    "\n8. Remove product from the cart" + "\n9. Create order" + "\n10. Close program");
            switch (result) {
                case 1:
                    registration();
                    break;
                case 2:
                    //LoginService.logIn();
                    logIn();
                    break;
                case 3:
                    logOut();
                    break;
                case 4:
                    find();
                    break;
                case 5:
                    showAllProducts();
                    break;
                case 6:
                    addToCart();
                    break;
                case 7:
                    showProductsInTheCart();
                    break;
                case 8:
                    removeFromTheCart();
                    break;
                case 9:
                    createOrder();
                    break;
                case 10: {
                    inputController.close();
                    logger.info("Bye bye =)");
                    System.exit(0);
                }
                case 11:
                    showAllOrders();
            }
        } catch (AgeException ae) {
            System.out.println(ae.getMessage());
        } catch (EmptyCartException cartException) {
            logger.info(cartException.getMessage());
        } catch (ValidatorException ve) {
            logger.info(ve.getMessage());
        } catch (OrderCreationException o) {
            logger.info(o.getMessage());
        } catch (ClientExistingException c) {
            logger.info(c.getMessage());
        }
        menu();
    }

    private void showProductsInTheCart() throws EmptyCartException {
        cart.showCart();
    }


    private void registration() throws AgeException, ValidatorException, ClientExistingException {
        System.out.println("Hello! Fill out the form to become a client our shop.");

        //Logic of checking e-mail first
        String email = inputController.inputText("Your email");

        //Validator.emailValidation(email);

        shop.checkEmail(email);


//        String name = inputController.inputText("What is your name?");
//        Validator.nameSurnameValidation(name);
//
//        String surname = inputController.inputText("What is your surname?");
//        Validator.nameSurnameValidation(surname);

//        Date dateOfBirth = inputController.inputDate("Input date of birth");
//        Validator.ageValidation(dateOfBirth);

//        Gender gender = inputController.inputGender("Your gender?");
//        String citizenship = inputController.inputText("Your citizenship?");
//        String passport = inputController.inputText("Passport number");
//        int id = inputController.inputInt("Input your id");
//
//        String phone = inputController.inputText("Your phone number");
//
//        String city = inputController.inputText("City");
//        String street = inputController.inputText("Street");
//        String houseNumber = inputController.inputText("House number");
//
//        Client registeredClient = new Client(name, surname, dateOfBirth, gender, citizenship, passport, id,
//                phone, email, new Address(city, street, houseNumber));
//        shop.addClient(email, registeredClient);
//        client = registeredClient;
//
        logger.info("Congrats! Now you are a client!");
    }

    private void logIn() {
        String email = inputController.inputText("Input your e-mail");
        Client tempClient = shop.logIn(email);
        if (tempClient != null) {
            client = tempClient;
            System.out.println("Hello, " + client.getName() + "!");
        } else {
            System.out.println("Incorrect e-mail. Try again.");
        }
    }

    private void logOut() {
        if (client == null) {
            System.out.println("You are not logged in.");
        } else {
            client = null;
            System.out.println("Bye bye! You logged out.");
        }
    }

    //if use empty constructor
    public void connectShop(Shop shop) {
        this.shop = shop;
        menu();
    }

    private void showAllProducts() {
        logger.info("^^^^ There are all products in our shop ^^^^");
        for (int i = 0; i < productList.size(); i++) {
            logger.info(i + " " + productList.get(i));
        }
    }

    private void printProducts(List<Product> productList1) {
        if (productList1.isEmpty()) {
            System.out.println("This product was not found");
        } else {
            for (Product prod : productList1) {
                System.out.println(prod);
            }
        }
        // productList1.stream().forEach(p -> System.out.println(p));
    }

    private void findByTitle() {
        String title = inputController.inputText("Input title");
        List<Product> productList1 = shop.findByTitle(title);

        printProducts(productList1);
    }

    private void findByBrand() {
        String brand = inputController.inputText("Input brand");
        List<Product> productList1 = shop.findByBrand(brand);

        printProducts(productList1);
    }

    private void findByPrice(double from, double to) {
        List<Product> productList1 = shop.findByPrice(from, to);
        printProducts(productList1);
    }

    private void createOrder() throws OrderCreationException {
        //            if (client == null) {
//               logger.warn("You are not authorized.");
//                return;
//            }
//        if (cart.isEmpty()) {
//           logger.warn("The cart is empty. First you should add product to the cart.");
//            return;
//        }
        int type = inputController.inputInt("$$$ Select payment type $$$ \n1. Cash \n2. Cart");
        PaymentType paymentType = PaymentType.CASH;

        while (type > 3) {
            type = inputController.inputInt("$$$ Select payment type $$$ \n1. Cash \n2. Cart");
        }


        if (type == 1) {
            paymentType = PaymentType.CASH;
        }
        if (type == 2) {
            paymentType = PaymentType.CART;
            //add input card number functional
        }


        Order order = new Order(cart.getOrderItemList(), client, paymentType);
        System.out.println(order);
        // System.out.println(order); error manager is null

        long orderNumber = shop.addOrder(order);
        if (orderNumber == -1) {
            System.out.println("Something went wrong");
        } else {
            System.out.println("Order was created successful. Order`s number is " + orderNumber);
        }
        //cart.clearCart();

    }

    private void find() {
        int result = inputController.inputInt("---- Select option ---- " +
                "\n1. Find all present products" +
                "\n2. Find by title" +
                "\n3. Find by brand " +
                "\n4. Find by price" +
                "\n5. Back");
        switch (result) {
            case 1:
                findPresentProduct();
                break;
            case 2:
                findByTitle();
                break;
            case 3:
                findByBrand();
                break;
            case 4:
                double from = inputController.inputDouble("Input price from");
                double to = inputController.inputDouble("Input price to");
                findByPrice(from, to);
                break;
            case 5:
                menu();
            default:
                find();
        }
    }

    private void findPresentProduct() {
        System.out.println("++++ There are all present products in the storage. ++++");

       // List<Product> products = shop.findPresentProduct();
//        if (products.isEmpty()) {
//            System.out.println("The storage is empty!");
//            return;
//        }
//        for (Product pr : products) {
//            logger.info(pr);
//        }
    }

    private void addToCart() throws EmptyCartException {
        showAllProducts();
        int choice = inputController.inputInt("\nSelect number of product you want to add to the cart");
        Product product = productList.get(choice);
        int amount = inputController.inputInt("How much?");

        cart.addOrderItem(new OrderItem(product.copy(), amount, false));
        cart.showCart();
    }

    private void removeFromTheCart() {
        try {
            cart.getOrderItemList();
            // if (cart.isEmpty()) {
//            System.out.println("The cart is empty. First add some products to the cart.");
//        } else {
            cart.showCart();
            int id = inputController.inputInt("Select id of product you want to remove from the cart");
            int amount = inputController.inputInt("How much you want to remove?");
            cart.deleteOrderItem(new OrderItem(productList.get(id).copy(), amount, false));
            cart.showCart();
        } catch (EmptyCartException e) {

        }
    }

    public void showAllOrders() {
        shop.showAllOrders();
    }


}