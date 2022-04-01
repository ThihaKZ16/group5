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
        if (args.length < 1) {
            a.connect("localhost:33060", 0);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }
        ;

        System.out.println("\n All the countries in the world organised by largest population to smallest.");
        ArrayList<Country> countries = a.getCountryPopLargesttoSmallest();
        a.displaycountry(countries);

        System.out.println("\n All the countries in a continent organised by largest population to smallest.");
        ArrayList<Country> countries1 = a.getCountryPopbyContinent("Asia");
        a.displaycountry(countries1);

        System.out.println("\n All the countries in a region organised by largest population to smallest.");
        ArrayList<Country> countries2 = a.getCountryPopbyRegion("Caribbean");
        a.displaycountry(countries2);

        System.out.println("\n The top N populated countries in the world where N is provided by the user.");
        ArrayList<Country> countries4 = a.gettopCountryPopLargesttoSmallest(3);
        a.displaycountry(countries4);

        System.out.println("\n The top N populated countries in a continent where N is provided by the user.");
        ArrayList<Country> countries5 = a.gettopCountryPopbyContinent("Asia", 2);
        a.displaycountry(countries5);

        System.out.println("\n The top N populated countries in a region where N is provided by the user.");
        ArrayList<Country> countries6 = a.gettopCountryPopbyRegion("Caribbean", 2);
        a.displaycountry(countries6);

        // Disconnect to database
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

    //Extract all populated countries on the world
    public ArrayList<Country> getCountryPopLargesttoSmallest() throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country,city where country.capital = city.id order by country.population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery(sql);
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setConame(rset.getString("country.name"));
            c.setContinent(rset.getString("country.continent"));
            c.setRegion(rset.getString("country.region"));
            c.setName(rset.getString("city.name"));
            c.setPopulation(rset.getFloat("country.population"));
            countries.add(c);
        }
        return countries;
    }

    //Extract populated countries from a continent
    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country, city where country.capital = city.id AND country.continent=? order by country.population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Country> countries2 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setConame(rset.getString("country.name"));
            c.setContinent(rset.getString("country.continent"));
            c.setRegion(rset.getString("country.region"));
            c.setName(rset.getString("city.name"));
            c.setPopulation(rset.getFloat("country.population"));


            countries2.add(c);
        }
        return countries2;
    }

    //Extract populated countries from a region
    public ArrayList<Country> getCountryPopbyRegion(String contn) throws SQLException {
        String sql = "select country.code,country.name,country.continent,country.region,city.name,country.population from country,city where country.capital = city.id AND country.region=? order by country.population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Country> countries3 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setConame(rset.getString("country.name"));
            c.setContinent(rset.getString("country.continent"));
            c.setRegion(rset.getString("country.region"));
            c.setName(rset.getString("city.name"));
            c.setPopulation(rset.getFloat("country.population"));

            countries3.add(c);
        }
        return countries3;
    }

    //Extract top populated countries on the world
    public ArrayList<Country> gettopCountryPopLargesttoSmallest(Integer count) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country,city where country.capital = city.id order by country.population desc LIMIT ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, count);
        ArrayList<Country> countries4 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setConame(rset.getString("country.name"));
            c.setContinent(rset.getString("country.continent"));
            c.setRegion(rset.getString("country.region"));
            c.setName(rset.getString("city.name"));
            c.setPopulation(rset.getFloat("country.population"));

            countries4.add(c);
        }
        return countries4;
    }

    //Extract top populated countries from a continent
    public ArrayList<Country> gettopCountryPopbyContinent(String contn, Integer continent) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country, city where country.capital = city.id AND country.continent=? order by country.population desc LIMIT ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        pstmt.setInt(2, continent);
        ArrayList<Country> countries5 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setConame(rset.getString("country.name"));
            c.setContinent(rset.getString("country.continent"));
            c.setRegion(rset.getString("country.region"));
            c.setName(rset.getString("city.name"));
            c.setPopulation(rset.getFloat("country.population"));

            countries5.add(c);
        }
        return countries5;
    }

    //Extract top populated countries from a region
    public ArrayList<Country> gettopCountryPopbyRegion(String region, Integer reg) throws SQLException {
        String sql = "select country.code,country.name,country.continent,country.region,city.name,country.population from country,city where country.capital = city.id AND country.region=? order by country.population desc LIMIT ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, region);
        pstmt.setInt(2, reg);
        ArrayList<Country> countries6 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setConame(rset.getString("country.name"));
            c.setContinent(rset.getString("country.continent"));
            c.setRegion(rset.getString("country.region"));
            c.setName(rset.getString("city.name"));
            c.setPopulation(rset.getFloat("country.population"));

            countries6.add(c);
        }
        return countries6;
    }

    //display function
    public void displaycountry(ArrayList<Country> countryreport) {
        if (countryreport == null) {
            System.out.println("No null values in country data");
            return;
        } else if (countryreport.size() == 0)
            System.out.println("There is no country");
        else {

                System.out.println("-------------------------------------------------------------------------------------------------------------------");
                System.out.printf(String.format("%-16s %-25s %-20s %-20s %-20s %-16s", "Country Code", "Country Name", "Continent", "Region", "Capital City", "Population"));
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
        // Loop over all cities in the list
                for (Country c : countryreport) {
                    if (c == null)
                        continue;
                    String country_string =
                        String.format("%-16s %-25s %-20s %-20s %-20s %-16s",
                            c.getCode(), c.getConame(), c.getContinent(), c.getRegion(), c.getName(), c.getPopulation());
                    System.out.printf(country_string);
                    System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        }
    }
 }
}