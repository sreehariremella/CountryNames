package com.example.sreehari.countrylistgenerator;

import java.util.ArrayList;

public class Country {
    String CountryName;
    String Capital;
    ArrayList<String> Boundries=new ArrayList<>();
    private Country(){}
    public Country(String countryName,String capital,ArrayList<String> boundries){
        CountryName=countryName;
        Capital=capital;
        boundries=Boundries;
    }
    public String getCountryName() {
        return CountryName;
    }

    public String getCapital() {
        return Capital;
    }

    public ArrayList<String> getBoundries() {
        return Boundries;
    }

}
