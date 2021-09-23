package com.hp.major.FindUrWay;

/**
 * Created by HP on 14-04-2018.
 */




class PlaceNotes {
    private String placeName;
    private String address;
    private String notes;
    private String date;
    private double latitude;
    private double longitude;
    private String email;

      public PlaceNotes(){
          //this constructor is required
      }



    public PlaceNotes(String placeName, String address, String notes, String date, double latitude, double longitude, String email) {
        this.placeName = placeName;
        this.address = address;
        this.notes = notes;
        this.date = date;
        this.latitude = latitude;
        this.longitude=longitude;
        this.email=email;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
