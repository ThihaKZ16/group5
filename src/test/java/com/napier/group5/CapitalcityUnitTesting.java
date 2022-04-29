package com.napier.group5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/** Create public class for Capitalcity unit testing */
public class CapitalcityUnitTesting
{
    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
        //app.connect("localhost:33060", 0);
    }
    /** Test Null value for displaycapital */
    @Test
    void displayTestNull()
    {
        app.display(null);
    }
    /** Test size for displaycapital */
    @Test
    void displayTestEmpty()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        app.displaycapital(capitalreport);
    }
    /** Test if displaycapital contains null value */
    @Test
    void displayTestContainsNull()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        capitalreport.add(null);
        app.displaycapital(capitalreport);
    }
  /** Test display capitalcity */
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