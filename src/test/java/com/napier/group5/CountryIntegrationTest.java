/** import package from com.napier.group5 */
package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import java.sql.SQLException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

/** create public class "CityIntegrationTest" */
public class CountryIntegrationTest
{
    static App app;

    /** connection with app.java with localhost:33060 */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);

    }


    /** integration test for the total countries in the world */
    @Test
    void getcountriesintheworld() throws SQLException {
        ArrayList<Country> countries = app.getCountryPopLargesttoSmallest();
        Country country=null;
        boolean flag= false;
        for (Country c:countries){

            if (c.getCode().equals("USA"))
            {
                country = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("United States",country.getConame());
        assertEquals("North America",country.getContinent());
        assertEquals("North America",country.getRegion());
        assertEquals(2.78356992E8,country.getPopulation());


    }

    /** integration test for the total countries in the continent */
    @Test
    void getcountriesinthecontinent() throws SQLException {
        ArrayList<Country> countries1 = app.getCountryPopbyContinent("Asia");
        Country country=null;boolean flag= false;
        for (Country c:countries1){

            if (c.getCode().equals("MAC"))
            {
                country = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("Macao",country.getConame());
        assertEquals("Asia",country.getContinent());
        assertEquals("Eastern Asia",country.getRegion());
        assertEquals(473000.0,country.getPopulation());
    }

    /**integration test for the total countries in the region */
    @Test
    void getcountriesinaregion() throws SQLException {
        ArrayList<Country> countries2 = app.getCountryPopbyRegion("Caribbean");
        Country country=null;boolean flag= false;
        for (Country c:countries2){

            if (c.getCode().equals("CUB"))
            {
                country = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("Cuba",country.getConame());
        assertEquals("North America",country.getContinent());
        assertEquals("Caribbean",country.getRegion());
        assertEquals(1.1201E7,country.getPopulation());

    }

    /** integration test for the top N countries in the world */
    @Test
    void gettopcountriesintheworld() throws SQLException {
        ArrayList<Country> countries3 = app.gettopCountryPopLargesttoSmallest(3);
        Country country=null;boolean flag= false;
        for (Country c:countries3){

            if (c.getCode().equals("USA"))
            {
                country = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */

        assertEquals("United States",country.getConame());
        assertEquals("North America",country.getContinent());
        assertEquals("North America",country.getRegion());
        assertEquals(2.78356992E8,country.getPopulation());

    }

    /** integration test for the top N countries in the continent */
    @Test
    void gettopcountriesinthecontinent() throws SQLException {
        ArrayList<Country> countries4 = app.gettopCountryPopbyContinent("Asia", 2);
        Country country=null;boolean flag= false;
        for (Country c:countries4){

            if (c.getCode().equals("CHN"))
            {
                country = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("China",country.getConame());
        assertEquals("Asia",country.getContinent());
        assertEquals("Eastern Asia",country.getRegion());
        assertEquals(1.277558016E9,country.getPopulation());

    }

    /** integration test for the top N countries in the region */
    @Test
    void gettopcountriesintheregion() throws SQLException {
        ArrayList<Country> countries5 = app.gettopCountryPopbyRegion("Caribbean", 2);
        Country country=null;boolean flag= false;
        for (Country c:countries5){

            if (c.getCode().equals("DOM"))
            {
                country = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("Dominican Republic",country.getConame());
        assertEquals("North America",country.getContinent());
        assertEquals("Caribbean",country.getRegion());
        assertEquals(8495000,country.getPopulation());

    }

}
