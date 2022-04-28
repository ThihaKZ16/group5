package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Create public class for Capitalcity Integration Test*/
public class CapitalcityIntegrationTesting
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);

    }




    @Test
    /**Test for World population in the world*/
    void getcapitalcitiesintheworld() throws SQLException {
        ArrayList<Country> capital = app.getCapitalPopLargesttoSmallestintheworld();
        Country country=null;boolean flag= false;
        for (Country cap:capital){
            //2710,'Rangoon (Yangon)','MMR','Rangoon [Yangon]',3361700
            if (cap.getCode().equals("2413") )
            {
                country = cap;flag = true;
                break;
            }
        }
        assertEquals("Cuba",country.getConame());
        assertEquals(2256000,country.getPopulation());
    }

    @Test
    /**Test for Capital City population in the continent*/
    void getcapitalcitiesinthecontinent() throws SQLException {
        ArrayList<Country> capital1 = app.getCapitalPopLargesttoSmallestinacontinent("Asia");
        Country country=null;boolean flag= false;
        for (Country cap:capital1){
            //1134,'South Dum Dum','IND','West Bengali',232811
            if (cap.getCode().equals("3320"))
            {
                country = cap;flag = true;
                break;
            }
        }
        assertEquals("Thailand",country.getConame());
        assertEquals(6320174,country.getPopulation());
    }

    @Test
    /**Test for Top Number capital city population in the continent*/
    void gettopNpopulatedcapitalcitieswithcontinent() throws SQLException {
        ArrayList<Country> capital2 = app.gettopNpopulatedcapitalcity("Asia", 5);
        Country country=null;boolean flag= false;
        for (Country cap:capital2){


            if (cap.getCode().equals("939"))
            {
                country = cap;flag = true;
                break;
            }
        }

        assertEquals("Indonesia",country.getConame());
        assertEquals(9604900,country.getPopulation());

    }

    @Test
    /**Test for Capital city population in the region*/
    void getcapitalcitiesintheregion() throws SQLException {
        ArrayList<Country> capital3 = app.getCapitalPopLargesttoSmallestinaRegion("Caribbean");
        Country country=null;boolean flag= false;
        for (Country cap:capital3){
            //3236,'Helsinki [Helsingfors]','FIN','Newmaa',555474

            if (cap.getCode().equals("587"))
            {
                country = cap;flag = true;
                break;
            }
        }
        //FIN','Finland','Europe','Nordic Countries
        assertEquals("Dominican Republic",country.getConame());
        assertEquals(1609966,country.getPopulation());
        assertEquals("587",country.getCode());
        assertEquals("Santo Domingo de Guzmán",country.getName());
    }

    @Test
    void gettopcapitalcitiesintheworld() throws SQLException {
        ArrayList<Country> capital4 = app.gettopNpopulatedcapitalcityintheworld(16);
        Country country=null;boolean flag= false;
        for (Country cap:capital4){
            //3236,'Helsinki [Helsingfors]','FIN','Newmaa',555474

            if (cap.getCode().equals("2515"))
            {
                country = cap;flag = true;
                break;
            }
        }
        //FIN','Finland','Europe','Nordic Countries
        assertEquals("Mexico",country.getConame());
        assertEquals(8591309,country.getPopulation());
        assertEquals("Ciudad de México",country.getName());
    }

    @Test
    /**Test for Capital City population in the region*/
    void gettopcapitalcitiesintheregion() throws SQLException {
        ArrayList<Country> capital5 = app.gettopNpopulatedcapitalcityinaRegion( "Caribbean",16);
        Country country=null;boolean flag= false;
        for (Country cap:capital5){
            //3236,'Helsinki [Helsingfors]','FIN','Newmaa',555474

            if (cap.getCode().equals("929"))
            {
                country = cap;flag = true;
                break;
            }
        }
        //FIN','Finland','Europe','Nordic Countries
        assertEquals("Haiti",country.getConame());
        assertEquals(884472,country.getPopulation());
        assertEquals("Port-au-Prince",country.getName());
    }


}