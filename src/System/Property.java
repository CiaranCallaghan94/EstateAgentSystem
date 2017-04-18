package System;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Property
class Property {
    private String 	name;
    private int 	district;
    private int		num_bedrooms;
    private int		price;
    
    private final Lock lock = new ReentrantLock();

    Property(String name, int district, int num_bedrooms, int price) {

        this.name 			= name;
        this.district 		= district;
        this.num_bedrooms 	= num_bedrooms;
        this.price			= price;
    }
    
    public String getName(){
        return name;
    }
    
    public int getDistrict() {
    	return district;
    }

    public int getNumBedrooms() {
        return num_bedrooms;
    }

    public int getPrice() {
    	return price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}