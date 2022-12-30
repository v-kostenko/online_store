package com.solvd.onlineStore.util;

import com.solvd.onlineStore.exceptions.AgeException;
import com.solvd.onlineStore.exceptions.ValidatorException;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void emailValidation(String email) throws ValidatorException {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
        Matcher m = pattern.matcher(email);

        if (!m.matches()) {
            throw new ValidatorException("Incorrect email format");
        }
    }

    public static void ageValidation(Date dateOfBirth) throws AgeException {
        if ((System.currentTimeMillis() - dateOfBirth.getTime()) / 365 / 24 / 60 / 60 / 1000 < 18) {
            throw new AgeException("Your age is less than 18 years.");
        }
    }

    public static void dateValidator(int year, int month, int day){
        //tbd
    }

    public static void nameSurnameValidation(String text) throws ValidatorException{
        Pattern pattern = Pattern.compile("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+");
        Matcher m = pattern.matcher(text);

        if (!m.matches()){
            throw new ValidatorException("Wrong name/surname format");
        }
    }


}
