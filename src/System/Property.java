package System;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Property {
    private String 	name;
    private int 	district;
    private int		num_bedrooms;
    private int		price;
    
    private final Lock lock = new ReentrantLock();

    Property() {

    }

    Property(String name, int district, int num_bedrooms, int price) {

        this.name 			= name;
        this.district 		= district;
        this.num_bedrooms 	= num_bedrooms;
        this.price			= price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getNum_bedrooms() {
        return num_bedrooms;
    }

    public void setNum_bedrooms(int num_bedrooms) {
        this.num_bedrooms = num_bedrooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name;
    }


}