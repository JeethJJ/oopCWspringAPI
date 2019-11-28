package com.example.demo;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;

import java.util.List;


public class Database {

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

    public List<Car> getCar() {                     //get all car objects
        Query<Car> query = this.rentalStore.createQuery(Car.class);
        return query.find().toList();
    }

    public List<Motorbike> getBike() {                           //get all bike objects
        Query<Motorbike> query = this.rentalStore.createQuery(Motorbike.class);
        return query.find().toList();
    }
}
