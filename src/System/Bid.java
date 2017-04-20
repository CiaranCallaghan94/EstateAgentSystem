package System;

/**
 *  Bid class is a bid object which is placed into the bid history of each property.
 *  Bid contains the client_id of the client who made the bid and the amount the client bid.
 */
public class Bid {

	private int client_id;
	private double bid_amount;
	
	Bid() {
	}
	
	public Bid(int client_id, double bid_amount) {
		
		this.client_id = client_id;
		this.bid_amount = bid_amount;
	}
	
	public int getClientId() {
		return this.client_id;
	}
	
	public void setClientId(int client_id) {
		this.client_id = client_id;
	}
	
	public double getBidAmount() {
		return this.bid_amount;
	}
	
	public void setBidAmount(double bid_amount) {
		this.bid_amount = bid_amount;
	}
}
