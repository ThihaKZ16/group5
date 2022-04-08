package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalcityIntegrationTesting
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
    void gettopNpopulatedcapitalcitieswithcontinent() throws SQLException {
        ArrayList<Country> capital2 = app.gettopNpopulatedcapitalcity("Asia", 5);
        Country country=null;boolean flag= false;
        for (Country cap:capital2){
            //499,'Poole','GBR','England',141000

            if (cap.getCode().equals("939"))
            {
                country = cap;flag = true;
                break;
            }
        }
        //GBR','United Kingdom','Europe','British Islands
        assertEquals("Indonesia",country.getConame());
        assertEquals(9604900,country.getPopulation());

    }

    @Test
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
//
//

//    @Test
//    void TopNPopulatedCitiesintheWorld() throws SQLException {
//        ArrayList<City> cities5 = app.getTOPNumberofPopulatedCitiesinWorld(6);
//        City city=null;boolean flag= false;
//        for (City c:cities5){
//            //2331             Seoul    KOR              Seoul            9981619.0        Asia             Eastern Asia
//
//            if (c.getId() == 2331)
//            {
//                city = c;flag = true;
//                break;
//            }
//        }
//        assertEquals("KOR",city.getCountryCode());
//        assertEquals(9981619,city.getPopulation());
//    }
//
//    @Test
//    void TopNPopulatedCitiesinaContinent() throws SQLException {
//        ArrayList<City> cities6 = app.getTOPNumberofpopulatedCitieswithcontinent("Asia",3);
//        City city=null;boolean flag= false;
//        for (City c:cities6){
//            //1024             Mumbai (Bombay) IND              Maharashtra      1.05E7           Asia             Southern and Central Asia
//
//            if (c.getId() == 1024)
//            {
//                city = c;flag = true;
//                break;
//            }
//        }
//        assertEquals("Mumbai (Bombay)",city.getName());
//        assertEquals("Maharashtra",city.getDistrict());
//        assertEquals("Asia", city.getContinent());
//        assertEquals("Southern and Central Asia", city.getRegion());
//    }
//
//    @Test
//    void TopNPopulatedCitiesinaRegion() throws SQLException {
//        ArrayList<City> cities7 = app.getTOPNumberofpopulatedCitieswithregion("Western Africa",10);
//        City city=null;boolean flag= false;
//        for (City c:cities7){
//            //2440             Monrovia         LBR              Montserrado      850000.0         Africa           Western Africa
//            if (c.getId() == 2440)
//            {
//                city = c;flag = true;
//                break;
//            }
//        }
//        assertEquals("Africa",city.getContinent());
//        assertEquals(850000,city.getPopulation());
//        assertEquals("Monrovia",city.getName());
//    }
//
//    @Test
//    void TopNPopulatedCitiesinaCountry() throws SQLException {
//        ArrayList<City> cities8 = app.getTOPNumberofpopulatedCitieswithcountry("Argentina",10);
//        City city=null;boolean flag= false;
//        for (City c:cities8){
//            //73               Lomas de Zamora ARG              Buenos Aires     622013.0         South America    South America
//            if (c.getId() == 73)
//            {
//                city = c;flag = true;
//                break;
//            }
//        }
//        assertEquals("Buenos Aires",city.getDistrict());
//        assertEquals("ARG",city.getCountryCode());
//        assertEquals("South America",city.getRegion());
//    }
//
//    @Test
//    void TopNPopulatedCitiesinaDistrict() throws SQLException {
//        ArrayList<City> cities9 = app.getTOPNumberofpopulatedCitieswithdistrict("California",4);
//        City city=null;boolean flag= false;
//        for (City c:cities9){
//            //3805             San Francisco USA              California       776733.0         North America    North America
//            if (c.getId() == 3805)
//            {
//                city = c;flag = true;
//                break;
//            }
//        }
//        assertEquals("North America",city.getRegion());
//        assertEquals("USA", city.getCountryCode());
//        assertEquals(776733, city.getPopulation());
//        assertEquals("North America", city.getContinent());
//        assertEquals("United States", city.getConame());
//    }

}