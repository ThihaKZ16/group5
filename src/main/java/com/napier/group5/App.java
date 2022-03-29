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
        // Disconnect from database
        System.out.println("\n All the cities in the world organised by largest population to smallest.");
        ArrayList<City> cities= a.getcitiesintheworldLargesttoSmallest();
        a.display(cities);

        System.out.println("\n All the cities in a continent organised by largest population to smallest.");
        ArrayList<City> cities1= a.getcitiesinthecontinentLargesttoSmallest("'Europe'");
        a.display(cities1);

        System.out.println("\n All the cities in a region organised by largest population to smallest..");
        ArrayList<City> cities2= a.getcitiesintheregionLargesttoSmallest("Nordic Countries");
        a.display(cities2);

        System.out.println("\n All the cities in a country organised by largest population to smallest..");
        ArrayList<City> cities3= a.getcitiesinthecountryLargesttoSmallest("Finland");
        a.display(cities3);

        System.out.println("\n All the cities in a district organised by largest population to smallest..");
        ArrayList<City> cities4= a.getcitiesinthedistrictLargesttoSmallest("Dubai");
        a.display(cities4);

        System.out.println("\n The top N populated cities in the world where N is provided by the user.");
        ArrayList<City> cities5= a.getTOPNumberofPopulatedCitiesinWorld(6);
        a.display(cities5);

        System.out.println("\n The top N populated cities in a continent where N is provided by the user.");
        ArrayList<City> cities6= a.getTOPNumberofpopulatedCitieswithcontinent("Asia",7);
        a.display(cities6);

        System.out.println("\n The top N populated cities in a region where N is provided by the user.");
        ArrayList<City> cities7= a.getTOPNumberofpopulatedCitieswithregion("Western Africa",8);
        a.display(cities7);

        System.out.println("\n The top N populated cities in a country where N is provided by the user.");
        ArrayList<City> cities8= a.getTOPNumberofpopulatedCitieswithcountry("Argentina",10);
        a.display(cities8);

        System.out.println("\n The top N populated cities in a district where N is provided by the user.");
        ArrayList<City> cities9= a.getTOPNumberofpopulatedCitieswithdistrict("California",4);
        a.display(cities9);

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
    public ArrayList<City> getcitiesintheworldLargesttoSmallest() throws SQLException {
        String sql =
                "select city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  from city,country where city.countrycode = country.code order by city.Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery(sql);
        //String name, String countrycode, String district,Float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities.add(ci);
        }
        return cities;
    }

    public ArrayList<City> getcitiesinthecontinentLargesttoSmallest(String countrycontinent) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode = country.code AND country.continent= ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countrycontinent);
        ArrayList<City> cities1 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities1.add(ci);
        }
        return cities1;
    }
    public ArrayList<City> getcitiesintheregionLargesttoSmallest(String countryregion) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode = country.code AND country.region= ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryregion);
        ArrayList<City> cities2 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            cities2.add(ci);
        }
        return cities2;
    }
    //Extract the output of all the cities in a country organised by largest population to smallest.
    public ArrayList<City> getcitiesinthecountryLargesttoSmallest(String countryname) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE country.code=city.countrycode AND country.name = ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryname);
        ArrayList<City> cities3 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities3.add(ci);
        }
        return cities3;
    }

    //Extract the output of all the cities in a district organised by largest population to smallest.
    public ArrayList<City> getcitiesinthedistrictLargesttoSmallest(String citydistrict) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code AND city.district= ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,citydistrict);
        ArrayList<City> cities4 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities4.add(ci);
        }
        return cities4;
    }
    public ArrayList<City> getTOPNumberofPopulatedCitiesinWorld(Integer number) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setInt(1,number);
        ArrayList<City> cities5= new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities5.add(ci);
        }
        return cities5;
    }
    public ArrayList<City> getTOPNumberofpopulatedCitieswithcontinent(String countrycontinent,Integer number) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code AND country.continent = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countrycontinent);
        pstmt.setInt(2,number);
        ArrayList<City> cities6 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities6.add(ci);
        }
        return cities6;
    }
    public ArrayList<City> getTOPNumberofpopulatedCitieswithregion(String countryregion,Integer number) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code AND country.region = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryregion);
        pstmt.setInt(2,number);
        ArrayList<City> cities7 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities7.add(ci);
        }
        return cities7;
    }
    public ArrayList<City> getTOPNumberofpopulatedCitieswithcountry(String countryname,Integer number) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name FROM city,country WHERE city.countrycode=country.code AND country.name = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryname);
        pstmt.setInt(2,number);
        ArrayList<City> cities8 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities8.add(ci);
        }
        return cities8;
    }
    public ArrayList<City> getTOPNumberofpopulatedCitieswithdistrict(String citydistrict,Integer number) throws SQLException {
        String sql ="SELECT city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name FROM city,country WHERE city.countrycode=country.code AND city.district = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,citydistrict);
        pstmt.setInt(2,number);
        ArrayList<City> cities9 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.name= rset.getString("city.name");
            ci.countrycode= rset.getString("city.countrycode");
            ci.district = rset.getString("city.district");
            ci.population=rset.getFloat("city.population");
            ci.continent =rset.getString("country.continent");
            ci.region = rset.getString("country.region");
            ci.coname= rset.getString("country.name");
            cities9.add(ci);
        }
        return cities9;
    }

    //Extract the output of countries in a continent organised by largest population to smallest.
//    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {
//        String sql ="select Code, Name,Continent,Region, Capital, Population from country where Continent=? order by Population desc";
//        PreparedStatement pstmt =con.prepareStatement(sql);
//        pstmt.setString(1,contn);
//        ArrayList<Country> countries2 = new ArrayList<Country>();
//        ResultSet rset =pstmt.executeQuery();
//        //String code, String name, String continent, String region, String capital, float population
//        while(rset.next())
//        {
//            Country country = new Country();
//            country.code= rset.getString("country.code");
//            country.name= rset.getString("country.name");
//            country.continent = rset.getString("country.continent");
//            country.region=rset.getString("country.population");
//            country.continent =rset.getString("country.continent");
//            country.region = rset.getString("country.region");
//            country.capital
//            countries1.add(country);
//        }
//        return countries1;
//    }

    public void display(ArrayList<City> report)
    {
        // Print header
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.printf(String.format("%-16s %-8s %-16s %-16s %-16s %-16s %-16s", "City Name", "Country Code", "District", "Population","Continent","Region","Country Name"));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        // Loop over all cities in the list
        for(City ci: report)
        {
            String city_string =
                    String.format("%-16s %-8s %-16s %-16s %-16s %-16s %-16s",
                            ci.name, ci.countrycode, ci.district, ci.population,ci.continent,ci.region,ci.coname);
            System.out.printf(city_string);
            System.out.println("----------------------------------------------------------------------------------------------------------------");
        }
    }

}
//    public void display1(ArrayList<Country> report)
//    {
//        // Print header
//        System.out.println("-------------------------------------------------------------------------------");
//        System.out.printf(String.format("%-10s %-15s %-20s %-8s %-10s %-15s", "City Name", "Country Code", "District", "Population","Continent","Region"));
//        System.out.println("-------------------------------------------------------------------------------");
//        // Loop over all cities in the list
//        for(Country country: report)
//        {
//            String city_string =
//                    String.format("%-10s %-15s %-20s %-8s %-10s %-15s",
//                            country.code,country.name, country.continent, country.region,country.region,country.capital,country.population);
//            System.out.println(city_string);
//            System.out.println("-------------------------------------------------------------------------------");
//        }
//    }
//
//}
