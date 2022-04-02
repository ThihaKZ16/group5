package com.napier.group5;

public class City {
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    /*ID
                 Name.
                 CountryCode.
                 District.
                 Population.
                 */
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

    public void setId(int id) {
        this.id = id;
    }

    public City(String name, String countrycode, String district, float population) {
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    public City() {

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
