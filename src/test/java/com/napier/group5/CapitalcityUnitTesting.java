package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CapitalcityUnitTesting
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
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        app.displaycapital(capitalreport);
    }

    @Test
    void displayTestContainsNull()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        capitalreport.add(null);
        app.displaycapital(capitalreport);
    }

    @Test
    void display()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        Country cap = new Country();
        cap.code = "2413";
        cap.coname= "Cuba";
        cap.continent = "North America";
        cap.region = "Caribbean";
        cap.name = "La Habana";
        cap.population = 2256000;

        capitalreport.add(cap);
        app.displaycapital(capitalreport);
    }

}