package com.napier.group5;

import java.sql.*;
import java.util.ArrayList;

public class App {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;


    public static void main(String[] args) throws SQLException {
        /** Create new Application**/
        App a = new App();
        /** Connect to database **/

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }


        /** ************************Start of country reports*********************/

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
        ArrayList<Country> countries3 = a.gettopCountryPopLargesttoSmallest(3);
        a.displaycountry(countries3);

        System.out.println("\n The top N populated countries in a continent where N is provided by the user.");
        ArrayList<Country> countries4 = a.gettopCountryPopbyContinent("Asia", 2);
        a.displaycountry(countries4);

        System.out.println("\n The top N populated countries in a region where N is provided by the user.");
        ArrayList<Country> countries5 = a.gettopCountryPopbyRegion("Caribbean", 2);
        a.displaycountry(countries5);

        /** ************************End of country reports*********************/


        /** ************************Start of city reports*********************/

        System.out.println("\n All the cities in the world organised by largest population to smallest.");
        ArrayList<City> cities= a.getcitiesintheworldLargesttoSmallest();
        a.display(cities);

        System.out.println("\n All the cities in a continent organised by largest population to smallest.");
        ArrayList<City> cities1= a.getcitiesinthecontinentLargesttoSmallest("Europe");
        a.display(cities1);

        System.out.println("\n All the cities in a region organised by largest population to smallest..");
        ArrayList<City> cities2= a.getcitiesintheregionLargesttoSmallest("Southeast Asia");
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

        /** ************************End of city reports*********************/


        /** ************************Start of capital city reports*********************/

        System.out.println("\n All the capital cities in the world organised by largest population to smallest.");
        ArrayList<Country> capital = a.getCapitalPopLargesttoSmallestintheworld();
        a.displaycapital(capital);

        System.out.println("\n All the capital cities in a continent organised by largest population to smallest.");
        ArrayList<Country> capital1 = a.getCapitalPopLargesttoSmallestinacontinent("Asia");
        a.displaycapital(capital1);

        System.out.println("\n The top N populated capital cities in a continent where N is provided by the user.");
        ArrayList<Country> capital2 = a.gettopNpopulatedcapitalcity("Asia", 5);
        a.displaycapital(capital2);

        System.out.println("\n All the capital cities in a region organised by largest to smallest.");
        ArrayList<Country> capital3 = a.getCapitalPopLargesttoSmallestinaRegion("Caribbean");
        a.displaycapital(capital3);

        System.out.println("\n The top N populated capital cities in the world where N is provided by the user.");
        ArrayList<Country> capital4 = a.gettopNpopulatedcapitalcityintheworld(16);
        a.displaycapital(capital4);

        System.out.println("\n The top N populated capital cities in a region where N is provided by the user.");
        ArrayList<Country> capital5 = a.gettopNpopulatedcapitalcityinaRegion("Caribbean", 10);
        a.displaycapital(capital5);

        /** ************************End of capital city reports*********************/

        /** Generate total population in the world, a continent, a region, a country, a district, a city*/

        System.out.println("\n Total population in the world");
        ArrayList<Country> population1 = a.gettotalpopulationintheworld();
        a.displaypopulation1(population1);

        System.out.println("\n Total population in a continent");
        ArrayList<Country> population2 = a.gettotalpopulationinthecontinent("Asia");
        a.displaypopulation2(population2);

        System.out.println("\n Total population in a region");
        ArrayList<Country> population3 = a.gettotalpopulationintheregion("Micronesia");
        a.displaypopulation3(population3);

        System.out.println("\n Total population in a country");
        ArrayList<Country> population4 = a.gettotalpopulationinthecountry("Japan");
        a.displaypopulation4(population4);

        System.out.println("\n Total population in a district");
        ArrayList<City> population5 = a.gettotalpopulationinthedistrict("Zuid-Holland");
        a.displaypopulation5(population5);

        System.out.println("\n Total population in a city");
        ArrayList<City> population6 = a.gettotalpopulationinthecity("Rangoon (Yangon)");
        a.displaypopulation6(population6);

        /**Generate population report by people living in cities and people not living in cities*/

        System.out.println("The population of people, people living in cities, and people not living in cities in each continent.");
        a.getpeoplelivingornotlivinginthecitiesineachcontinent("Asia");

        System.out.println("The population of people, people living in cities, and people not living in cities in each region.");
        a.getpeoplelivingornotlivinginthecitiesineachregion("Micronesia");

        System.out.println("The population of people, people living in cities, and people not living in cities in each country.");
        a.getpeoplelivingornotlivinginthecitiesineachcountry("Singapore");

        /**Generate population report by spoken language*/

        System.out.println("Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:\n" +
                "Chinese,English,Hindi,Spanish,Arabic");
        a.getthelangaugeofworldpopulation();

