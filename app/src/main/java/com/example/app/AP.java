package com.example.app;

public class AP {
    private static String apiEndPoint="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    private static String location="Japan, ";
    private static String startDate=null; //optional (omit for forecast)
    private static String endDate=null; //optional (requires a startDate if present)
    private static String unitGroup="uk"; //us,metric,uk
    private static String apiKey="9AQFCYTJYJ8GQ6YV7Z27BCQHF";

    public AP() {}

    public String getApiEndPoint() {
        return apiEndPoint;
    }

    public void setApiEndPoint(String apiEndPoint) {
        this.apiEndPoint = apiEndPoint;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUnitGroup() {
        return unitGroup;
    }

    public void setUnitGroup(String unitGroup) {
        this.unitGroup = unitGroup;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
