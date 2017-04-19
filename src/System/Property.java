package System;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Property {

	private int		property_id;
    private String 	name;
    private int 	district;
    private int		num_bedrooms;
    private int		auction_price;

    private List<Bid> bid_history;

    private Calendar start_sale_time;
    private Calendar end_sale_time;
    
    private final Lock lock = new ReentrantLock();

    Property() {
    }

    Property(String name, int district, int num_bedrooms, int price, Calendar start_sale_time, Calendar end_sale_time) {

        this.name 			= name;
        this.district 		= district;
        this.num_bedrooms 	= num_bedrooms;
        this.auction_price	= price;
        
        this.start_sale_time = start_sale_time;
        this.end_sale_time 	 = end_sale_time;
        
        bid_history = new LinkedList<>();
        bid_history.add(new Bid(-1, price));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getPropertyId() {
    	return this.property_id;
    }
    
    public void setPropertyId(int id) {
    	this.property_id = id;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getNumBedrooms() {
        return num_bedrooms;
    }

    public void setNumBedrooms(int num_bedrooms) {
        this.num_bedrooms = num_bedrooms;
    }

    public int getAuctionPrice() {
        return auction_price;
    }

    public void setAuctionPrice(int price) {
        this.auction_price = price;
    }
    
    public Bid getLatestBid() {
    	return bid_history.get(bid_history.size()-1);
    }

    public double getHighestBid() {
        return getLatestBid().getBidAmount();
    }

    public String setHighestBid(int client_id, double bid_amount) {
        
        if(!isListed())
        	return "Bid unsucessful: Property not listed";
        
        if(bid_amount > getHighestBid()) {
        	
        	Bid new_bid = new Bid(client_id, bid_amount);
        	bid_history.add(new_bid);
        	
        	// A size of two means that the bid we just added was the first bid
        	// as we also add one on construction to represent the bid_minimum
        	if(bid_history.size() == 2) {
    			return "Initial bid sucessful";
    		}
        	else return "Counter-bid succesful";
        }
        else return "Bid unsucessful: Bid too low. The highest bid is: " + getHighestBid();
    }

    public Calendar getStartSaleTime() {
        return start_sale_time;
    }

    public void setStartSaleTime(Calendar start_sale_time) {
        this.start_sale_time = start_sale_time;
    }

    public Calendar getEndSaleTime() {
        return end_sale_time;
    }

    public void setEndSaleTime(Calendar end_sale_time) {
        this.end_sale_time = end_sale_time;
    }

    public boolean isListed(){

        Calendar cal = Calendar.getInstance();
        if(cal.compareTo(getStartSaleTime()) >= 0 && cal.compareTo(getEndSaleTime()) <= 0){
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}