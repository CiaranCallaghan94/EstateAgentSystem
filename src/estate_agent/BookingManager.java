package estate_agent;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *  This object is responsible for holding a list of Bookings
 */

public class BookingManager {

	private List<Booking> bookings;
	
	public BookingManager() {
		bookings = new LinkedList<>();
	}
	
	public List<Booking> getViewings() {
		return bookings;
	}
	
	// Set ID of booking to its index within the list
	public void setViewings(Calendar date) {
		
		Booking booking = new Booking(date);
		bookings.add(booking);
		booking.setBookingId(bookings.indexOf(booking));
	}
	
	public boolean setBooking(int client_id, int booking_id) {
		
		return bookings.get(booking_id).setBooking(client_id);
	}
}