package com.example.demo;

import java.util.Objects;

//this is a formatted booking class which is created only to return the bookings as json objects to the front end, bcs the date is string
public class FormattedBooking {
    String plateNumber;
    String sDay;
    String eDay;

    public FormattedBooking(String plateNumber, String sDay, String eDay) {
        this.plateNumber = plateNumber;
        this.sDay = sDay;
        this.eDay = eDay;
    }

    public FormattedBooking(){}

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getsDay() {
        return sDay;
    }

    public void setsDay(String sDay) {
        this.sDay = sDay;
    }

    public String geteDay() {
        return eDay;
    }

    public void seteDay(String eDay) {
        this.eDay = eDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormattedBooking that = (FormattedBooking) o;
        return Objects.equals(plateNumber, that.plateNumber) &&
                Objects.equals(sDay, that.sDay) &&
                Objects.equals(eDay, that.eDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, sDay, eDay);
    }

    @Override
    public String toString() {
        return "FormattedBooking{" +
                "plateNumber='" + plateNumber + '\'' +
                ", sDay='" + sDay + '\'' +
                ", eDay='" + eDay + '\'' +
                '}';
    }
}
