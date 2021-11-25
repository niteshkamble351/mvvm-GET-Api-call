package com.example.api_call_architechturecomponent.model;

public class HolidayModel {

    private String name;
    private String localName;
    private String date;


    public HolidayModel(String name, String localName, String date) {
        this.name = name;
        this.localName = localName;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
