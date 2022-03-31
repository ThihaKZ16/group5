package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class cities
{
    static App app;
    private Connection con = null;
    /**
     * Connect to the MySQL database.

     */
    public void connect(String conString, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                //Added allowPublicKeyRetrieval=true to get Integration Tests to work. Possibly due to accessing from another class?
                con = DriverManager.getConnection("jdbc:mysql://" + conString + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 0);
    }

    @Test
    void displayTestNull()
    {
        app.display(null);
    }

    @Test
    void displayTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.display(cities);
    }

    @Test
    void displayTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.display(cities);
    }

    @Test
    void display()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City ci = new City();
        ci.name= "Seoul";
        ci.countrycode= "KOR" ;
        ci.district = "Seoul";
        ci.population= 9981619;
        ci.continent ="Asia";
        ci.region = "Eastern Asia";
        ci.coname= "South Korea";

        cities.add(ci);
        app.display(cities);
    }

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

}