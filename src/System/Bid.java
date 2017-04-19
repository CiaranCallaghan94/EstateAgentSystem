package System;

public class Bid {

	private int client_id;
	private double bid_amount;
	
	public Bid(int client_id, double bid_amount) {
		
		this.client_id = client_id;
		this.bid_amount = bid_amount;
	}
	
	double getBidAmount() {
		return bid_amount;
	}
}
