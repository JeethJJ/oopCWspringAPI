package com.example.demo;
import dev.morphia.annotations.Entity;

import java.util.Date;
import java.util.Objects;

@Entity("BBooking")    //create the collection in db
public class BBooking {
    private String bikeNum;
    private Date sday;
    private Date eday;


    public BBooking(String bikeNum, Date sday, Date eday) {       //to create the booking data
        this.bikeNum = bikeNum;
        this.sday = sday;
        this.eday = eday;
    }

    public BBooking(){}

    public String getBikeNum() {
        return bikeNum;
    }

    public Date getSday() {
        return sday;
    }

    public Date getEday() {
        return eday;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "plateNum='" + bikeNum + '\'' +
                ", sday=" + sday +
                ", eday=" + eday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BBooking bBooking = (BBooking) o;
        return Objects.equals(bikeNum, bBooking.bikeNum) &&
                Objects.equals(sday, bBooking.sday) &&
                Objects.equals(eday, bBooking.eday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeNum, sday, eday);
    }
}

