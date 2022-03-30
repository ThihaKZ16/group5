package com.napier.group5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class cities
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displayTestNull()
    {
        app.display(null);
    }

    @Test
    void displayTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.display(cities);
    }

    @Test
    void displayTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.display(cities);
    }

    @Test
    void display()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City ci = new City();
        ci.name= "Seoul";
        ci.countrycode= "KOR" ;
        ci.district = "Seoul";
        ci.population= 9981619;
        ci.continent ="Asia";
        ci.region = "Eastern Asia";
        ci.coname= "South Korea";

        cities.add(ci);
        app.display(cities);
    }

}

class cities1
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displayTestNull()
    {
        app.display(null);
    }

    @Test
    void displayTestEmpty()
    {
        ArrayList<City> cities1 = new ArrayList<City>();
        app.display(cities1);
    }

    @Test
    void displayTestContainsNull()
    {
        ArrayList<City> cities1 = new ArrayList<City>();
        cities1.add(null);
        app.display(cities1);
    }

    @Test
    void display()
    {
        ArrayList<City> cities1 = new ArrayList<City>();
        City ci = new City();
        ci.name= "Fengcheng";
        ci.countrycode= "CHN" ;
        ci.district = "Jiangxi";
        ci.population= 193784;
        ci.continent ="Asia";
        ci.region = "Eastern Asia";
        ci.coname= "China";

        cities1.add(ci);
        app.display(cities1);
    }

}


