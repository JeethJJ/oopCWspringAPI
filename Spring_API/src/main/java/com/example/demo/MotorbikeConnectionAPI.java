package com.example.demo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
        import java.util.List;

@RestController
public class MotorbikeConnectionAPI {
    public static List<Vehicle> bikeList = new ArrayList<>();        // list of all items
    Database db=new Database();

    public MotorbikeConnectionAPI(){
        bikeList.addAll(db.getBike());       //adding all items from database to the list
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/bike",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    @ResponseBody
    public List<Vehicle> returnAll(){
        return bikeList;
    }
}
