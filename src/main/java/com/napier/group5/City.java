package com.napier.group5;
//Build city class
public class City {


    /*Declaration for the City  variables*/
    private int id;
    public int getId() {
        return id;
    }
    public String name;
    public String countrycode;
    public String district;
    public float population;
    public String continent;
    public String region;
    public String coname;


    /*Assigning each database variable with java variable function for Country*/
    public City(String name, String countrycode, String district, float population) {
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    public City() {

    }
    /*Getter and setter function of CityDatabase variable(Cityid)*/
    public void setId(int id) {

        this.id = id;
    }
    /*Getter and setter function of CityDatabase variable(Continent)*/
   public void setContinent(String continent) {

       this.continent = continent;
    }
    /*Getter and setter function of CityDatabase variable(region)*/
    public void setRegion(String region) {

        this.region = region;
    }
    /*Getter and setter function of CityDatabase variable(Country Name)*/
    public void setConame(String coname) {
        this.coname = coname;
    }
    /*Getter and setter function of CityDatabase variable(Countrycode)*/
    public void setCountryCode(String countrycode) {
        this.countrycode = countrycode;
    }
    /*Getter and setter function of CityDatabase variable(Continent)*/
    public String getContinent() {

        return continent;
    }
    /*Getter and setter function of CityDatabase variable(region)*/
    public String getRegion() {
        return region;
    }
    /*Getter and setter function of CityDatabase variable(Country Name)*/
    public String getConame() {

        return coname;
    }
    /*Getter and setter function of CityDatabase variable(District)*/
    public void setDistrict(String district) {

        this.district = district;
    }
    /*Getter and setter function of CityDatabase variable (population)*/
    public void setPopulation(float population) {

        this.population = population;
    }
    /*Getter and setter function of CityDatabase variable(Countrycode)*/
    public String getCountryCode() {
        return countrycode;
    }
    /*Getter and setter function of CityDatabase variable (District)**/
    public String getDistrict() {
        return district;
    }
    /*Getter and setter function of CityDatabase variable(population)*/
    public float getPopulation() {

        return population;
    }

    /*Getter and setter function of CityDatabase variable(Cityname)*/
    public void setName(String name) {
        this.name = name;
    }
    /*Getter and setter function of CityDatabase variable(Cityname)*/
    public String getName() {
        return name;
    }
}