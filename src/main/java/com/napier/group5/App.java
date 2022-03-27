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

        System.out.println("All the countries in the world organised by largest population to smallest.");
        ArrayList<Country> countries= a.getCountryPopLargesttoSmallest();
        a.display(countries);

       // System.out.println("All the countries in the continent organised by largest population to smallest.");
        //ArrayList<Country> countries2= a.getCountryPopbyContinent("Asia");
        //a.display(countries2);

        System.out.println("All the countries in a region organised by largest population to smallest.");
        ArrayList<Country> countries3= a.getCountryPopbyRegion("Caribbean");
        a.display(countries3);

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

    //Extract the output of all the countries in the world organised by largest population to smallest.
    public ArrayList<Country> getCountryPopLargesttoSmallest() throws SQLException {
        String sql ="select Code, Name,Continent,Region, Capital, Population from country order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getFloat(6));
            countries.add(c);
        }
        return countries;
    }

    //Extract the output of countries in a continent organised by largest population to smallest.
    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {
        String sql ="select Code, Name,Continent,Region, Capital, Population from country where Continent=? order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,contn);
        ArrayList<Country> countries2 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4), rset.getString(5),rset.getFloat(6));
            countries2.add(c);
        }
        return countries2;
    }

    //Extract the output of countries in a region organised by largest population to smallest.
    public ArrayList<Country> getCountryPopbyRegion(String contn) throws SQLException {
        String sql ="select Code,Name,Continent,Region,Capital,Population from country where Region=? order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,contn);
        ArrayList<Country> countries3 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4), rset.getString(5),rset.getFloat(6));
            countries3.add(c);
        }
        return countries3;
    }

    //Display function
    public void display(ArrayList<Country> conts)
    {
        for(Country c: conts)
        {
            System.out.println(c.getCode()+"\t"+c.getName()+"\t"+c.getContinent()+"\t"+c.getRegion()+"\t"+c.getCapital()+"\t"+c.getPopulation());
        }
    }

}
