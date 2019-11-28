package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddCarBooking {
    Database db=new Database();

    @CrossOrigin
    @RequestMapping(value="/addCar", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity setTest(@RequestBody CBooking bk) {
        CBooking booking= new CBooking(bk.getCarNum(),bk.getSday(),bk.getEday());
        db.saveCBooking(booking);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

}
