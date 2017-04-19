package System;

import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Property {

    private String 	name;
    private int 	district;
    private int		num_bedrooms;
    private int		price;

    private double  highest_bid = 0;

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

    public double getHighest_bid() {
        return highest_bid;
    }

    public void setHighest_bid(double highest_bid) {
        this.highest_bid = highest_bid;
    }

    public Calendar getStart_sale_time() {
        return start_sale_time;
    }

    public void setStart_sale_time(Calendar start_sale_time) {
        this.start_sale_time = start_sale_time;
    }

    public Calendar getEnd_sale_time() {
        return end_sale_time;
    }

    public void setEnd_sale_time(Calendar end_sale_time) {
        this.end_sale_time = end_sale_time;
    }

    public boolean isListed(){

        Calendar cal = Calendar.getInstance();
        if(cal.compareTo(getStart_sale_time()) >= 0 && cal.compareTo(getEnd_sale_time()) <= 0){
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return this.name;
    }



}