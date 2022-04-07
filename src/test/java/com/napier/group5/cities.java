package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class cities
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        //app.connect("localhost:33060", 0);
    }

    @Test
    void displayTestNull()
    {
        app.display(null);
    }

    @Test
    void displayTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.display(cities);
    }

    @Test
    void displayTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.display(cities);
    }

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