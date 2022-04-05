package com.napier.group5;
//Build country class
public class Country {


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

    public float getPeopleliving() {
        return peopleliving;
    }

    public void setPeopleliving(float peopleliving) {
        this.peopleliving = peopleliving;
    }

    public float getPeoplenotliving() {
        return peoplenotliving;
    }

    public void setPeoplenotliving(float peoplenotliving) {
        this.peoplenotliving = peoplenotliving;
    }

    public float peopleliving;
    public float peoplenotliving;
    public String name;


    public Country() {
        this.code = code;
        this.coname = coname;
        this.continent = continent;
        this.region = region;
        this.capital = capital;
        this.population = population;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }
    public String getConame() {
        return coname;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getContinent() {
        return continent;
    }


    public void setRegion(String region) {
        this.region = region;
    }
    public String getRegion() {
        return region;
    }


    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getCapital() {
        return capital;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setPopulation(float population) {
        this.population = population;
    }
    public float getPopulation() {
        return population;
    }




}
