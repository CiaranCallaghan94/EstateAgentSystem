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
    private Double	auction_price;

    private Calendar start_sale_time;
    private Calendar end_sale_time;

    
    private List<Bid> bid_history;
    
    private BookingManager booking_manager;

    private NotificationManager notificationManager;
    private final Lock bidLock = new ReentrantLock();
    private final Lock viewingLock = new ReentrantLock();

    Property() {
    }

    Property(NotificationManager notificationManager,String name, int district, int num_bedrooms, double auction_price, Calendar start_sale_time, Calendar end_sale_time) {

        this.notificationManager = notificationManager;
        this.name           = name;
        this.district 		= district;
        this.num_bedrooms 	= num_bedrooms;
        this.auction_price	= auction_price;
        
        this.start_sale_time = start_sale_time;
        this.end_sale_time 	 = end_sale_time;
        
        bid_history = new LinkedList<>();
        booking_manager = new BookingManager();
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

    public double getAuctionPrice() {
        return auction_price;
    }

    public void setAuctionPrice(double auction_price) {
        this.auction_price = auction_price;
    }
    
    public Bid getLatestBid() {
    	return bid_history.get(bid_history.size()-1);
    }

    public double getHighestBid() {
    	if(bid_history.isEmpty())
    		return this.auction_price;
    	else
    		return getLatestBid().getBidAmount();
    }

    public String setHighestBid(int client_id, double bid_amount) {

        bidLock.lock();
        try {
            if (!isListed())
                return "Bid unsucessful: Property not listed";

            double highest_bid = getHighestBid();
            if (bid_amount > highest_bid) {

                // Notifies the previous bid leader that they have been outbid, prompting them to make a counter offer
                if (bid_history.size() > 0) {
                    notificationManager.addNotification(bid_history.get(bid_history.size() - 1).getClientId(),
                            "You have been outbid on property " + getName() + "(" + getPropertyId() + ") at a price of " + bid_amount);
                }
                Bid new_bid = new Bid(client_id, bid_amount);
                bid_history.add(new_bid);

                // A size of one means that the bid we just added was the first bid
                if (bid_history.size() == 1) {
                    return "Initial bid sucessful";
                } else return "Counter-bid succesful";
            } else return "Bid unsucessful: Bid too low. The highest bid is: " + highest_bid;
        }
        finally {
            bidLock.unlock();
        }
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
    
    public List<Bid> getBids() {
    	return bid_history;
    }
    
    public void setBids(List<Bid> bid_history) {
    	this.bid_history = bid_history;
    }

    public boolean isListed(){

        Calendar cal = Calendar.getInstance();
        if(cal.compareTo(getStartSaleTime()) >= 0 && cal.compareTo(getEndSaleTime()) <= 0){
            return true;
        }
        else return false;
    }
    
    public List<Booking> getViewingTimes() {
    	return booking_manager.getViewings();
    }
    
    public boolean setViewingTime(Calendar date) {
    	
    	// If viewing start date is after sale start date OR viewing end date is after sale end date
    	if(date.compareTo(this.start_sale_time) < 0 || date.compareTo(this.end_sale_time) > 0) {
    		System.out.println("Invalid date");
    		return false;
    	}
    	
    	booking_manager.setViewings(date);
    	return true;
    }
    
    public boolean setBooking(int client_id, int booking_id) {
        viewingLock.lock();
        try {
            return booking_manager.setBooking(client_id, booking_id);
        }
        finally{
            viewingLock.unlock();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}