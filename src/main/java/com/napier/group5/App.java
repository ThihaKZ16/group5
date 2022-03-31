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

        System.out.println("\n All the capital cities in a continent organised by largest population to smallest.");
        ArrayList<Country> capital1= a.getCapitalPopLargesttoSmallestinacontinent("Asia");
        a.displaycapital(capital1);

        System.out.println("\n The top N populated capital cities in a continent where N is provided by the user.");
        ArrayList<Country> capital2= a.gettopNpopulatedcapitalcity("Asia", 5);
        a.displaycapital(capital2);

        System.out.println("\n All the capital cities in a region organised by largest to smallest.");
        ArrayList<Country> capital3= a.getCapitalPopLargesttoSmallestinaRegion("Caribbean");
        a.displaycapital(capital3);

        System.out.println("\n The top N populated capital cities in the world where N is provided by the user.");
        ArrayList<Country> capital4= a.gettopNpopulatedcapitalcityintheworld(16);
        a.displaycapital(capital4);

        System.out.println("\n The top N populated capital cities in a region where N is provided by the user.");
        ArrayList<Country> capital5= a.gettopNpopulatedcapitalcityinaRegion("Caribbean", 10);
        a.displaycapital(capital5);

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
        ResultSet rset =pstmt.executeQuery();
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

    public ArrayList<Country> getCapitalPopLargesttoSmallestinacontinent(String capitalcontinent) throws SQLException {
        String sql ="select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.continent = ? order by city.population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,capitalcontinent);
        ArrayList<Country> capital1 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
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

            capital1.add(cap);
        }
        return capital1;
    }

    public ArrayList<Country> gettopNpopulatedcapitalcity(String capitalcontinent, Integer number) throws SQLException {
        String sql ="select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.continent = ? order by city.population desc LIMIT ?";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,capitalcontinent);
        pstmt.setInt(2,number);
        ArrayList<Country> capital2 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
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

            capital2.add(cap);
        }
        return capital2;
    }

    public ArrayList<Country> getCapitalPopLargesttoSmallestinaRegion(String region) throws SQLException {
        String sql ="select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.region = ? order by city.population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,region);
        ArrayList<Country> capital3 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
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

            capital3.add(cap);
        }
        return capital3;
    }

    public ArrayList<Country> gettopNpopulatedcapitalcityintheworld(Integer worldtopnumber) throws SQLException {
        String sql ="select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id order by city.population desc LIMIT ?";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setInt(1,worldtopnumber);
        ArrayList<Country> capital4 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
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

            capital4.add(cap);
        }
        return capital4;
    }

    public ArrayList<Country> gettopNpopulatedcapitalcityinaRegion(String region, Integer regiontopnumber) throws SQLException {
        String sql ="select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.region = ? order by city.population desc LIMIT ?";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,region);
        pstmt.setInt(2, regiontopnumber);
        ArrayList<Country> capital5 = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
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

            capital5.add(cap);
        }
        return capital5;
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