        /** Disconnect from database*/
        a.disconnect();

    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String conString, int delay) {
        try {
            /** Load Database driver*/
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                /** Wait a bit for db to start*/
                Thread.sleep(delay);
                /** Connect to database*/

                /**Added allowPublicKeyRetrieval=true to get Integration Tests to work. Possibly due to accessing from another class?*/

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
                /** Close connection*/
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }


    /**Extract all populated countries on the world*/
    public ArrayList<Country> getCountryPopLargesttoSmallest() throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country,city where country.capital = city.id order by country.population desc";
        /**prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery(sql);
        /**String code, String name, String continent, String region, String capital-name, float population*/

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
    /**Extract populated countries from a continent*/
    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country, city where country.capital = city.id AND country.continent=? order by country.population desc";
        /*prepare statement*/
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



    /**Extract populated countries from a region*/
    public ArrayList<Country> getCountryPopbyRegion(String contn) throws SQLException {
        String sql = "select country.code,country.name,country.continent,country.region,city.name,country.population from country,city where country.capital = city.id AND country.region=? order by country.population desc";
        /*prepare statement*/
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


    /**Extract top populated countries on the world*/
    public ArrayList<Country> gettopCountryPopLargesttoSmallest(Integer count) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country,city where country.capital = city.id order by country.population desc LIMIT ?";
        /*prepare statement*/
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

    /**Extract top populated countries from a continent*/
    public ArrayList<Country> gettopCountryPopbyContinent(String contn, Integer continent) throws SQLException {
        String sql = "select country.code, country.name, country.continent, country.region, city.name, country.population from country, city where country.capital = city.id AND country.continent=? order by country.population desc LIMIT ?";
        /*prepare statement*/
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

    /**Extract top populated countries from a region*/
    public ArrayList<Country> gettopCountryPopbyRegion(String region, Integer reg) throws SQLException {
        String sql = "select country.code,country.name,country.continent,country.region,city.name,country.population from country,city where country.capital = city.id AND country.region=? order by country.population desc LIMIT ?";
        /**prepare statement*/
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
    /************************ End of country report features**************************/

    public ArrayList<City> getcitiesintheworldLargesttoSmallest() throws SQLException {
        String sql =
                "select city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  from city,country where city.countrycode = country.code order by city.Population desc";
        /**prepare statement*/
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
        /**prepare statement*/
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
        /**prepare statement*/
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
    /**Extract the output of all the cities in a country organised by largest population to smallest.*/
    public ArrayList<City> getcitiesinthecountryLargesttoSmallest(String countryname) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE country.code=city.countrycode AND country.name = ? ORDER BY city.Population DESC";
        /**prepare statement*/
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,countryname);
        ArrayList<City> cities3 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        /**String name, String continent, String region, String capital, float population*/
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

    /**Extract the output of all the cities in a district organised by largest population to smallest.*/
    public ArrayList<City> getcitiesinthedistrictLargesttoSmallest(String citydistrict) throws SQLException {
        String sql ="SELECT city.id, city.name,city.countrycode,city.district,city.population,country.continent,country.region,country.name  FROM city,country WHERE city.countrycode=country.code AND city.district= ? ORDER BY city.Population DESC";
        /**prepare statement*/
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,citydistrict);
        ArrayList<City> cities4 = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        /**String name, String continent, String region, String capital, float population*/
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
        /**prepare statement*/
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setInt(1,number);
        ArrayList<City> cities5= new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        /**String name, String continent, String region, String capital, float population*/
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
        /*prepare statement*/
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
        /*prepare statement*/
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
        /*prepare statement*/
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
        /*prepare statement*/
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

    //Extract all populated capital cities on the world
    public ArrayList<Country> getCapitalPopLargesttoSmallestintheworld() throws SQLException {
        String sql = "select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id order by city.population desc";
        /*prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Country> capital = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country cap = new Country();
            cap.setCode(rset.getString("country.capital"));
            cap.setConame( rset.getString("country.name"));
            cap.setContinent( rset.getString("country.continent"));
            cap.setRegion(rset.getString("country.region"));
            cap.setName(rset.getString("city.name"));
            cap.setPopulation( rset.getFloat("city.population"));

            capital.add(cap);
        }
        return capital;
    }

    public ArrayList<Country> getCapitalPopLargesttoSmallestinacontinent(String capitalcontinent) throws SQLException {
        String sql = "select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.continent = ? order by city.population desc";
        /*prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, capitalcontinent);
        ArrayList<Country> capital1 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country cap = new Country();
            cap.setCode( rset.getString("country.capital"));
            cap.setConame(rset.getString("country.name"));
            cap.setContinent(rset.getString("country.continent"));
            cap.setRegion(rset.getString("country.region"));
            cap.setName(rset.getString("city.name"));
            cap.setPopulation(rset.getFloat("city.population"));

            capital1.add(cap);
        }
        return capital1;
    }

    public ArrayList<Country> gettopNpopulatedcapitalcity(String capitalcontinent, Integer number) throws SQLException {
        String sql = "select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.continent = ? order by city.population desc LIMIT ?";
        /*prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, capitalcontinent);
        pstmt.setInt(2, number);
        ArrayList<Country> capital2 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country cap = new Country();
            cap.setCode( rset.getString("country.capital"));
            cap.setConame(rset.getString("country.name"));
            cap.setContinent(rset.getString("country.continent"));
            cap.setRegion(rset.getString("country.region"));
            cap.setName(rset.getString("city.name"));
            cap.setPopulation(rset.getFloat("city.population"));

            capital2.add(cap);
        }
        return capital2;
    }

    public ArrayList<Country> getCapitalPopLargesttoSmallestinaRegion(String region) throws SQLException {
        String sql = "select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.region = ? order by city.population desc";
        /*prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, region);
        ArrayList<Country> capital3 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country cap = new Country();
            cap.setCode( rset.getString("country.capital"));
            cap.setConame(rset.getString("country.name"));
            cap.setContinent(rset.getString("country.continent"));
            cap.setRegion(rset.getString("country.region"));
            cap.setName(rset.getString("city.name"));
            cap.setPopulation(rset.getFloat("city.population"));

            capital3.add(cap);
        }
        return capital3;
    }

    public ArrayList<Country> gettopNpopulatedcapitalcityintheworld(Integer worldtopnumber) throws SQLException {
        String sql = "select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id order by city.population desc LIMIT ?";
        /*prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, worldtopnumber);
        ArrayList<Country> capital4 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country cap = new Country();
            cap.setCode( rset.getString("country.capital"));
            cap.setConame(rset.getString("country.name"));
            cap.setContinent(rset.getString("country.continent"));
            cap.setRegion(rset.getString("country.region"));
            cap.setName(rset.getString("city.name"));
            cap.setPopulation(rset.getFloat("city.population"));

            capital4.add(cap);
        }
        return capital4;
    }

    public ArrayList<Country> gettopNpopulatedcapitalcityinaRegion(String region, Integer regiontopnumber) throws SQLException {
        String sql = "select country.capital, country.name, country.continent, country.region, city.name, city.population from country,city where country.capital = city.id and country.region = ? order by city.population desc LIMIT ?";
        /*prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, region);
        pstmt.setInt(2, regiontopnumber);
        ArrayList<Country> capital5 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String code, String name, String continent, String region, String capital-name, float population
        while (rset.next()) {
            Country cap = new Country();
            cap.setCode( rset.getString("country.capital"));
            cap.setConame(rset.getString("country.name"));
            cap.setContinent(rset.getString("country.continent"));
            cap.setRegion(rset.getString("country.region"));
            cap.setName(rset.getString("city.name"));
            cap.setPopulation(rset.getFloat("city.population"));

            capital5.add(cap);
        }
        return capital5;
    }

    /**Extract total population of the world*/
    public ArrayList<Country> gettotalpopulationintheworld() throws SQLException {
        /**sql statement to Extract total population of the world*/
        String sql = "select SUM(country.population) AS worldtotal from country";
        /**prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Country> population1 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        /**String code, float population*/
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));

            c.setPopulation(rset.getFloat("worldtotal"));
            population1.add(c);
        }
        return population1;
    }
    /**Extract total population of the continent*/
    public ArrayList<Country> gettotalpopulationinthecontinent(String contn) throws SQLException {
        /**sql statement to Extract total population of the continent**/
        String sql = "select continent, SUM(country.population) AS totalcontinent from country where country.continent=?";
        /**Prepared Statement**/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Country> population2 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        /**String code, String name, String Continent, Float Population*/
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));

            c.setContinent(rset.getString("country.continent"));

            c.setPopulation(rset.getFloat("totalcontinent"));


            population2.add(c);
        }
        return population2;
    }
    /** Extract total population of the region**/
    public ArrayList<Country> gettotalpopulationintheregion(String contn) throws SQLException {
        /**sql statement to Extract total population of the region**/
        String sql = "select region, SUM(country.population) AS totalregion from country where country.region=?";
        /**prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Country> population3 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        /**String code,  String region, Float population*/
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));

            c.setRegion(rset.getString("country.region"));

            c.setPopulation(rset.getFloat("totalregion"));


            population3.add(c);
        }
        return population3;
    }
    /** Extract total population of the country**/
    public ArrayList<Country> gettotalpopulationinthecountry(String contn) throws SQLException {
        /**sql statement to Extract total population of the country**/
        String sql = "select name, population from country where country.name=?";
        /**prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Country> population4 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        /**String code, String name, Float population*/
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));

            c.setConame(rset.getString("country.name"));

            c.setPopulation(rset.getFloat("country.population"));


            population4.add(c);
        }
        return population4;
    }
    /**Extract total population of the district**/
    public ArrayList<City> gettotalpopulationinthedistrict(String contn) throws SQLException {
        /**sql statement to Extract total population of the district**/
        String sql = "select district, SUM(city.population) AS totaldistrict from city where city.district=? GROUP BY city.countrycode";
        /**prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<City> population5 = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        /** String District, float population,String countrycode*/
        while (rset.next()) {
            City ci = new City();


            ci.setDistrict(rset.getString("city.district"));
            ci.setPopulation(rset.getFloat("totaldistrict"));

            ci.setCountryCode(rset.getString(1));

            population5.add(ci);
        }
        return population5;
    }
    /** Extract total population of the city**/
    public ArrayList<City> gettotalpopulationinthecity(String contn) throws SQLException {
        /**sql statement to Extract total population of the city**/
        String sql = "select city.countrycode, city.name,sum(city.population) as citynametotal from city where city.name = ? GROUP BY city.countrycode";
        /**Prepared statement**/
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<City> population6 = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        /**String Countrycode, String name, float population*/
        while (rset.next()) {
            City ci = new City();


            ci.setPopulation(rset.getFloat("citynametotal"));
            ci.setName(rset.getString("city.name"));
            ci.setCountryCode(rset.getString(1));

            population6.add(ci);
        }
        return population6;
    }
    /** Extract peoplelivingornotliving population of the continent**/
    public void getpeoplelivingornotlivinginthecitiesineachcontinent(String continent) throws SQLException {
        /** Sql statments to extract peoplelivingornotliving population of the continent**/
        String sql1 = "select" +
                "(((select SUM(country.population)) -" +
                "(select SUM(city.population)))/(select SUM(country.population)) * 100) as peoplenotliving from country,city where country.code = city.countrycode AND country.continent=?";
        String sql2 = "select((select SUM(city.population))/(select SUM(country.population)) * 100) as peopleliving from country,city where country.code = city.countrycode AND country.continent=?";
        String sql3 = "select country.continent from country where country.continent=?";

        /**Prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql1);
        PreparedStatement pstmt1 = con.prepareStatement(sql2);
        PreparedStatement pstmt2 = con.prepareStatement(sql3);


        pstmt.setString(1, continent);
        ArrayList<Country> population7 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();


        /**String code, Float peoplenotliving*/
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setPeoplenotliving(rset.getFloat("peoplenotliving"));

            population7.add(c);



        }
        /**Extract peoplelivingornotliving population of the continent**/
        ArrayList<Country> population8 = new ArrayList<Country>();
        pstmt1.setString(1,continent);
        ResultSet rset1 = pstmt1.executeQuery();
        /**String code, Float peopleliving*/
        while (rset1.next()) {
            Country co = new Country();
            co.setCode(rset1.getString(1));
            co.setPeopleliving(rset1.getFloat("peopleliving"));



            population8.add(co);

        }
        /**Extract peoplelivingornotliving population of the continent**/
        ArrayList<Country> population10 = new ArrayList<Country>();
        pstmt2.setString(1,continent);
        ResultSet rset2 = pstmt2.executeQuery();
        /**String code, String continent*/
        while (rset2.next()) {
            Country co = new Country();
            co.setCode(rset2.getString(1));

            co.setContinent(rset2.getString("country.continent"));


            population10.add(co);

        }
        for(int i=0; i<population7.size();i++)
        {
            System.out.println("People Not Living in cities"+" "+population7.get(i).getPeoplenotliving()+"%");
            for(int j=0; j<population8.size();j++)
            {
                System.out.println("People Living in cities"+" "+population8.get(j).getPeopleliving()+"%"+"\n"+"Continent"+" "+population10.get(j).getContinent());

            }
        }



    }
    /** Extract peoplelivingornotliving population of the region**/
    public void getpeoplelivingornotlivinginthecitiesineachregion(String region) throws SQLException {
        /** Sql statments to extract peoplelivingornotliving population of the region**/
        String sql1 = "select" +
                "(((select SUM(country.population)) -" +
                "(select SUM(city.population)))/(select SUM(country.population)) * 100) as peoplenotliving from country,city where country.code = city.countrycode AND country.region=?";
        String sql2 = "select((select SUM(city.population))/(select SUM(country.population)) * 100) as peopleliving from country,city where country.code = city.countrycode AND country.region=?";
        String sql3 = "select country.region from country where country.region=?";

        /**Prepare statement*/
        PreparedStatement pstmt = con.prepareStatement(sql1);
        PreparedStatement pstmt1 = con.prepareStatement(sql2);
        PreparedStatement pstmt2 = con.prepareStatement(sql3);


        pstmt.setString(1, region);
        ArrayList<Country> population7 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();


        /**String code,  float peoplenotliving*/
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setPeoplenotliving(rset.getFloat("peoplenotliving"));

            population7.add(c);



        }
        /** Extract peoplelivingornotliving population of the region**/
        ArrayList<Country> population8 = new ArrayList<Country>();
        pstmt1.setString(1,region);
        ResultSet rset1 = pstmt1.executeQuery();
        while (rset1.next()) {
            Country co = new Country();
            co.setCode(rset1.getString(1));
            co.setPeopleliving(rset1.getFloat("peopleliving"));



            population8.add(co);

        }
        /** Extract peoplelivingornotliving population of the region**/
        ArrayList<Country> population10 = new ArrayList<Country>();
        pstmt2.setString(1,region);
        ResultSet rset2 = pstmt2.executeQuery();
        while (rset2.next()) {
            Country co = new Country();
            co.setCode(rset2.getString(1));

            co.setRegion(rset2.getString("country.region"));


            population10.add(co);

        }
        for(int i=0; i<population7.size();i++)
        {
            System.out.println("People Not Living in cities"+" "+population7.get(i).getPeoplenotliving()+"%");
            for(int j=0; j<population8.size();j++)
            {
                System.out.println("People Living in cities"+" "+population8.get(j).getPeopleliving()+"%"+"\n"+"Region"+" "+population10.get(j).getRegion());
            }
        }



    }
    /** extract peoplelivingornotliving population of the country**/

    public void getpeoplelivingornotlivinginthecitiesineachcountry(String country) throws SQLException {
        /** sql statements to extract peoplelivingornotliving population of the country**/
        String sql1 = "select" +
                "(((select SUM(country.population)) -" +
                "(select SUM(city.population)))/(select SUM(country.population)) * 100) as peoplenotliving from country,city where country.code = city.countrycode AND country.name=?";
        String sql2 = "select((select SUM(city.population))/(select SUM(country.population)) * 100) as peopleliving from country,city where country.code = city.countrycode AND country.name=?";
        String sql3 = "select country.name from country where country.name=?";

        /**prepared statement*/
        PreparedStatement pstmt = con.prepareStatement(sql1);
        PreparedStatement pstmt1 = con.prepareStatement(sql2);
        PreparedStatement pstmt2 = con.prepareStatement(sql3);


        pstmt.setString(1, country);
        ArrayList<Country> population7 = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();


        /**String code,  float peoplenotliving*/
        while (rset.next()) {
            Country c = new Country();
            c.setCode(rset.getString(1));
            c.setPeoplenotliving(rset.getFloat("peoplenotliving"));

            population7.add(c);



        }
        /** Extract peoplelivingornotliving population of the country**/
        ArrayList<Country> population8 = new ArrayList<Country>();
        pstmt1.setString(1,country);
        ResultSet rset1 = pstmt1.executeQuery();
        while (rset1.next()) {
            Country co = new Country();
            co.setCode(rset1.getString(1));
            co.setPeopleliving(rset1.getFloat("peopleliving"));



            population8.add(co);

        }
        /** extract peoplelivingornotliving population of the country**/
        ArrayList<Country> population10 = new ArrayList<Country>();
        pstmt2.setString(1,country);
        ResultSet rset2 = pstmt2.executeQuery();
        while (rset2.next()) {
            Country co = new Country();
            co.setCode(rset2.getString(1));

            co.setConame(rset2.getString("country.name"));


            population10.add(co);

        }
        for(int i=0; i<population7.size();i++)
        {
            System.out.println("People Not Living in cities"+" "+population7.get(i).getPeoplenotliving()+"%");
            for(int j=0; j<population8.size();j++)
            {
                System.out.println("People Living in cities"+" "+population8.get(j).getPeopleliving()+"%"+"\n"+"Country"+" "+population10.get(j).getConame());
            }
        }



    }


    /** Extract total population of the world with population percentage of English,Chinese,Arabic,Hindi and Spanish **/
    public void getthelangaugeofworldpopulation() throws SQLException {
        /** Sql statements to Extract total population of the world with population percentage of English,Chinese,Arabic,Hindi and Spanish **/

        /** Sql statements to Extract total population of the world with population percentage of English **/
        String sqleng1 = "select country.name,countrylanguage.language,countrylanguage.percentage from countrylanguage,country where country.code = countrylanguage.countrycode AND countrylanguage.language = 'English'";
        String sqleng2 = "select (((select country.population)*(select countrylanguage.percentage))/100) as Englishlanguagepopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='English'";
        String sqleng3 = "select (((select (select SUM((select (country.population)) * (select countrylanguage.percentage))/100) as Englishlanguagepopulation) *100)/ (select SUM(country.population) from country)) as worldenglishtotalpopulation  from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='English'";
        String sqleng4 = "select (SUM((select (country.population)) * (select countrylanguage.percentage))/100) as Englishpopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='English'";

        /** Sql statements to Extract total population of the world with population percentage of Chinese **/
        String sqlchn1 = "select country.name,countrylanguage.language,countrylanguage.percentage from countrylanguage,country where country.code = countrylanguage.countrycode AND countrylanguage.language = 'Chinese'";
        String sqlchn2 = "select (((select country.population)*(select countrylanguage.percentage))/100) as Chinalanguagepopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Chinese'";
        String sqlchn3 = "select (((select (select SUM((select (country.population)) * (select countrylanguage.percentage))/100) as Chinalanguagepopulation) *100)/ (select SUM(country.population) from country)) as worldChinatotalpopulation  from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Chinese'";
        String sqlchn4 = "select SUM((select (country.population)) * (select countrylanguage.percentage)) as Chinapopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Chinese'";

        /** Sql statements to Extract total population of the world with population percentage of Hindi **/
        String sqlhindi1 = "select country.name,countrylanguage.language,countrylanguage.percentage from countrylanguage,country where country.code = countrylanguage.countrycode AND countrylanguage.language = 'Hindi'";
        String sqlhindi2 = "select (((select country.population)*(select countrylanguage.percentage))/100) as Hindilanguagepopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Hindi'";
        String sqlhindi3 = "select (((select (select SUM((select (country.population)) * (select countrylanguage.percentage))/100) as Hindilanguagepopulation) *100)/ (select SUM(country.population) from country)) as worldHinditotalpopulation  from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Hindi'";
        String sqlhindi4 = "select SUM((select (country.population)) * (select countrylanguage.percentage)) as Hindipopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Hindi'";

        /** Sql statements to Extract total population of the world with population percentage of Spanish **/
        String sqlSpanish1 = "select country.name,countrylanguage.language,countrylanguage.percentage from countrylanguage,country where country.code = countrylanguage.countrycode AND countrylanguage.language = 'Spanish'";
        String sqlSpanish2 = "select (((select country.population)*(select countrylanguage.percentage))/100) as Spanishlanguagepopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Spanish'";
        String sqlSpanish3= "select (((select (select SUM((select (country.population)) * (select countrylanguage.percentage))/100) as Spanishlanguagepopulation) *100)/ (select SUM(country.population) from country)) as worldSpanishtotalpopulation  from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Spanish'";
        String sqlSpanish4= "select SUM((select (country.population)) * (select countrylanguage.percentage)) as Spanishpopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Spanish'";

        /** Sql statements to Extract total population of the world with population percentage of Arabic **/
        String sqlArabic1 = "select country.name,countrylanguage.language,countrylanguage.percentage from countrylanguage,country where country.code = countrylanguage.countrycode AND countrylanguage.language = 'Arabic'";
        String sqlArabic2 = "select (((select country.population)*(select countrylanguage.percentage))/100) as Arabiclanguagepopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Arabic'";
        String sqlArabic3= "select (((select (select SUM((select (country.population)) * (select countrylanguage.percentage))/100) as Arabiclanguagepopulation) *100)/ (select SUM(country.population) from country)) as worldArabictotalpopulation  from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Arabic'";
        String sqlArabic4 = "select SUM((select (country.population)) * (select countrylanguage.percentage)) as Arabicpopulation from country,countrylanguage where country.code = countrylanguage.countrycode AND countrylanguage.language='Arabic'";

        /** PreparedStatements statements to Extract total population of the world with population percentage of English **/
        PreparedStatement pstmt = con.prepareStatement(sqleng1);
        PreparedStatement pstmt1 = con.prepareStatement(sqleng2);
        PreparedStatement pstmt2 = con.prepareStatement(sqleng3);
        PreparedStatement pstmt3 = con.prepareStatement(sqleng4);

        /** PreparedStatements statements to Extract total population of the world with population percentage of Chinese **/
        PreparedStatement pstmt4 = con.prepareStatement(sqlchn1);
        PreparedStatement pstmt5 = con.prepareStatement(sqlchn2);
        PreparedStatement pstmt6 = con.prepareStatement(sqlchn3);
        PreparedStatement pstmt7 = con.prepareStatement(sqlchn4);


        /** PreparedStatements statements to Extract total population of the world with population percentage of Arabic **/
        PreparedStatement pstmt8 = con.prepareStatement(sqlArabic1);
        PreparedStatement pstmt9 = con.prepareStatement(sqlArabic2);
        PreparedStatement pstmt10 = con.prepareStatement(sqlArabic3);
        PreparedStatement pstmt11 = con.prepareStatement(sqlArabic4);

        /** PreparedStatements statements to Extract total population of the world with population percentage of Spanish **/
        PreparedStatement pstmt12 = con.prepareStatement(sqlSpanish1);
        PreparedStatement pstmt13 = con.prepareStatement(sqlSpanish2);
        PreparedStatement pstmt14 = con.prepareStatement(sqlSpanish3);
        PreparedStatement pstmt15 = con.prepareStatement(sqlSpanish4);

        /** PreparedStatements statements to Extract total population of the world with population percentage of Hindi **/
        PreparedStatement pstmt16 = con.prepareStatement(sqlhindi1);
        PreparedStatement pstmt17 = con.prepareStatement(sqlhindi2);
        PreparedStatement pstmt18 = con.prepareStatement(sqlhindi3);
        PreparedStatement pstmt19 = con.prepareStatement(sqlhindi4);

        /**English Language Code*/
        ArrayList<CountryLanguage> population21 = new ArrayList<CountryLanguage>();
        ResultSet rset = pstmt.executeQuery();


        /**String code, String countryname, String language,  Float percentage*/
        while (rset.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset.getString(1));
            cl.setConame(rset.getString("country.name"));
            cl.setLanguage(rset.getString("countrylanguage.language"));
            cl.setPercentage(rset.getFloat("countrylanguage.percentage"));

            population21.add(cl);
        }
        /**Extract the english language population percentage**/
        ArrayList<CountryLanguage> population22 = new ArrayList<CountryLanguage>();

        ResultSet rset1 = pstmt1.executeQuery();
        while (rset1.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset1.getString(1));
            cl.setPopulation(rset1.getFloat("Englishlanguagepopulation"));

            population22.add(cl);

        }

        /**Extract the english language population percentage**/
        ArrayList<CountryLanguage> population23 = new ArrayList<CountryLanguage>();

        ResultSet rset2 = pstmt2.executeQuery();
        while (rset2.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset2.getString(1));
            cl.setTotalpopulation(rset2.getFloat("worldenglishtotalpopulation"));


            population23.add(cl);

        }
        /**Extract the english language population percentage**/
        ArrayList<CountryLanguage> population24 = new ArrayList<CountryLanguage>();

        ResultSet rset3 = pstmt3.executeQuery();
        while (rset3.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset3.getString(1));
            cl.setNoperengtotalpopulation(rset3.getFloat("Englishpopulation"));


            population24.add(cl);

        }
        /**China Language Code*/
        /**Extract the Chinese language population percentage**/
        ArrayList<CountryLanguage> population31 = new ArrayList<CountryLanguage>();
        ResultSet rset4 = pstmt4.executeQuery();


        /**String code, String countryname, String language,  Float percentage*/
        while (rset4.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset4.getString(1));
            cl.setConame(rset4.getString("country.name"));
            cl.setLanguage(rset4.getString("countrylanguage.language"));
            cl.setPercentage(rset4.getFloat("countrylanguage.percentage"));

            population31.add(cl);
        }
        /**Extract the Chinese language population percentage**/
        ArrayList<CountryLanguage> population32 = new ArrayList<CountryLanguage>();

        ResultSet rset5 = pstmt5.executeQuery();
        while (rset5.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset5.getString(1));
            cl.setPopulation(rset5.getFloat("Chinalanguagepopulation"));

            population32.add(cl);

        }
        /**Extract the Chinese language population percentage**/
        ArrayList<CountryLanguage> population33 = new ArrayList<CountryLanguage>();

        ResultSet rset6 = pstmt6.executeQuery();
        while (rset6.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset6.getString(1));
            cl.setChinesetotalpopulation(rset6.getFloat("worldchinatotalpopulation"));


            population33.add(cl);

        }
        /**Extract the Chinese language population percentage**/
        ArrayList<CountryLanguage> population34 = new ArrayList<CountryLanguage>();

        ResultSet rset7 = pstmt7.executeQuery();
        while (rset7.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset7.getString(1));
            cl.setNoperchinatotalpopulation(rset7.getFloat("Chinapopulation"));


            population34.add(cl);

        }
        /**Arabic Language Code*/
        /**Extract the Arabic language population percentage**/
        ArrayList<CountryLanguage> population41 = new ArrayList<CountryLanguage>();
        ResultSet rset8 = pstmt8.executeQuery();


        /**String code, String countryname, String language,  Float percentage*/
        while (rset8.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset8.getString(1));
            cl.setConame(rset8.getString("country.name"));
            cl.setLanguage(rset8.getString("countrylanguage.language"));
            cl.setPercentage(rset8.getFloat("countrylanguage.percentage"));

            population41.add(cl);
        }
        /**Extract the Arabic language population percentage**/
        ArrayList<CountryLanguage> population42 = new ArrayList<CountryLanguage>();

        ResultSet rset9 = pstmt9.executeQuery();
        while (rset1.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset9.getString(1));
            cl.setArapopulation(rset9.getFloat("Arabiclanguagepopulation"));

            population42.add(cl);

        }
        /**Extract the Arabic language population percentage**/
        ArrayList<CountryLanguage> population43 = new ArrayList<CountryLanguage>();

        ResultSet rset10 = pstmt10.executeQuery();
        while (rset10.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset10.getString(1));
            cl.setArabictotalpopulation(rset10.getFloat("worldArabictotalpopulation"));


            population43.add(cl);

        }
        /**Extract the Arabic language population percentage**/
        ArrayList<CountryLanguage> population44 = new ArrayList<CountryLanguage>();

        ResultSet rset11 = pstmt11.executeQuery();
        while (rset11.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset11.getString(1));
            cl.setNoperarabictotalpopulation(rset11.getFloat("Arabicpopulation"));


            population44.add(cl);

        }
        /**Spanish Language Code*/
        ArrayList<CountryLanguage> population51 = new ArrayList<CountryLanguage>();
        ResultSet rset12 = pstmt12.executeQuery();

        /**Extract the Spanish language population percentage**/

        /**String code, String countryname, String language,  Float percentage*/
        while (rset12.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset12.getString(1));
            cl.setConame(rset12.getString("country.name"));
            cl.setLanguage(rset12.getString("countrylanguage.language"));
            cl.setPercentage(rset12.getFloat("countrylanguage.percentage"));

            population51.add(cl);
        }
        /**Extract the Spanish language population percentage**/
        ArrayList<CountryLanguage> population52 = new ArrayList<CountryLanguage>();

        ResultSet rset13 = pstmt13.executeQuery();
        while (rset13.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset13.getString(1));
            cl.setSpanpopulation(rset13.getFloat("Spanishlanguagepopulation"));

            population52.add(cl);

        }
        /**Extract the Spanish language population percentage**/
        ArrayList<CountryLanguage> population53 = new ArrayList<CountryLanguage>();

        ResultSet rset14 = pstmt14.executeQuery();
        while (rset14.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset14.getString(1));
            cl.setSpanishtotalpopulation(rset14.getFloat("worldSpanishtotalpopulation"));


            population53.add(cl);

        }
        /**Extract the Spanish language population percentage**/
        ArrayList<CountryLanguage> population54 = new ArrayList<CountryLanguage>();

        ResultSet rset15 = pstmt15.executeQuery();
        while (rset15.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset15.getString(1));
            cl.setNoperspanishtotalpopulation(rset15.getFloat("Spanishpopulation"));


            population54.add(cl);

        }
        /**Hindi Language Code*/
        ArrayList<CountryLanguage> population61 = new ArrayList<CountryLanguage>();
        ResultSet rset16 = pstmt16.executeQuery();

        /**Extract the Hindi language population percentage**/

        /**String code, String countryname, String language,  Float percentage*/
        while (rset16.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset16.getString(1));
            cl.setConame(rset16.getString("country.name"));
            cl.setLanguage(rset16.getString("countrylanguage.language"));
            cl.setPercentage(rset16.getFloat("countrylanguage.percentage"));

            population61.add(cl);
        }
        /**Extract the Hindi language population percentage**/
        ArrayList<CountryLanguage> population62 = new ArrayList<CountryLanguage>();

        ResultSet rset17 = pstmt17.executeQuery();
        while (rset17.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset17.getString(1));
            cl.setHinpopulation(rset17.getFloat("Hindilanguagepopulation"));

            population62.add(cl);

        }
        /**Extract the Hindi language population percentage**/
        ArrayList<CountryLanguage> population63 = new ArrayList<CountryLanguage>();

        ResultSet rset18 = pstmt18.executeQuery();
        while (rset18.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset18.getString(1));
            cl.setHinditotalpopulation(rset18.getFloat("worldHinditotalpopulation"));


            population63.add(cl);

        }
        /**Extract the Hindi language population percentage**/
        ArrayList<CountryLanguage> population64 = new ArrayList<CountryLanguage>();

        ResultSet rset19 = pstmt19.executeQuery();
        while (rset19.next()) {
            CountryLanguage cl = new CountryLanguage();
            cl.setCode(rset19.getString(1));
            cl.setNoperhinditotalpopulation(rset19.getFloat("Hindipopulation"));


            population64.add(cl);

        }


        /**Display method of the English,Chinese,Hindi,Spanish and Arabic language population percentage world based population**/
        for (int j = 0; j < population33.size(); j++) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println("Language"+" "+"Total-Population-Percentage"+" "+ "Total-Population" );
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println("Chinese" + "      " + population33.get(j).getChinesetotalpopulation() +"%"+"          "+population34.get(j).getNoperchinatotalpopulation());
            for (int k = 0; k < population63.size(); k++) {
                System.out.println("Hindi" + "      " + population63.get(k).getHinditotalpopulation() +"%"+"          "+population64.get(k).getNoperhinditotalpopulation());

                for (int l = 0; l < population53.size(); l++) {
                    System.out.println("Spanish" + "      " + population53.get(l).getSpanishtotalpopulation() +"%"+"          "+population54.get(l).getNoperspanishtotalpopulation());
                    for (int m = 0; m < population23.size(); m++) {
                        System.out.println("English" + "      " + population23.get(m).getTotalpopulation() +"%"+"          "+population24.get(m).getNoperengtotalpopulation());
                        for (int n = 0; n < population43.size(); n++) {
                            System.out.println("Arabic" + "      " + population43.get(n).getArabictotalpopulation() +"%"+"          "+population44.get(n).getNoperarabictotalpopulation());


                        }

                    }

                }

            }
        }





    }

    /**display function for country branch*/
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
    public void displaycapital(ArrayList<Country> capitalreport) {
        if (capitalreport == null) {
            System.out.println("No null values in capital city data");
            return;
        } else if (capitalreport.size() == 0)
            System.out.println("There is no capitalcity");
        else {
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-16s %-25s %-20s %-20s %-20s %-16s", "Capital Code", "Country Name", "Continent", "Region", "Capital City", "Population"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all capitalcities in the list
            for (Country cap : capitalreport) {
                if (cap == null)
                    continue;
                String capital_string =
                        String.format("%-16s %-25s %-20s %-20s %-20s %-16s",
                                cap.getCode(), cap.getConame(), cap.getContinent(), cap.getRegion(), cap.getName(), cap.getPopulation());
                System.out.printf(capital_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public void display(ArrayList<City> report) {
        /** Check city value is not null*/
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
    public void displaypopulation1(ArrayList<Country> populationreport) {
        if (populationreport == null) {
            System.out.println("No null values in Population data");
            return;
        } else if (populationreport.size() == 0)
            System.out.println("There is no total population in the world");
        else {

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-16s", "Total Population"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all cities in the list
            for (Country c : populationreport) {
                if (c == null)
                    continue;
                String population_string =
                        String.format("%-16s",
                                c.getPopulation());
                System.out.printf(population_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    public void displaypopulation2(ArrayList<Country> populationcontinent) {
        if (populationcontinent == null) {
            System.out.println("No null values in Population data");
            return;
        } else if (populationcontinent.size() == 0)
            System.out.println("There is no total population in the continent");
        else {

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-16s %-16s", "Total Population ","Continent"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all cities in the list
            for (Country c : populationcontinent) {
                if (c == null)
                    continue;
                String population_string =
                        String.format("%-16s %-16s",
                                c.getPopulation(),c.getContinent());
                System.out.printf(population_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    public void displaypopulation3(ArrayList<Country> populationregion) {
        if (populationregion == null) {
            System.out.println("No null values in Population data");
            return;
        } else if (populationregion.size() == 0)
            System.out.println("There is no total population in the Region");
        else {

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-16s %-16s", "Total Population ","Region"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all cities in the list
            for (Country c : populationregion) {
                if (c == null)
                    continue;
                String population_string =
                        String.format("%-16s %-16s",
                                c.getPopulation(),c.getRegion());
                System.out.printf(population_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    public void displaypopulation4(ArrayList<Country> populationcountry) {
        if (populationcountry == null) {
            System.out.println("No null values in Population data");
            return;
        } else if (populationcountry.size() == 0)
            System.out.println("There is no total population in the Country");
        else {

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-16s %-16s", "Total Population ","Country"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all cities in the list
            for (Country c : populationcountry) {
                if (c == null)
                    continue;
                String population_string =
                        String.format("%-16s %-16s",
                                c.getPopulation(),c.getConame());
                System.out.printf(population_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    public void displaypopulation5(ArrayList<City> populationdistrict) {
        if (populationdistrict == null) {
            System.out.println("No null values in Population data");
            return;
        } else if (populationdistrict.size() == 0)
            System.out.println("There is no total population in the district");
        else {

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-16s %-19s", "Total Population ", "District"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all cities in the list
            for (City ci : populationdistrict) {
                if (ci == null)
                    continue;
                String population_string =
                        String.format("%-16s %-19s",
                                ci.getPopulation(),ci.getDistrict());
                System.out.printf(population_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    public void displaypopulation6(ArrayList<City> populationcity) {
        if (populationcity == null) {
            System.out.println("No null values in Population data");
            return;
        } else if (populationcity.size() == 0)
            System.out.println("There is no total population in the city");
        else {

            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf(String.format("%-16s %-18s %-19s", "Total Population ", "City", "Countrycode"));
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
            // Loop over all cities in the list
            for (City ci : populationcity) {
                if (ci == null)
                    continue;
                String population_string =
                        String.format("%-16s %-18s %-19s ",
                                ci.getPopulation(),ci.getName(),ci.getCountryCode());
                System.out.printf(population_string);
                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
            }
        }
    }

//    public void displaypopulation7(ArrayList<Country> peoplelivingincontinent) {
//        if (peoplelivingincontinent == null) {
//            System.out.println("No null values in Population data");
//            return;
//        } else if (peoplelivingincontinent.size() == 0)
//            System.out.println("There is no total population in the Region");
//        else {
//
//            System.out.println("-------------------------------------------------------------------------------------------------------------------");
//            System.out.printf(String.format("%-16s %-16s %-16s", "People Living In Cities ","Continent", "People Not Living In Cities "));
//            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
//            // Loop over all cities in the list
//            for (Country c : peoplelivingincontinent) {
//                if (c == null)
//                    continue;
//                String population_string =
//                        String.format("%-16s %-16s %-16s",
//                                c.getPeopleliving(),c.getContinent(),c.getPeoplenotliving());
//                System.out.printf(population_string);
//                System.out.println("\n----------------------------------------------------------------------------------------------------------------");
//            }
//        }
//    }



}



