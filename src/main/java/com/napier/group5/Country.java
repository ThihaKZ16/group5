package com.napier.group5;
//Build country class
public class Country {


    /*Declaration for the Country  variable*/
    public String code;
    public String coname;
    public String continent;
    public String region;
    public String capital;
    public float population;
    public float peopleliving;
    public float peoplenotliving;
    public String name;


    /*Getter and setter function of Peopleliving*/
    public float getPeopleliving() {
        return peopleliving;
    }
    /*Getter and setter function of Peopleliving*/
    public void setPeopleliving(float peopleliving) {
        this.peopleliving = peopleliving;
    }
    /*Getter and setter function of Peoplenotliving*/
    public float getPeoplenotliving() {
        return peoplenotliving;
    }
    /*Getter and setter function of Peoplenotliving*/
    public void setPeoplenotliving(float peoplenotliving) {
        this.peoplenotliving = peoplenotliving;
    }


    /*Assigning each database variable with java variable function for Country*/
    public Country() {
        this.code = code;
        this.coname = coname;
        this.continent = continent;
        this.region = region;
        this.capital = capital;
        this.population = population;
    }
    /*Getter and setter function of Country Database variable(code)*/
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    /*Getter and setter function of Country Database variable(countryname)*/
    public void setConame(String coname) {
        this.coname = coname;
    }
    public String getConame() {
        return coname;
    }
    /*Getter and setter function of Country Database variable(continent)*/
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getContinent() {
        return continent;
    }

    /*Getter and setter function of Country Database variable(region)*/

    public void setRegion(String region) {
        this.region = region;
    }
    public String getRegion() {
        return region;
    }

    /*Getter and setter function of Country Database variable(Capital)*/
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getCapital() {
        return capital;
    }

    /*Getter and setter function of Country Database variable(city name)*/
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /*Getter and setter function of Country Database variable (population)*/
    public void setPopulation(float population) {
        this.population = population;
    }
    public float getPopulation() {
        return population;
    }

}