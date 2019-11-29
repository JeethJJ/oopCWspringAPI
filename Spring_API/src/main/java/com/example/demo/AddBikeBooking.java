package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddBikeBooking {
    Database db=new Database();

    @CrossOrigin       //adding access is given to all sources
    @RequestMapping(value="/addBike", method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity setTest(@RequestBody BBooking bk) {
        db.getBikeBooking();
        BBooking booking= new BBooking(bk.getBikeNum(),bk.getSday(),bk.getEday());
        for (BBooking b : Database.bookingsBike){       //iterate and check if a record is there for the vehicle
            if(b.getBikeNum().equals(booking.getBikeNum())){
                if(b.getEday().compareTo(booking.getSday()) * booking.getSday().compareTo(b.getSday()) > 0  ||  b.getEday().compareTo(booking.getEday()) * booking.getEday().compareTo(b.getSday()) > 0 || b.getEday().equals(booking.getEday()) || b.getEday().equals(booking.getSday()) || b.getSday().equals(booking.getEday()) || b.getSday().equals(booking.getSday())){  //if a record exists check whether that booking is clashing with this
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The vehicle is already booked in the date");   //if clashing, send a error responce
                }
            }
        }
        db.saveBBooking(booking);
        return ResponseEntity.status(HttpStatus.OK).body(booking);      //if no issues, add booking and return the ok status with the new object
    }

}
