package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);

    }

//    @Test
//    void testGetEmployee()
//    {
//        Employee emp = app.getEmployee(255530);
//        assertEquals(emp.emp_no, 255530);
//        assertEquals(emp.first_name, "Ronghao");
//        assertEquals(emp.last_name, "Garigliano");
//    }

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
        assertEquals("Rangoon (Yangon)",city.getName());
        assertEquals(3361700,city.getPopulation());
    }

//    private void assertEquals(int i, float population) {
//    }

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
        assertEquals("South Dum Dum",city.getName());
        assertEquals(232811,city.getPopulation());
    }

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
        //GBR','United Kingdom','Europe','British Islands
        assertEquals("GBR",city.getCountryCode());
        assertEquals("Poole",city.getName());

    }

    @Test
    void getcitiesinthecountry() throws SQLException {
        ArrayList<City> cities3 = app.getcitiesinthecountryLargesttoSmallest("Finland");
        City city=null;boolean flag= false;
        for (City c:cities3){
            //3236,'Helsinki [Helsingfors]','FIN','Newmaa',555474

            if (c.getId() == 3236)
            {
                city = c;flag = true;
                break;
            }
        }
        //FIN','Finland','Europe','Nordic Countries
        assertEquals("Newmaa",city.getDistrict());
        assertEquals(555474,city.getPopulation());
        assertEquals("FIN",city.getCountryCode());
        assertEquals("Helsinki [Helsingfors]",city.getName());
    }

    @Test
    void getcitiesinthedistrict() throws SQLException {
        ArrayList<City> cities4 = app.getcitiesinthedistrictLargesttoSmallest("Shanghai");
        City city=null;boolean flag= false;
        for (City c:cities4){
            //1890,'Shanghai','CHN','Shanghai',9696300

            if (c.getId() == 1890)
            {
                city = c;flag = true;
                break;
            }
        }
        //'CHN','China','Asia','Eastern Asia'
        assertEquals(9696300,city.getPopulation());
        assertEquals("CHN",city.getCountryCode());
        assertEquals("Shanghai",city.getName());
    }

}