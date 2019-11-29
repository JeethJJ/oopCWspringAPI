package com.example.demo;

import dev.morphia.annotations.Entity;

import java.util.Date;
import java.util.Objects;

@Entity("CBooking")
public class CBooking {
    private String carNum;
    private Date sday;
    private Date eday;


    public CBooking(String plateNum, Date sday, Date eday) {
        this.carNum = plateNum;
        this.sday = sday;
        this.eday = eday;
    }

    public CBooking(){}

    public String getCarNum() {
        return carNum;
    }

    public Date getSday() {
        return sday;
    }

    public Date getEday() {
        return eday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CBooking booking = (CBooking) o;
        return Objects.equals(carNum, booking.carNum) &&
                Objects.equals(sday, booking.sday) &&
                Objects.equals(eday, booking.eday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNum, sday, eday);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "plateNum='" + carNum + '\'' +
                ", sday=" + sday +
                ", eday=" + eday +
                '}';
    }
}
