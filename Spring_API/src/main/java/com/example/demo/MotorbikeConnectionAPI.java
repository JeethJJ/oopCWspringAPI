package com.example.demo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotorbikeConnectionAPI {

    Database db=new Database();

    @CrossOrigin(origins = "http://localhost:4200")       //giving the data access to port number 4200
    @RequestMapping(value = "/bike",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)    //request from the gui for data
    @ResponseBody      //response for the request
    public List<Vehicle> returnAll(){
        db.getBike();
        return Database.bikeList;
    }
}
