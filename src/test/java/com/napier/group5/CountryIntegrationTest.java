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


}
