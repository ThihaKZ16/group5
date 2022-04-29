package com.napier.group5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public class UnitTesting {
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
    void displayTestNull1()
    {
        app.displaycountry(null);
    }
    /** test size for display */
    @Test
    void displayTestEmpty1()
    {

        ArrayList<Country> countries = new ArrayList<Country>();
        app.displaycountry(countries);
    }

    /** test if there are null values in display */
    @Test
    void displayTestContainsNull1()
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
    /** Test Null value for displaycity */
    @Test
    void displayTestNull2()
    {
        app.display(null);
    }
    /** Test size for displaycity */
    @Test
    void displayTestEmpty2()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.display(cities);
    }
    /** Test if displaycity contains null value */
    @Test
    void displayTestContainsNull2()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.display(cities);
    }
    /** Test display city */
    @Test
    void display2()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City ci = new City();
        ci.setName("Seoul");
        ci.setCountryCode("KOR");
        ci.setDistrict("Seoul");
        ci.setPopulation(9981619);
        ci.setContinent("Asia");
        ci.setRegion("Eastern Asia");
        ci.setConame("South Korea");
        cities.add(ci);
        app.display(cities);
    }
    /** Test Null value for displaycapital */
    @Test
    void displayTestNull3()
    {
        app.display(null);
    }
    /** Test size for displaycapital */
    @Test
    void displayTestEmpty3()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        app.displaycapital(capitalreport);
    }
    /** Test if displaycapital contains null value */
    @Test
    void displayTestContainsNull3()
    {
        ArrayList<Country> capitalreport = new ArrayList<Country>();
        capitalreport.add(null);
        app.displaycapital(capitalreport);
    }
    /** Test display capitalcity */
    @Test
    void display3()
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

    /** Test Null value for displaypopulation1 */
    @Test
    void displaypopulation1TestNull()
    {
        app.displaypopulation1(null);
    }
    /** Test size for displaypopulation1 */
    @Test
    void displaypopulation1TestEmpty()
    {
        ArrayList<Country> populationreport = new ArrayList<Country>();
        app.displaypopulation1(populationreport);
    }
    /** Test if displaypopulation1 contains null value */
    @Test
    void displaypopulation1ContainsNull()
    {
        ArrayList<Country> populationreport = new ArrayList<Country>();
        populationreport.add(null);
        app.displaypopulation1(populationreport);
    }
    /** Test Null value for displaypopulation2 */
    @Test
    void displaypopulation2TestNull()
    {
        app.displaypopulation2(null);
    }
    /** Test size for displaypopulation2 */
    @Test
    void displaypopulation2TestEmpty()
    {
        ArrayList<Country> populationcontinent = new ArrayList<Country>();
        app.displaypopulation2(populationcontinent);
    }
    /** Test if displaypopulation2 contains null value */
    @Test
    void displaypopulation2ContainsNull()
    {
        ArrayList<Country> populationcontinent = new ArrayList<Country>();
        populationcontinent.add(null);
        app.displaypopulation2(populationcontinent);
    }
    /** Test Null value for displaypopulation3 */
    @Test
    void displaypopulation3TestNull()
    {
        app.displaypopulation3(null);
    }
    /** Test size for displaypopulation3 */
    @Test
    void displaypopulation3TestEmpty()
    {
        ArrayList<Country> populationregion = new ArrayList<Country>();
        app.displaypopulation3(populationregion);
    }

    /** Test if displaypopulation3 contains null value */
    @Test
    void displaypopulation3ContainsNull()
    {
        ArrayList<Country> populationregion = new ArrayList<Country>();
        populationregion.add(null);
        app.displaypopulation3(populationregion);
    }
    /** Test Null value for displaypopulation4 */
    @Test
    void displaypopulation4TestNull()
    {
        app.displaypopulation4(null);
    }
    /** Test size for displaypopulation4 */
    @Test
    void displaypopulation4TestEmpty()
    {
        ArrayList<Country> populationcountry = new ArrayList<Country>();
        app.displaypopulation4(populationcountry);
    }
    /** Test if displaypopulation4 contains null value */
    @Test
    void displaypopulation4ContainsNull()
    {
        ArrayList<Country> populationcountry = new ArrayList<Country>();
        populationcountry.add(null);
        app.displaypopulation4(populationcountry);
    }
    /** Test Null value for displaypopulation5 */
    @Test
    void displaypopulation5TestNull()
    {
        app.displaypopulation5(null);
    }
    /** Test size for displaypopulation5 */
    @Test
    void displaypopulation5TestEmpty()
    {
        ArrayList<City> populationdistrict = new ArrayList<City>();
        app.displaypopulation5(populationdistrict);
    }
    /** Test if displaypopulation5 contains null value */
    @Test
    void displaypopulation5ContainsNull()
    {
        ArrayList<City> populationdistrict = new ArrayList<City>();
        populationdistrict.add(null);
        app.displaypopulation5(populationdistrict);
    }

    /** Test Null value for displaypopulation6 */
    @Test
    void displaypopulation6TestNull()
    {
        app.displaypopulation6(null);
    }
    /** Test size for displaypopulation6 */
    @Test
    void displaypopulation6TestEmpty()
    {
        ArrayList<City> populationcity = new ArrayList<City>();
        app.displaypopulation6(populationcity);
    }
    /** Test if displaypopulation6 contains null value */
    @Test
    void displaypopulation6ContainsNull()
    {
        ArrayList<City> populationcity = new ArrayList<City>();
        populationcity.add(null);
        app.displaypopulation6(populationcity);
    }
}
