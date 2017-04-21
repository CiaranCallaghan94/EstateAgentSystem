package System;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * BookingManager contains all the bookings for a specific property.
 */

public class BookingManager {

	private List<Booking> bookings;
	
	public BookingManager() {
		bookings = new LinkedList<>();
	}
	
	public List<Booking> getViewings() {
		return bookings;
	}
	
	public void setViewings(Calendar date) {
		
		Booking booking = new Booking(date);
		bookings.add(booking);
		booking.setBookingId(bookings.indexOf(booking));
	}
	
	public boolean setBooking(int client_id, int booking_id) {
		
		return bookings.get(booking_id).setBooking(client_id);
	}
}