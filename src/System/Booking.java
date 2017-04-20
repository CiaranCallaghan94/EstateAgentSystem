package System;

import java.util.Calendar;

/**
 *  Booking
 */
public class Booking {
	
	Calendar view_time;
	int client_id = - 1;
	int booking_id;
	
	public Booking(Calendar view_time) {
		this.view_time = view_time;
	}
	
	public int getBookingId() {
		return booking_id;
	}
	
	public void setBookingId(int booking_id) {
		this.booking_id = booking_id;
	}
	
	public Calendar getViewTime() {
		return view_time;
	}
	
	public void setViewTime(Calendar view_time) {
		this.view_time = view_time;
	}
	
	public int getClientId() {
		return client_id;
	}
	
	public void setClientId(int client_id) {
		this.client_id = client_id;
	}

	public boolean setBooking(int client_id) {
		
		if(client_id != -1)
			return false;
		
		this.client_id = client_id;
		return true;
	}
	
	public void makeBooking(int client_id) {
		this.client_id = client_id;
	}
	
	public boolean isBooked() {
		return client_id != -1;
	}
}
