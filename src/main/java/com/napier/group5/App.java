package com.napier.group5;

import java.sql.*;
import java.util.ArrayList;

public class App {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) throws SQLException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect("db:3306", 30000);

        System.out.println("All the cities in the world organised by largest population to smallest.");
        ArrayList<City> cities= a.getcitiesintheworldLargesttoSmallest();
        a.display(cities);

        System.out.println("All the cities in a continent organised by largest population to smallest.");
        ArrayList<City> cities1= a.getcitiesinthecontinentLargesttoSmallest();
        a.display(cities1);

        System.out.println("All the cities in a region organised by largest population to smallest..");
        ArrayList<City> cities2= a.getcitiesintheregionLargesttoSmallest();
        a.display(cities2);

        System.out.println("All the cities in a country organised by largest population to smallest..");
        ArrayList<City> cities3= a.getcitiesinthecountryLargesttoSmallest();
        a.display(cities3);

        System.out.println("All the cities in a district organised by largest population to smallest..");
        ArrayList<City> cities4= a.getcitiesinthedistrictLargesttoSmallest();
        a.display(cities4);

        // Disconnect from database
        a.disconnect();
    }

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

    //Extract the output of all the cities in the world organised by largest population to smallest.
    public ArrayList<City> getcitiesintheworldLargesttoSmallest() throws SQLException {
        String sql ="select name,countrycode,district,population from city order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String countrycode, String district,Float population
        while(rset.next())
        {City  ci = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
            cities.add(ci);
        }
        return cities;
    }

    //Extract the output of all the cities in a continent organised by largest population to smallest.
    public ArrayList<City> getcitiesinthecontinentLargesttoSmallest() throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population FROM city,country WHERE city.countrycode = country.code AND country.continent= 'Asia' ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities1 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  ci = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
            cities1.add(ci);
        }
        return cities1;
    }

    //Extract the output of all the cities in a region organised by largest population to smallest.
    public ArrayList<City> getcitiesintheregionLargesttoSmallest() throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population FROM city,country WHERE city.countrycode = country.code AND country.region= 'Western Africa' ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities2 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  ci = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
            cities2.add(ci);
        }
        return cities2;
    }

    //Extract the output of all the cities in a country organised by largest population to smallest.
    public ArrayList<City> getcitiesinthecountryLargesttoSmallest() throws SQLException {
        String sql ="SELECT name,countrycode,district,population FROM city WHERE countrycode='AUS' ORDER BY Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities3 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  ci = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
            cities3.add(ci);
        }
        return cities3;
    }

    //Extract the output of all the cities in a district organised by largest population to smallest.
    public ArrayList<City> getcitiesinthedistrictLargesttoSmallest() throws SQLException {
        String sql ="SELECT name,countrycode,district,population FROM city WHERE district='Dubai' ORDER BY Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities4 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  ci = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
            cities4.add(ci);
        }
        return cities4;
    }

    //Display function
    public void display(ArrayList<City> conts)
    {
        for(City ci: conts)
        {
            System.out.println(ci.getName()+"\t"+ci.getCountryCode()+"\t"+ci.getDistrict()+"\t"+ci.getPopulation());
        }
    }

}
