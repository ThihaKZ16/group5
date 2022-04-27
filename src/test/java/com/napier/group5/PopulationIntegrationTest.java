//Declare package from com.napier.group5 for Integration Test
package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Create public class for population Integration Test */
public class PopulationIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);

    }

    /** Test for Total Population in the Continent */
    @Test
    void gettotalPopulationintheContinent() throws SQLException {
        ArrayList<Country> population2= app.gettotalpopulationinthecontinent("Asia");
        Country country=null;boolean flag= false;
        for (Country c:population2){
            //2710,'Rangoon (Yangon)','MMR','Rangoon [Yangon]',3361700
            if (c.getPopulation() == 3.70502579E9)
            {
                country = c;flag = true;
                break;
            }
        }
    }

    /** Test for Population in the Region */
    @Test
    void gettotalPopulationintheRegion() throws SQLException {
        ArrayList<Country> population3= app.gettotalpopulationintheregion("Micronesia   ");
        Country country=null;boolean flag= false;
        for (Country c:population3){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getPopulation() == 543000)
            {
                country = c;flag = true;
            }
        }
    }

    /** Test for Population in the Country */
    @Test
    void gettotalPopulationintheCountry() throws SQLException {
        ArrayList<Country> population4= app.gettotalpopulationinthecountry("Japan");
        Country country=null;boolean flag= false;
        for (Country c:population4){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getPopulation() == 1.26714E8)
            {
                country = c;flag = true;
            }
        }
    }

    /** Test for Population in the District */
    @Test
    void gettotalPopulationintheDistrict() throws SQLException {
        ArrayList<City> population5= app.gettotalpopulationinthedistrict("Zuid-Holland");
        City city=null;boolean flag= false;
        for (City c:population5){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getPopulation() == 1476710)
            {
                city = c;flag = true;
            }
        }
    }

    /** Test for Population in the City */
    @Test
    void gettotalPopulationintheCity() throws SQLException {
        ArrayList<City> population6= app.gettotalpopulationinthecity("Rangoon (Yangon)");
        City city=null;boolean flag= false;
        for (City c:population6){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getPopulation() == 3361700)
            {
                city = c;flag = true;
            }
        }
        assertEquals("MMR",city.getCountryCode());
    }
}