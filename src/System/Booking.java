package System;

import java.util.Calendar;

public class Booking {
	
	Calendar view_time;
	int client_id = - 1;
	int booking_id;
	boolean booked;
	
	public Booking(Calendar view_time) {
		this.view_time = view_time;
		booked = false;
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
	
	public boolean getBooked() {
		return booked;
	}
	
	public void setBooked(boolean book) {
		this.booked = book;
	}
	
	public boolean setBooking(int client_id) {
		
		if(booked)
			return false;
		
		this.client_id = client_id;
		booked = true;
		return true;
	}
	
	public void makeBooking(int client_id) {
		this.client_id = client_id;
	}
	
	public boolean isBooked() {
		return client_id != -1;
	}
}
