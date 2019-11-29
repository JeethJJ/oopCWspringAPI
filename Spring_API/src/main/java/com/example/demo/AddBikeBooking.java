package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddBikeBooking {
    Database db=new Database();

    @CrossOrigin
    @RequestMapping(value="/addBike", method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity setTest(@RequestBody BBooking bk) {
        db.getBikeBooking();
        BBooking booking= new BBooking(bk.getBikeNum(),bk.getSday(),bk.getEday());
        for (BBooking b : Database.bookingsBike){
            if(b.getBikeNum().equals(booking.getBikeNum())){
                if(b.getEday().compareTo(booking.getSday()) * booking.getSday().compareTo(b.getSday()) > 0  ||  b.getEday().compareTo(booking.getEday()) * booking.getEday().compareTo(b.getSday()) > 0){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The vehicle is already booked in the date");
                }
            }
        }
        db.saveBBooking(booking);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

}
