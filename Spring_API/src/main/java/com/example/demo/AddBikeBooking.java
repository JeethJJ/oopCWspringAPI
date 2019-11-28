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
        BBooking booking= new BBooking(bk.getBikeNum(),bk.getSday(),bk.getEday());
        db.saveBBooking(booking);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

}
