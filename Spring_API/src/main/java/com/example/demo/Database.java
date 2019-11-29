package com.example.demo;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;


public class Database {
    public static List<CBooking> bookingsCar = new ArrayList<CBooking>();
    public static List<BBooking> bookingsBike = new ArrayList<BBooking>();
    public static List<Vehicle> carList = new ArrayList<>();        // list of all items
    public static List<Vehicle> bikeList = new ArrayList<>();        // list of all items
    private Morphia morphia = new Morphia();          //creating connection
    private Datastore rentalStore = morphia.createDatastore(new MongoClient(), "RentalStore");

    //Declare database
    public Database() {
        morphia.mapPackage("com.github.jeethjj.oopcw");
        rentalStore.ensureIndexes();
    }

    public void saveCBooking(CBooking bk) {
        rentalStore.save(bk);
    }

    public void saveBBooking(BBooking bk) {
        rentalStore.save(bk);
    }

    public void getCar() {                     //get all car objects
        carList.clear();            //refreshes the list every time the data is required
        Query<Car> query = this.rentalStore.createQuery(Car.class);
        carList.addAll(query.find().toList());
    }

    public void getBike() {                           //get all bike objects
        bikeList.clear();
        Query<Motorbike> query = this.rentalStore.createQuery(Motorbike.class);
        bikeList.addAll(query.find().toList());
    }

    public void getCarBooking(){
        bookingsCar.clear();
        Query<CBooking> query = this.rentalStore.createQuery(CBooking.class);    //query to get all car booking
        bookingsCar.addAll( query.find().toList());
    }

    public void getBikeBooking(){
        bookingsBike.clear();
        Query<BBooking> query2 = this.rentalStore.createQuery(BBooking.class);   //query to get all bikes booking
        bookingsBike.addAll( query2.find().toList());
    }
}
