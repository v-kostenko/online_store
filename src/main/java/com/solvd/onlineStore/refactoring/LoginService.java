package com.solvd.onlineStore.refactoring;

import com.solvd.onlineStore.client.Address;
import com.solvd.onlineStore.client.Client;
import com.solvd.onlineStore.exceptions.ClientExistingException;
import com.solvd.onlineStore.exceptions.ValidatorException;
import com.solvd.onlineStore.human.Gender;
import com.solvd.onlineStore.util.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class LoginService {
    private static ShopService shopService = ShopService.getShopService();
    private static final Logger logger = LogManager.getLogger(LoginService.class);

    public static Client logIn() {
        String email = InputService.inputText("Input your e-mail");
        return shopService.logIn(email);
    }

    public static Client registration() {
        try {
            logger.info("Hello! Fill out the form to become a client our shop.");
            //Logic of checking e-mail first
            String email = InputService.inputText("Your email");
            Validator.emailValidation(email);
            ShopService.getShopService().checkEmail(email);

            String name = InputService.inputText("What is your name?");
            //Validator.nameSurnameValidation(name);
            String surname = InputService.inputText("What is your surname?");
            //Validator.nameSurnameValidation(surname);
            Date dateOfBirth = InputService.inputDate("Input date of birth");
//        Validator.ageValidation(dateOfBirth);

            Gender gender = InputService.inputGender("Your gender?");
            String citizenship = InputService.inputText("Your citizenship?");
            String passport = InputService.inputText("Passport number");
            int id = InputService.inputInt("Input your id");

            String phone = InputService.inputText("Your phone number");

            String city = InputService.inputText("City");
            String street = InputService.inputText("Street");
            String houseNumber = InputService.inputText("House number");

            Client registeredClient = new Client(name, surname, dateOfBirth, gender, citizenship, passport, id,
                    phone, email, new Address(city, street, houseNumber));

            ShopService.getShopService().addClient(email, registeredClient);
            return registeredClient;
        } catch (ValidatorException validatorException) {
            logger.error(validatorException.getMessage());
        } catch (ClientExistingException clientExistingException) {

        }
        return null;
    }


}
