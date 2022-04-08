package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Countries
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);
    }

    @Test
    void displayTestNull()
    {
        app.displaycountry(null);
    }

    @Test
    void displayTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displaycountry(countries);
    }

    @Test
    void displayTestContainsNull()
    {
        ArrayList<Country> countries= new ArrayList<Country>();
        countries.add(null);
        app.displaycountry(countries);
    }

    @Test
    void displaycountry()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country c = new Country();
        c.setName( "Seoul");
        c.setCode("KOR");
        c.setContinent("Asia");
        c.setRegion("Eastern Asia");
        c.setConame("South Korea");
        c.setPopulation(9981619);

        countries.add(c);
        app.displaycountry(countries);
    }

}

