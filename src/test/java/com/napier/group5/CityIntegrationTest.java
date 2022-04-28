/** import package from com.napier.group5 */
package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** create public class "CityIntegrationTest" */
public class CityIntegrationTest
{
    static App app;

    /** connection with app.java with localhost:33060 */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }


    /** integration test for the total cities in the world*/
    @Test
    void getcitiesintheworld() throws SQLException {
        ArrayList<City> cities = app.getcitiesintheworldLargesttoSmallest();
        City city=null;boolean flag= false;
        for (City c:cities){
            //2710,'Rangoon (Yangon)','MMR','Rangoon [Yangon]',3361700
            if (c.getId() == 2710)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes*/
        assertEquals("Rangoon (Yangon)",city.getName());
        assertEquals(3361700,city.getPopulation());
    }

    /** integration test for the total cities in the continent*/
    @Test
    void getcitiesinthecontinent() throws SQLException {
        ArrayList<City> cities1 = app.getcitiesinthecontinentLargesttoSmallest("Asia");
        City city=null;boolean flag= false;
        for (City c:cities1){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (c.getId() == 1134)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes*/
        assertEquals("South Dum Dum",city.getName());
        assertEquals(232811,city.getPopulation());
    }

    /** integration test for the total cites in the region */
    @Test
    void getcitiesintheregion() throws SQLException {
        ArrayList<City> cities2 = app.getcitiesintheregionLargesttoSmallest("British Islands");
        City city=null;boolean flag= false;
        for (City c:cities2){
            //499,'Poole','GBR','England',141000

            if (c.getId() == 499)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */

        assertEquals("GBR",city.getCountryCode());
        assertEquals("Poole",city.getName());

    }

    /** integration test for the total cities in the country */
    @Test
    void getcitiesinthecountry() throws SQLException {
        ArrayList<City> cities3 = app.getcitiesinthecountryLargesttoSmallest("Finland");
        City city=null;boolean flag= false;
        for (City c:cities3){


            if (c.getId() == 3236)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */

        assertEquals("Newmaa",city.getDistrict());
        assertEquals(555474,city.getPopulation());
        assertEquals("FIN",city.getCountryCode());
        assertEquals("Helsinki [Helsingfors]",city.getName());
    }

    /** integration test for the total cities in the district */
    @Test
    void getcitiesinthedistrict() throws SQLException {
        ArrayList<City> cities4 = app.getcitiesinthedistrictLargesttoSmallest("Shanghai");
        City city=null;boolean flag= false;
        for (City c:cities4){


            if (c.getId() == 1890)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */

        assertEquals(9696300,city.getPopulation());
        assertEquals("CHN",city.getCountryCode());
        assertEquals("Shanghai",city.getName());
    }

    /** integration test for the top N populated cities in the world */
    @Test
    void TopNPopulatedCitiesintheWorld() throws SQLException {
        ArrayList<City> cities5 = app.getTOPNumberofPopulatedCitiesinWorld(6);
        City city=null;boolean flag= false;
        for (City c:cities5){

            if (c.getId() == 2331)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("KOR",city.getCountryCode());
        assertEquals(9981619,city.getPopulation());
    }

    /** integration test for the top N populated cities in the continent */
    @Test
    void TopNPopulatedCitiesinaContinent() throws SQLException {
        ArrayList<City> cities6 = app.getTOPNumberofpopulatedCitieswithcontinent("Asia",3);
        City city=null;boolean flag= false;
        for (City c:cities6){
            //1024             Mumbai (Bombay) IND              Maharashtra      1.05E7           Asia             Southern and Central Asia

            if (c.getId() == 1024)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("Mumbai (Bombay)",city.getName());
        assertEquals("Maharashtra",city.getDistrict());
        assertEquals("Asia", city.getContinent());
        assertEquals("Southern and Central Asia", city.getRegion());
    }

    /** integration test for the top N populated cities in the region */
    @Test
    void TopNPopulatedCitiesinaRegion() throws SQLException {
        ArrayList<City> cities7 = app.getTOPNumberofpopulatedCitieswithregion("Western Africa",10);
        City city=null;boolean flag= false;
        for (City c:cities7){

            if (c.getId() == 2440)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("Africa",city.getContinent());
        assertEquals(850000,city.getPopulation());
        assertEquals("Monrovia",city.getName());
    }

     /** integration test for the top N populated cities in the country*/
    @Test
    void TopNPopulatedCitiesinaCountry() throws SQLException {
        ArrayList<City> cities8 = app.getTOPNumberofpopulatedCitieswithcountry("Argentina",10);
        City city=null;boolean flag= false;
        for (City c:cities8){
            //73               Lomas de Zamora ARG              Buenos Aires     622013.0         South America    South America
            if (c.getId() == 73)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("Buenos Aires",city.getDistrict());
        assertEquals("ARG",city.getCountryCode());
        assertEquals("South America",city.getRegion());
    }

    /** integration test for the top N populated cities in the district */
    @Test
    void TopNPopulatedCitiesinaDistrict() throws SQLException {
        ArrayList<City> cities9 = app.getTOPNumberofpopulatedCitieswithdistrict("California",4);
        City city=null;boolean flag= false;
        for (City c:cities9){
            //3805             San Francisco USA              California       776733.0         North America    North America
            if (c.getId() == 3805)
            {
                city = c;flag = true;
                break;
            }
        }

        /** test with the following attributes */
        assertEquals("North America",city.getRegion());
        assertEquals("USA", city.getCountryCode());
        assertEquals(776733, city.getPopulation());
        assertEquals("North America", city.getContinent());
        assertEquals("United States", city.getConame());
    }

}