/**  import package from com.napier.group5 */
package com.napier.group5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/** create public class "Countries" */
public class Countries
{
    static App app;
    /** connection with app.java */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);
    }
    /** null value test for display */
    @Test
    void displayTestNull()
    {
        app.displaycountry(null);
    }
    /** test size for display */
    @Test
    void displayTestEmpty()
    {

        ArrayList<Country> countries = new ArrayList<Country>();
        app.displaycountry(countries);
    }

    /** test if there are null values in display */
    @Test
    void displayTestContainsNull()
    {
        ArrayList<Country> countries= new ArrayList<Country>();
        countries.add(null);
        app.displaycountry(countries);
    }
    /** manual input testing */
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

