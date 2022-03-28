package com.napier.group5;

public class City {
    /*ID
             Name.
             CountryCode.
             District.
             Population.
             */
    private String name;
    private String countrycode;
    private String district;
    private float population;

    public City(String name, String countrycode, String district, float population) {
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    public void setCountryCode(String countrycode) {
        this.countrycode = countrycode;
    }



    public void setDistrict(String district) {
        this.district = district;
    }



    public void setPopulation(float population) {
        this.population = population;
    }




    public String getCountryCode() {
        return countrycode;
    }

    public String getDistrict() {
        return district;
    }



    public float getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}