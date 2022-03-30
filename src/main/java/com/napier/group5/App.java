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

        System.out.println("\n All the capital cities in the world organised by largest population to smallest.");
        ArrayList<Country> capital= a.getCapitalPopLargesttoSmallestintheworld();
        a.displaycapital(capital);

//        System.out.println("\n All the countries in a continent organised by largest population to smallest.");
//        ArrayList<Country> countries1= a.getCountryPopbyContinent("Asia");
//        a.displaycountry(countries1);
//
//        System.out.println("\n All the countries in a region organised by largest population to smallest.");
//        ArrayList<Country> countries2= a.getCountryPopbyRegion("Caribbean");
//        a.displaycountry(countries2);
//
//        System.out.println("\n The top N populated countries in the world where N is provided by the user.");
//        ArrayList<Country> countries4= a.gettopCountryPopLargesttoSmallest(3);
//        a.displaycountry(countries4);
//
//        System.out.println("\n The top N populated countries in a continent where N is provided by the user.");
//        ArrayList<Country> countries5= a.gettopCountryPopbyContinent("Asia",2);
//        a.displaycountry(countries5);
//
//        System.out.println("\n The top N populated countries in a region where N is provided by the user.");
//        ArrayList<Country> countries6= a.gettopCountryPopbyRegion("Caribbean",2);
//        a.displaycountry(countries6);

        // Disconnect to database
        a.disconnect ();

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

    //Extract all populated countries on the world
    public ArrayList<Country> getCapitalPopLargesttoSmallestintheworld() throws SQLException {
        String sql ="select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id order by city.population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<Country> capital = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery(sql);
        //String code, String name, String continent, String region, String capital-name, float population
        while(rset.next())
        {
            Country cap = new Country();
            cap.code = rset.getString("country.capital");
            cap.coname= rset.getString("country.name");
            cap.continent = rset.getString("country.continent");
            cap.region = rset.getString("country.region");
            cap.name = rset.getString("city.name");
            cap.population = rset.getFloat("city.population");

            capital.add(cap);
        }
        return capital;
    }


    //display function
    public void displaycapital(ArrayList<Country> capitalreport)
    {
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.printf(String.format("%-16s %-25s %-20s %-20s %-20s %-16s", "Capital Code", "Country Name", "Continent", "Region","Capital City","Population"));
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
        // Loop over all cities in the list
        for(Country cap: capitalreport)
        {
            String capital_string =
                    String.format("%-16s %-25s %-20s %-20s %-20s %-16s",
                            cap.code, cap.coname, cap.continent, cap.region,cap.name,cap.population);
            System.out.printf(capital_string);
            System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        }
    }
}