package com.example.sreehari.countrylistgenerator;

import java.util.Arrays;

public class Country
{
    private String region;

    private String[] currencies;

    private String numericCode;

    private String[] callingCodes;

    private String alpha3Code;

    private String nativeName;

    private String[] topLevelDomain;

    private String alpha2Code;

    private String capital;

    private String[] altSpellings;

    private String[] languages;

    private String subregion;

    private String[] timezones;

    private String area;

    private String name;

    private String[] latlng;

    private String relevance;

    private Translations translations;

    private String demonym;

    private String gini;

    private String[] borders;

    private String population;

    public String getRegion ()
    {
        return region;
    }

    public void setRegion (String region)
    {
        this.region = region;
    }

    public String[] getCurrencies ()
    {
        return currencies;
    }

    public void setCurrencies (String[] currencies)
    {
        this.currencies = currencies;
    }

    public String getNumericCode ()
    {
        return numericCode;
    }

    public void setNumericCode (String numericCode)
    {
        this.numericCode = numericCode;
    }

    public String[] getCallingCodes ()
    {
        return callingCodes;
    }

    public void setCallingCodes (String[] callingCodes)
    {
        this.callingCodes = callingCodes;
    }

    public String getAlpha3Code ()
    {
        return alpha3Code;
    }

    public void setAlpha3Code (String alpha3Code)
    {
        this.alpha3Code = alpha3Code;
    }

    public String getNativeName ()
    {
        return nativeName;
    }

    public void setNativeName (String nativeName)
    {
        this.nativeName = nativeName;
    }

    public String[] getTopLevelDomain ()
    {
        return topLevelDomain;
    }

    public void setTopLevelDomain (String[] topLevelDomain)
    {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code ()
    {
        return alpha2Code;
    }

    public void setAlpha2Code (String alpha2Code)
    {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital ()
    {
        return capital;
    }

    public void setCapital (String capital)
    {
        this.capital = capital;
    }

    public String[] getAltSpellings ()
    {
        return altSpellings;
    }

    public void setAltSpellings (String[] altSpellings)
    {
        this.altSpellings = altSpellings;
    }

    public String[] getLanguages ()
    {
        return languages;
    }

    public void setLanguages (String[] languages)
    {
        this.languages = languages;
    }

    public String getSubregion ()
    {
        return subregion;
    }

    public void setSubregion (String subregion)
    {
        this.subregion = subregion;
    }

    public String[] getTimezones ()
    {
        return timezones;
    }

    public void setTimezones (String[] timezones)
    {
        this.timezones = timezones;
    }

    public String getArea ()
    {
        return area;
    }

    public void setArea (String area)
    {
        this.area = area;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getLatlng ()
    {
        return latlng;
    }

    public void setLatlng (String[] latlng)
    {
        this.latlng = latlng;
    }

    public String getRelevance ()
    {
        return relevance;
    }

    public void setRelevance (String relevance)
    {
        this.relevance = relevance;
    }

    public Translations getTranslations ()
    {
        return translations;
    }

    public void setTranslations (Translations translations)
    {
        this.translations = translations;
    }

    public String getDemonym ()
    {
        return demonym;
    }

    public void setDemonym (String demonym)
    {
        this.demonym = demonym;
    }

    public String getGini ()
    {
        return gini;
    }

    public void setGini (String gini)
    {
        this.gini = gini;
    }

    public String[] getBorders ()
    {
        return borders;
    }

    public void setBorders (String[] borders)
    {
        this.borders = borders;
    }

    public String getPopulation ()
    {
        return population;
    }

    public void setPopulation (String population)
    {
        this.population = population;
    }

    @Override
    public String toString()
    {
        return "Region = "+region+", \ncurrencies = "+Arrays.toString(currencies)+", \nnumericCode = "+numericCode+", \ncallingCodes = "+Arrays.toString(callingCodes)+", \nalpha3Code = "+alpha3Code+", \nnativeName = "+nativeName+", \ntopLevelDomain = "+Arrays.toString(topLevelDomain)+", \nalpha2Code = "+alpha2Code+", \ncapital = "+capital+", \naltSpellings = "+Arrays.toString(altSpellings)+", \nlanguages = "+Arrays.toString(languages)+", \nsubregion = "+subregion+", \ntimezones = "+Arrays.toString(timezones)+", \narea = "+area+", \nname = "+name+", \nlatlng = "+Arrays.toString(latlng)+", \nrelevance = "+relevance+", \ntranslations = "+translations.toString()+", \ndemonym = "+demonym+", \ngini = "+gini+", \nborders = "+Arrays.toString(borders).toString()+", \npopulation = "+population;
    }
    public String toStringCustomized(){
        return "Name = "+name+",\nCapital = "+capital+",\nBorders = "+ Arrays.toString(borders)+", \nTopLevelDomain = "+Arrays.toString(topLevelDomain)+", \nCallingCodes = "+Arrays.toString(callingCodes)+" \nTimezones = "+Arrays.toString(timezones)+"\nArea = "+area+",\nLatLong = "+Arrays.toString(latlng)+"\nPopulation = "+population+"\nTranslations = "+translations.toString();
    }
    public class Translations
    {
        private String de;

        private String it;

        private String fr;

        private String es;

        private String ja;

        public String getDe ()
        {
            return de;
        }

        public void setDe (String de)
        {
            this.de = de;
        }

        public String getIt ()
        {
            return it;
        }

        public void setIt (String it)
        {
            this.it = it;
        }

        public String getFr ()
        {
            return fr;
        }

        public void setFr (String fr)
        {
            this.fr = fr;
        }

        public String getEs ()
        {
            return es;
        }

        public void setEs (String es)
        {
            this.es = es;
        }

        public String getJa ()
        {
            return ja;
        }

        public void setJa (String ja)
        {
            this.ja = ja;
        }

        @Override
        public String toString()
        {
            return "\nde = "+de+", \nit = "+it+", \nfr = "+fr+", \nes = "+es+", \nja = "+ja+"]";
        }
    }
}