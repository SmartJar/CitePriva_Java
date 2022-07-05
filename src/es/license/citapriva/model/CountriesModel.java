package es.license.citapriva.model;

import java.util.List;

public class CountriesModel {
    private String name;
    private List<CityModel> cityModels;

    public CountriesModel() {}

    public String getName() {
        return name;
    }

    public List<CityModel> getCityModels() {
        return cityModels;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityModels(List<CityModel> cityModels) {
        this.cityModels = cityModels;
    }
}
