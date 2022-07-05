package es.license.citapriva.model;

public class CityModel {
    private int id;
    private String name;
    private String file_name;

    public CityModel() {
    }

    public CityModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
