package com.example.theshire.data;

public class ApiDataModel {
    private String Title_en;
    private String Title_tc;
    private String Title_sc;
    private String District_en;
    private String District_tc;
    private String District_sc;
    private String Route_en;
    private String Route_tc;
    private String Route_sc;
    private String HowToAccess_en;
    private String HowToAccess_tc;
    private String HowToAccess_sc;
    private String MapURL_en;
    private String MapURL_tc;
    private String MapURL_sc;
    private String Latitude;
    private String Longitude;

    // Getters and setters

    public ApiDataModel(String title_en, String title_tc, String title_sc, String district_en, String district_tc, String district_sc, String route_en, String route_tc, String route_sc, String howToAccess_en, String howToAccess_tc, String howToAccess_sc, String mapURL_en, String mapURL_tc, String mapURL_sc, String latitude, String longitude) {
        Title_en = title_en;
        Title_tc = title_tc;
        Title_sc = title_sc;
        District_en = district_en;
        District_tc = district_tc;
        District_sc = district_sc;
        Route_en = route_en;
        Route_tc = route_tc;
        Route_sc = route_sc;
        HowToAccess_en = howToAccess_en;
        HowToAccess_tc = howToAccess_tc;
        HowToAccess_sc = howToAccess_sc;
        MapURL_en = mapURL_en;
        MapURL_tc = mapURL_tc;
        MapURL_sc = mapURL_sc;
        Latitude = latitude;
        Longitude = longitude;
    }

    public String getTitle_en() {
        return Title_en;
    }

    public String getTitle_tc() {
        return Title_tc;
    }

    public String getTitle_sc() {
        return Title_sc;
    }

    public String getDistrict_en() {
        return District_en;
    }

    public String getDistrict_tc() {
        return District_tc;
    }

    public String getDistrict_sc() {
        return District_sc;
    }

    public String getRoute_en() {
        return Route_en;
    }

    public String getRoute_tc() {
        return Route_tc;
    }

    public String getRoute_sc() {
        return Route_sc;
    }

    public String getHowToAccess_en() {
        return HowToAccess_en;
    }

    public String getHowToAccess_tc() {
        return HowToAccess_tc;
    }

    public String getHowToAccess_sc() {
        return HowToAccess_sc;
    }

    public String getMapURL_en() {
        return MapURL_en;
    }

    public String getMapURL_tc() {
        return MapURL_tc;
    }

    public String getMapURL_sc() {
        return MapURL_sc;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }
}
