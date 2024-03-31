package com.example.healthcare;

public class BookingDetail_Database {

    String fullname;
    String address;
    String contact;
    String fess;

    String date;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFess() {
        return fess;
    }

    public void setFess(String fess) {
        this.fess = fess;
    }

    public BookingDetail_Database(String fullname, String address, String contact, String fess, String date,String time) {
        this.fullname = fullname;
        this.address = address;
        this.contact = contact;
        this.fess = fess;
        this.date=date;
        this.time=time;
    }

    public BookingDetail_Database() {
    }
}
