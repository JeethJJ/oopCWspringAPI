package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddCarBooking {
    Database db=new Database();

    @CrossOrigin  //access to the data is given to all sources
    @RequestMapping(value="/addCar", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity setTest(@RequestBody CBooking bk) {
        db.getCarBooking();
        CBooking booking= new CBooking(bk.getCarNum(),bk.getSday(),bk.getEday());       // creating the object from the data we received.
        for (CBooking c : Database.bookingsCar){   //iterate and check if a record is there for the vehicle
            if(c.getCarNum().equals(booking.getCarNum())){
                if(c.getEday().compareTo(booking.getSday()) * booking.getSday().compareTo(c.getSday()) > 0  || c.getEday().compareTo(booking.getEday()) * booking.getEday().compareTo(c.getSday()) > 0 || c.getEday().equals(booking.getEday()) || c.getEday().equals(booking.getSday()) || c.getSday().equals(booking.getEday()) || c.getSday().equals(booking.getSday())){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The vehicle is already booked in the date");
                }
            }
        }
        db.saveCBooking(booking);           //adding the booking to database
        return ResponseEntity.status(HttpStatus.OK).body(booking);      //if no issues, add booking and return the ok status with the new object
    }

}
