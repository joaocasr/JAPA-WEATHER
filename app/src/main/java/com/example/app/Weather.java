package com.example.app;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Weather {
    private SimpleDoubleProperty tempmin;
    private SimpleDoubleProperty tempmax;
    private SimpleStringProperty datetime;
    private SimpleStringProperty description;

    public Weather(Double tempmin,Double tempmax, String datetime) {
        this.tempmin = new SimpleDoubleProperty(tempmin);
        this.tempmax = new SimpleDoubleProperty(tempmax);
        this.datetime = new SimpleStringProperty(datetime);
    }
    public Weather(Double tempmin, Double tempmax, String datetime, String description) {
        this.tempmin = new SimpleDoubleProperty(tempmin);
        this.tempmax = new SimpleDoubleProperty(tempmax);
        this.datetime = new SimpleStringProperty(datetime);
        this.description = new SimpleStringProperty(description);
    }

    public double getTempmin() {
        return tempmin.get();
    }

    public SimpleDoubleProperty tempminProperty() {
        return tempmin;
    }

    public void setTempmin(double tempmin) {
        this.tempmin.set(tempmin);
    }

    public double getTempmax() {
        return tempmax.get();
    }

    public SimpleDoubleProperty tempmaxProperty() {
        return tempmax;
    }

    public void setTempmax(double tempmax) {
        this.tempmax.set(tempmax);
    }

    public String getDatetime() {
        return datetime.get();
    }

    public SimpleStringProperty datetimeProperty() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime.set(datetime);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
