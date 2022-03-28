package com.napier.group5;

import java.sql.*;
import java.util.ArrayList;

public class App {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) throws SQLException {
        // Create new Application and connect db
        App a = new App();

        // Connect to database
        a.connect("db:3306", 30000);
        System.out.println("In main");
        ArrayList<Country> contries= a.getCountryPopLargesttoSmallest();
        a.display(contries);
        System.out.println("*****************************************************\nContinent\n");
        ArrayList<Country> contries2= a.getCountryPopbyContinent("Asia");
        a.display(contries2);
        ArrayList<Country> contries3= a.getCountryPopbyRegion("Caribbean");
        a.display(contries3);

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
     public ArrayList<Country> getCountryPopLargesttoSmallest() throws SQLException {
        String sql ="select Code, Name,Continent,Region, Capital, Population from country order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getFloat(6));
            countries.add(c);
        }
        return countries;
    }

    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {
        String sql ="select Code, Name,Continent,Region, Capital, Population from country where Continent=? order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,contn);
        ArrayList<Country> countries2 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4), rset.getString(5),rset.getFloat(6));
            countries2.add(c);
        }
        return countries2;
    }
    public ArrayList<Country> getCountryPopbyRegion(String contn) throws SQLException {
        String sql ="select Code,Name,Continent,Region,Capital,Population from country where Region=? order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,contn);
        ArrayList<Country> countries3 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4), rset.getString(5),rset.getFloat(6));
            countries3.add(c);
        }
        return countries3;
    }
    public void display(ArrayList<Country> contries)
    {
        for(Country c: contries)
        {
            System.out.println(c.getCode()+"\t"+c.getName()+"\t"+c.getContinent()+"\t"+c.getRegion()+"\t"+c.getCapital()+"\t"+c.getPopulation());
        }
    }

    //Display function
    public void display(ArrayList<City> cities)
    {
        for(City ci: cities)
        {
            System.out.println(ci.getName()+"\t"+ci.getCountryCode()+"\t"+ci.getDistrict()+"\t"+ci.getPopulation());
        }
    }
   

}
