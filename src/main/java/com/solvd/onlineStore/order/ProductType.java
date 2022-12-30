package com.solvd.onlineStore.order;

import com.solvd.onlineStore.human.Gender;

public enum ProductType {
    MEN_UNDERWEAR_C_C("Classic", "Cheap", Gender.MALE),
    MEN_SHOES_S_E("Sport", "Expensive", Gender.MALE),
    WOMEN_DRESS_C_E("Classic", "Expensive", Gender.FEMALE);

    private String style;
    private String catigory;
    private Gender gender;

    ProductType(String style, String catigory, Gender gender) {
        this.style = style;
        this.catigory = catigory;
        this.gender = gender;
    }

    public String  getStyle(){
        return style;
    }

    public String getCatigory(){
        return catigory;
    }

    @Override
    public String toString(){
        return super.toString() + "\nStyle: " + style + "\nCatigory: " + catigory + "\nGender " + gender;
    }

}
