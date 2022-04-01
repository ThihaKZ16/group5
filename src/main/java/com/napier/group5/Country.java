package com.napier.group5;
//Build country class
public class Country {
    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    /*Code.
        Name.
        Continent.
        Region.
        Population.
        Capital. */
    public String code;
    public String coname;
    public String continent;
    public String region;
    public String capital;
    public float population;
    public String name;

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Country() {
        this.code = code;
        this.coname = coname;
        this.continent = continent;
        this.region = region;
        this.capital = capital;
        this.population = population;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(float population) {
        this.population = population;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public String getCapital() {
        return capital;
    }

    public float getPopulation() {
        return population;
    }

    public void setName(String coname) {
        this.coname = coname;
    }

    public String getName() {
        return coname;
    }
}

