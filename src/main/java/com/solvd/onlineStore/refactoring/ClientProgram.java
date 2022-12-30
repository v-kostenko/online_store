package com.solvd.onlineStore.refactoring;

import com.solvd.onlineStore.client.Client;
import com.solvd.onlineStore.clientProgram.Cart;
import com.solvd.onlineStore.eShop.Shop;
import com.solvd.onlineStore.exceptions.EmptyCartException;
import com.solvd.onlineStore.exceptions.OrderCreationException;
import com.solvd.onlineStore.order.OrderItem;
import com.solvd.onlineStore.order.Product;
import com.solvd.onlineStore.refactoring.InputService;
import com.solvd.onlineStore.storage.ProductItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class ClientProgram {

    private static final Logger logger = LogManager.getLogger(ClientProgram.class);

    private Cart cart;
    private Client client;
    private List<Product> productList;

    public ClientProgram() {
    }

    public ClientProgram(Shop shop) {
        cart = new Cart();
        productList = shop.getProducts();
        menu();
    }

    private void menu() {
        try {
            int result = InputService.inputInt("\n *** MAIN MENU *** " +
                    "\n1. Registration \n2. Log in \n3. Log out \n4. Find product " +
                    "\n5. Show all products " + "\n6. Add product to the cart " + "\n7. Show products in the cart" +
                    "\n8. Remove product from the cart" + "\n9. Create order" + "\n10. Close program");
            switch (result) {
                case 1:
                    registration();
                    break;
                case 2:
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
                    InputService.close();
                    logger.info("Bye bye =)");
                    System.exit(0);
                }
                case 11:
                    // showAllOrders();
            }
        } catch (EmptyCartException cartException) {
            logger.info(cartException.getMessage());
        } catch (OrderCreationException e) {
            throw new RuntimeException(e);
        }
        menu();
    }

    private void showProductsInTheCart() throws EmptyCartException {
        cart.showCart();
    }

    private void registration() {
        client = LoginService.registration();
        logger.info("Congrats! Now you are a client!");
    }

    private void logIn() {
        Client tempClient = LoginService.logIn();
        if (tempClient != null) {
            client = tempClient;
            logger.info("Hello, " + client.getName() + "!");
        } else {
            logger.info("Client with this e-mail is not exist.");
        }
    }

    private void logOut() {
        if (client == null) {
            logger.info("You are not logged in.");
        } else {
            client = null;
            logger.info("Bye bye! You logged out.");
        }
    }

    private void showAllProducts() {
        logger.info("^^^^ There are all products in our shop ^^^^");
        //productList.sort();
//        for (int i = 0; i < productList.size(); i++) {
//            logger.info(i + " " + productList.get(i));
//        }
        int[] arr = {0};
        productList.forEach((p) -> logger.info(arr[0]++ + " " + p));
    }

    private void printProducts(List<Product> productList1) {
        if (productList1.isEmpty()) {
            logger.info("This product was not found");
        } else {
            for (Product prod : productList1) {
                logger.info(prod);
            }
        }
//         productList1.stream().forEach(p -> logger.info(p));
    }

    private void find() {
        List<Product> list = FindService.find();
        logger.info(list.isEmpty() ? "Empty" : "---------- Results ----------");
        list.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        list.forEach(p -> logger.info(p));
        //forEach(p -> System.out.println(p));
    }

    private void createOrder() throws OrderCreationException {
        if (client == null) {
            logger.warn("You are not authorized.");
            return;
        }
        if (cart.isEmpty()) {
            logger.warn("The cart is empty. First you should add product to the cart.");
            return;
        }

        long number = OrderService.createOrder(cart.getOrderItemList(), client);
        if (number == -1) {
            logger.warn("Something went wrong");
        } else {
            logger.info("Order was created successful. Order`s number is " + number);
        }
    }

    private void findPresentProduct() {
        logger.info("++++ There are all present products in the storage. ++++");

        List<ProductItem> products = ShopService.getShopService().findPresentProduct();
        if (products.isEmpty()) {
            logger.warn("The storage is empty!");
            return;
        }

        products.forEach(pr -> logger.info(pr));
    }

    private void addToCart() throws EmptyCartException {
        showAllProducts();
        int choice = InputService.inputInt("\nSelect number of product you want to add to the cart");
        Product product = productList.get(choice);
        int amount = InputService.inputInt("How much?");

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
            int id = InputService.inputInt("Select id of product you want to remove from the cart");
            int amount = InputService.inputInt("How much you want to remove?");
            cart.deleteOrderItem(new OrderItem(productList.get(id).copy(), amount, false));
            cart.showCart();
        } catch (EmptyCartException e) {

        }
    }

//    public void showAllOrders() {
//        shop.showAllOrders();
//    }


}