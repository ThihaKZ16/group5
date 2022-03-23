package com.napier.group5;

public class City {
    /*Code.
    Name.
    Country.
    District.
    Population.*/
    private String name;
    private String country;
    private String district;
    private float population;

    public City(String name, String country, String district, float population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public void setDistrict(String district) {
        this.district = district;
    }



    public void setPopulation(float population) {
        this.population = population;
    }




    public String getCountry() {
        return country;
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