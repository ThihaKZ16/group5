package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import java.sql.SQLException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class CountryIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);

    }



    @Test
    void getcountriesintheworld() throws SQLException {
        ArrayList<Country> countries = app.getCountryPopLargesttoSmallest();
        Country country=null;
        boolean flag= false;
        for (Country c:countries){
            //2710,'Rangoon (Yangon)','MMR','Rangoon [Yangon]',3361700
            if (c.getCode().equals("USA"))
            {
                country = c;flag = true;
                break;
            }
        }
        assertEquals("Washington",country.getConame());
//        assertEquals(,country.getPopulation());
    }



    @Test
    void getcountriesinthecontinent() throws SQLException {
        ArrayList<Country> countries1 = app.getCountryPopbyContinent("Asia");
        Country country=null;boolean flag= false;
        for (Country c:countries1){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getCode().equals("JPN"))
            {
                country = c;flag = true;
                break;
            }
        }
//        assertEquals("Japan",country.getConame());
        assertEquals(1.26714E8,country.getPopulation());
    }

    @Test
    void getcountriesinaregion() throws SQLException {
        ArrayList<Country> countries2 = app.getCountryPopbyRegion("Caribbean");
        Country country=null;boolean flag= false;
        for (Country c:countries2){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getCode().equals("TCA"))
            {
                country = c;flag = true;
                break;
            }
        }
//        assertEquals("Japan",country.getConame());
        assertEquals(17000.0,country.getPopulation());
    }

    @Test
    void gettopcountriesintheworld() throws SQLException {
        ArrayList<Country> countries3 = app.gettopCountryPopLargesttoSmallest(3);
        Country country=null;boolean flag= false;
        for (Country c:countries3){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getCode().equals("IND"))
            {
                country = c;flag = true;
                break;
            }
        }
//        assertEquals("Japan",country.getConame());
        assertEquals(1.013662016E9,country.getPopulation());
    }

    @Test
    void gettopcountriesinthecontinent() throws SQLException {
        ArrayList<Country> countries4 = app.gettopCountryPopbyContinent("Asia", 2);
        Country country=null;boolean flag= false;
        for (Country c:countries4){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getCode().equals("CHN"))
            {
                country = c;flag = true;
                break;
            }
        }
//        assertEquals("Japan",country.getConame());
        assertEquals(1.277558016E9,country.getPopulation());
    }

    @Test
    void gettopcountriesintheregion() throws SQLException {
        ArrayList<Country> countries5 = app.gettopCountryPopbyRegion("Caribbean", 2);
        Country country=null;boolean flag= false;
        for (Country c:countries5){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getCode().equals("DOM"))
            {
                country = c;flag = true;
                break;
            }
        }
//        assertEquals("Japan",country.getConame());
        assertEquals(8495000.0,country.getPopulation());
    }

}
