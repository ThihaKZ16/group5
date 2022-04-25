//import package from com.napier.group5
package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

//create public class "cities"
public class cities
{
    static App app;

    //connection with app.java
    @BeforeAll
    static void init()
    {
        app = new App();
        //app.connect("localhost:33060", 0);
    }

    //null value test for display
    @Test
    void displayTestNull()
    {
        app.display(null);
    }

    //test size for display
    @Test
    void displayTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.display(cities);
    }

    //test if there are null values in display
    @Test
    void displayTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.display(cities);
    }

    //manual input testing
    @Test
    void display()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City ci = new City();
        ci.setName("Seoul");
        ci.setCountryCode("KOR");
        ci.setDistrict("Seoul");
        ci.setPopulation(9981619);
        ci.setContinent("Asia");
        ci.setRegion("Eastern Asia");
        ci.setConame("South Korea");

        cities.add(ci);
        app.display(cities);
    }

}