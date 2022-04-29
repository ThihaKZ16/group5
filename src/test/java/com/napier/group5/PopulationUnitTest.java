//Declare package from com.napier.group5 for unit testing
package com.napier.group5;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/** Create public class for population unit testing */
public class PopulationUnitTest
{

    static App app;
    /** Connect app.java with the unit testing file */
    @BeforeAll
    static void init()
    {
        app = new App();
        //app.connect("localhost:33060", 0);
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