package com.solvd.onlineStore.eShop;

import com.solvd.onlineStore.client.Client;
import com.solvd.onlineStore.exceptions.ClientExistingException;
import com.solvd.onlineStore.exceptions.OrderCreationException;
import com.solvd.onlineStore.human.Gender;
import com.solvd.onlineStore.refactoring.InputService;
import com.solvd.onlineStore.staff.*;
import com.solvd.onlineStore.order.Order;
import com.solvd.onlineStore.order.Product;
import com.solvd.onlineStore.storage.ProductItem;
import com.solvd.onlineStore.storage.Storage;
import com.solvd.onlineStore.util.GenerateData;

import java.util.*;

public class Shop {

    private  List<Order> orderList = new ArrayList<>();
    private Map<String, Client> clientMap = new HashMap<>();
    private List<Employee> staff = new ArrayList<>();
    private final Storage storage;
    private static long lastNumber;
    private static final Shop shop = new Shop();

    public Shop() {
        this.storage = new Storage();

        staff = GenerateData.generateEmployee();
        clientMap = GenerateData.generateClients();
        orderList = GenerateData.generateOrders();
    }

    public List<Product> findByTitle(String title) {
        return storage.findProductByTitle(title);
    }

    public List<Product> findByBrand(String brand) {
        return storage.findByBrand(brand);
    }

    public List<Product> findByPrice(double from, double to) {
        return storage.findByPrice(from, to);
    }

    public List<ProductItem> findPresentProduct() {
        return storage.findPresentProducts();
    }

    public long addOrder(Order order) throws OrderCreationException {
        //check products in storage
        storage.checkAmount(order.getOrderItemList());

//        Random random = new Random();
//        int randomManager = random.nextInt(managerList.size());
//
//        order.setManager(managerList.get(randomManager));

        orderList.add(order);
        order.setId(++lastNumber);
        return lastNumber;
    }

    public List<Product> getProducts() {
        return storage.getProducts();
    }

    public Client logIn(String email) {
        return clientMap.get(email);
    }

    public void addClient(String email, Client client) {
        clientMap.put(email, client);
    }

    public void checkEmail(String email) throws ClientExistingException {
        if( clientMap.containsKey(email)){
            throw new ClientExistingException("Client with this email exsist.");
        }
    }

    private void menu() {
        int result = InputService.inputInt("Working with employee " + "\n1. Робота с сотрудниками \n2. Робота с товаром " +
                "\n3. Работа с клиентами \n4. Exit");
    }

    public void showEmployeesContacts() {
        System.out.println("----------- All employee contacts -----------");
        for (int i = 0; i < staff.size(); i++) {
            Employee e = staff.get(i);
            System.out.println(i + ") " + e.getClass().getSimpleName() + ": \n" + e.getName() + " " + e.getSurname() + "\n" + e.getPhone()
                    + "\n" + e.getEmail() + "\n" + (e.getAddress() == null ? "Address: Pppp..." : "Address: " + e.getAddress()));
        }
    }


    public void addEmployee() {
        int position = InputService.inputInt("Select position \n1. Manager \n2. Trainee \n3. Worker");

        String name = InputService.inputText("Input name");
        String surname = InputService.inputText("Input surname");
        Date dateOfBirth = InputService.inputDate("Input date of birth");
        Gender gender = InputService.inputGender("Input gender");
        String citizenship = InputService.inputText("Input citizenship");
        String passport = InputService.inputText("Passport");
        long id = InputService.inputLong("Input id");
        String phone = InputService.inputText("Phone number");
        String email = InputService.inputText("Email");
        double salary = InputService.inputDouble("Salary");

        String department = InputService.inputText("Department");
        int departmentId = InputService.inputInt("Department ID");
        StaffId staffId = new StaffId(department, departmentId);

        Employee employee = null;

        switch (position) {
            case 1:
                Date employmentDateManager = InputService.inputDate("Input employment date.");
                double bonusManager = InputService.inputDouble("Bonus.");

                employee = new Manager(name, surname, dateOfBirth, gender, citizenship, passport, id, phone, email,
                        salary, staffId, null, employmentDateManager, bonusManager);
                break;
            case 2:
                Date practiceDate = InputService.inputDate("When practice starts");
                long practiceLength = InputService.inputLong("How much days is practice?");

                employee = new Trainee(name, surname, dateOfBirth, gender, citizenship, passport, id, phone, email,
                        salary, staffId, null, practiceDate, practiceLength);
                break;
            case 3:
                Date employmentDate = InputService.inputDate("Input employment date.");
                double bonus = InputService.inputDouble("Bonus.");

                employee = new Worker(name, surname, dateOfBirth, gender, citizenship, passport, id, phone, email,
                        salary, staffId, null, employmentDate, bonus);
                break;
        }
        staff.add(employee);


    }

    public void removeEmployee() {
        showEmployeesContacts();
        System.out.println("----------------");
        int result;
        boolean isCorrect = false;

        do {
            result = InputService.inputInt("Select number of employee you want to delete.");
            System.out.println((isCorrect = result >= 0 && result < staff.size()) ? "" : "Employee with this number is not exist.");
        } while (!isCorrect);

        Employee e = staff.remove(result);
        System.out.println((e != null) ? e.getName() + " " + e.getSurname() + " was deleted successfully." : "Not found");
    }

    public void showAllOrders(){
        orderList.stream().forEach(o -> o.printOrderInfo());
    }

    public List<Order> getAllOrders(){
        return orderList;
    }
}
