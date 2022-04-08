/**Declare package from com.napier.group5 for unit testing*/
package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
/**Create public class for population unit testing*/
public class CapitalcityUnitTesting
{
    static App app;

    /**Connect app.java with the unit testing file*/
    @BeforeAll
    static void init()
    {
        app = new App();
        //app.connect("localhost:33060", 0);
    }

    /**Test Null value for display*/
    @Test
    void displayTestNull()
    {
        app.display(null);
    }

    /**Test size for capitalcity*/
    @Test
    void displayTestEmpty()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        app.displaycapital(capitalreport);
    }
    /**Test if display capitalreport contains null value*/
    @Test
    void displayTestContainsNull()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        capitalreport.add(null);
        app.displaycapital(capitalreport);
    }

    /**Test Null value for display capital report*/
    @Test
    void display()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        Country cap = new Country();
        cap.setCode("2413");
        cap.setConame("Cuba");
        cap.setContinent("North America");
        cap.setRegion( "Caribbean");
        cap.setName("La Habana");
        cap.setPopulation( 2256000);

        capitalreport.add(cap);
        app.displaycapital(capitalreport);
    }

}