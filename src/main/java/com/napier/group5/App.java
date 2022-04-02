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

        if(args.length < 1){
            a.connect("localhost:33060", 0);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }
        

      /*  System.out.println("\n All the countries in the world organised by largest population to smallest.");
        ArrayList<Country> countries = a.getCountryPopLargesttoSmallest();
        a.displaycountry(countries);

        System.out.println("\n All the countries in a continent organised by largest population to smallest.");
        ArrayList<Country> countries1 = a.getCountryPopbyContinent("Asia");
        a.displaycountry(countries1);

        System.out.println("\n All the countries in a region organised by largest population to smallest.");
        ArrayList<Country> countries2 = a.getCountryPopbyRegion("Caribbean");
        a.displaycountry(countries2);

        System.out.println("\n The top N populated countries in the world where N is provided by the user.");
        ArrayList<Country> countries3 = a.gettopCountryPopLargesttoSmallest(3);
        a.displaycountry(countries3);

        System.out.println("\n The top N populated countries in a continent where N is provided by the user.");
        ArrayList<Country> countries4 = a.gettopCountryPopbyContinent("Asia", 2);
        a.displaycountry(countries4);

        System.out.println("\n The top N populated countries in a region where N is provided by the user.");
        ArrayList<Country> countries5 = a.gettopCountryPopbyRegion("Caribbean", 2);
        a.displaycountry(countries5);

     
        System.out.println("\n All the cities in the world organised by largest population to smallest.");
        ArrayList<City> cities= a.getcitiesintheworldLargesttoSmallest();
        a.display(cities);

        System.out.println("\n All the cities in a continent organised by largest population to smallest.");
        ArrayList<City> cities1= a.getcitiesinthecontinentLargesttoSmallest("Europe");
        a.display(cities1);*/

        System.out.println("\n All the cities in a region organised by largest population to smallest..");
        ArrayList<City> cities2= a.getcitiesintheregionLargesttoSmallest("Southeast Asia");
        a.display(cities2);

      /*  System.out.println("\n All the cities in a country organised by largest population to smallest..");
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
        a.display(cities9);*/

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


    //Extract all populated countries on the world
    public ArrayList<Country> getCountryPopLargesttoSmallest() throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country,city where country.capital = city.id order by country.population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Country> countries = new ArrayList<Country>();
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
            countries.add(c);
            }
        return countries;
    }
    //Extract populated countries from a continent
    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country, city where country.capital = city.id AND country.continent=? order by country.population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Country> countries1 = new ArrayList<Country>();
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


            countries1.add(c);
             }
        return countries1;
    }



    //Extract populated countries from a region
    public ArrayList<Country> getCountryPopbyRegion(String contn) throws SQLException {
        String sql = "select country.code,country.name,country.continent,country.region,city.name,country.population from country,city where country.capital = city.id AND country.region=? order by country.population desc";
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


    //Extract top populated countries on the world
    public ArrayList<Country> gettopCountryPopLargesttoSmallest(Integer count) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country,city where country.capital = city.id order by country.population desc LIMIT ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, count);
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

    //Extract top populated countries from a continent
    public ArrayList<Country> gettopCountryPopbyContinent(String contn, Integer continent) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country, city where country.capital = city.id AND country.continent=? order by country.population desc LIMIT ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        pstmt.setInt(2, continent);
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

    //Extract top populated countries from a region
    public ArrayList<Country> gettopCountryPopbyRegion(String region, Integer reg) throws SQLException {
        String sql = "select country.code,country.name,country.continent,country.region,city.name,country.population from country,city where country.capital = city.id AND country.region=? order by country.population desc LIMIT ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, region);
        pstmt.setInt(2, reg);
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

    public ArrayList<City> getcitiesintheworldLargesttoSmallest() throws SQLException {
        String sql =
                "select city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  from city,country where city.countrycode = country.code order by city.Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String countrycode, String district,Float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities.add(ci);
        }
        return cities;
    }

    public ArrayList<City> getcitiesinthecontinentLargesttoSmallest(String countrycontinent) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode = country.code AND country.continent= ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countrycontinent);
        ArrayList<City> cities1 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities1.add(ci);
        }
        return cities1;
    }
    public ArrayList<City> getcitiesintheregionLargesttoSmallest(String countryregion) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode = country.code AND country.region= ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryregion);
        ArrayList<City> cities2 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities2.add(ci);
        }
        return cities2;
    }
    //Extract the output of all the cities in a country organised by largest population to smallest.
    public ArrayList<City> getcitiesinthecountryLargesttoSmallest(String countryname) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE country.code=city.countrycode AND country.name = ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryname);
        ArrayList<City> cities3 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities3.add(ci);
        }
        return cities3;
    }

    //Extract the output of all the cities in a district organised by largest population to smallest.
    public ArrayList<City> getcitiesinthedistrictLargesttoSmallest(String citydistrict) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code AND city.district= ? ORDER BY city.Population DESC";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,citydistrict);
        ArrayList<City> cities4 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities4.add(ci);
        }
        return cities4;
    }
  
    public ArrayList<City> getTOPNumberofPopulatedCitiesinWorld(Integer number) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setInt(1,number);
        ArrayList<City> cities5= new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities5.add(ci);
        }
        return cities5;
    }
    public ArrayList<City> getTOPNumberofpopulatedCitieswithcontinent(String countrycontinent,Integer number) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code AND country.continent = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countrycontinent);
        pstmt.setInt(2,number);
        ArrayList<City> cities6 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities6.add(ci);
        }
        return cities6;
    }
     public ArrayList<City> getTOPNumberofpopulatedCitieswithregion(String countryregion,Integer number) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code AND country.region = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryregion);
        pstmt.setInt(2,number);
        ArrayList<City> cities7 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities7.add(ci);

        }
        return cities7;
    }
    public ArrayList<City> getTOPNumberofpopulatedCitieswithcountry(String countryname,Integer number) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name FROM city,country WHERE city.countrycode=country.code AND country.name = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryname);
        pstmt.setInt(2,number);
        ArrayList<City> cities8 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities8.add(ci);
        }
        return cities8;
    }
     public ArrayList<City> getTOPNumberofpopulatedCitieswithdistrict(String citydistrict,Integer number) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name FROM city,country WHERE city.countrycode=country.code AND city.district = ? ORDER BY city.Population DESC LIMIT ? ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,citydistrict);
        pstmt.setInt(2,number);
        ArrayList<City> cities9 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {
            City ci = new City();
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString("city.countrycode"));
            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("city.population"));
            ci.setContinent(rset.getString("country.continent"));
            ci.setRegion(rset.getString("country.region"));
            ci.setConame(rset.getString("country.name"));
            ci.setId(rset.getInt(1));
            cities9.add(ci);
        }
        return cities9;
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

    public void display(ArrayList<City> report) {
        // Check city value is not null
        if (report == null) {
            System.out.println("No null values in city data");
            return;
        } else if (report.size() == 0)
            System.out.println("There is no country");
        else {
            // Print header
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-5s %-16s %-8s %-16s %-16s %-16s %-16s %-16s", "City ID", "City Name", "Country Code", "District", "Population", "Continent", "Region", "Country Name"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all cities in the list
            for (City ci : report) {
                if (ci == null)
                    continue;
                String city_string =
                        String.format("%-5s %-16s %-8s %-16s %-16s %-16s %-16s %-16s",
                                ci.getId(), ci.getName(), ci.getCountryCode(), ci.getDistrict(), ci.getPopulation(), ci.getContinent(), ci.getRegion(), ci.getConame());
                System.out.printf(city_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
      }
}



