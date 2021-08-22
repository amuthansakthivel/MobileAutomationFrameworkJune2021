package com.tmb.facade;

import com.github.javafaker.Faker;

public class FakerFacade { //Business layer

    public static void getBuildingNumber(){
        new Faker().address().buildingNumber();
    }
}
