package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingConnectionAPI {

    Database db=new Database();
    DateFormatter df = new DateFormatter();

    @CrossOrigin(origins = "http://localhost:4200")       //giving the data access to port number 4200
    @RequestMapping(value = "/carBooking",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)    //request from the gui for data
    @ResponseBody      //response for the request
    public List<FormattedBooking> returnAllCarBooking(){
        db.getCarBooking();
        List<FormattedBooking> carBk = new ArrayList<FormattedBooking>();
        for(CBooking cb : Database.bookingsCar){
            carBk.add(new FormattedBooking(cb.getCarNum(),df.dateString(cb.getSday()),df.dateString(cb.getEday())));
        }
        return carBk;
    }

    @CrossOrigin(origins = "http://localhost:4200")       //giving the data access to port number 4200
    @RequestMapping(value = "/bikeBooking",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)    //request from the gui for data
    @ResponseBody      //response for the request
    public List<FormattedBooking> returnAllBikeBooking(){
        db.getBikeBooking();
        List<FormattedBooking> bikeBk = new ArrayList<FormattedBooking>();
        for(BBooking bb : Database.bookingsBike){
            bikeBk.add(new FormattedBooking(bb.getBikeNum(),df.dateString(bb.getSday()),df.dateString(bb.getEday())));
        }
        return bikeBk;
    }
}
