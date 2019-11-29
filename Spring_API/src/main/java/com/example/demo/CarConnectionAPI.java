package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CarConnectionAPI {

    Database db=new Database();

    @CrossOrigin(origins = "http://localhost:4200")     //giving the data access to port number 4200
    @RequestMapping(value = "/car",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)   //request for data
    @ResponseBody              // data responce
    public List<Vehicle> returnAll(){
        db.getCar();
        return Database.carList;
    }

}
