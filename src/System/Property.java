package System;

import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Property {
    private String 	name;
    private int 	district;
    private int		num_bedrooms;
    private int		price;
    
    private Calendar start_sale_time;
    private Calendar end_sale_time;
    
    private final Lock lock = new ReentrantLock();

    Property() {

    }

    Property(String name, int district, int num_bedrooms, int price, Calendar start_sale_time, Calendar end_sale_time) {

        this.name 			= name;
        this.district 		= district;
        this.num_bedrooms 	= num_bedrooms;
        this.price			= price;
        
        this.start_sale_time = start_sale_time;
        this.end_sale_time 	 = end_sale_time;
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