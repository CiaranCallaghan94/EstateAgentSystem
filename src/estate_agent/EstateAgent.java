package estate_agent;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 *  This object exposes the methods available for the client to call.
 */
// Service Endpoint
@WebService
public class EstateAgent{

	private NotificationManager notificationManager = new NotificationManager();
	private PropertyManager propertyManager = new PropertyManager(notificationManager);

	// Return all the properties and their details, including their bid history
	@WebMethod
    public List<Property> getProperties() {
		List<Property> allProperties = propertyManager.getProperties();
		return allProperties;
	}

    // Return all the properties and their details within a price range
    @WebMethod
	public List<Property> getPropertiesInPriceRange(@WebParam(name = "minPrice")int min, @WebParam(name = "maxPrice")int max) {
		List<Property> allProperties = propertyManager.getProperties();
		List<Property> propertiesInRange = new LinkedList<>();

		for(Property p : allProperties){

			if(p.getAuctionPrice() >= min && p.getAuctionPrice() <= max){
				propertiesInRange.add(p);
			}
		}
		return propertiesInRange;
	}
    
	// Add a property listing
	@WebMethod
    public boolean listPropertyForSale(
    		@WebParam(name = "name") String name, 				@WebParam(name = "district")int district, 
    		@WebParam(name = "num_bedrooms") int num_bedrooms, 	@WebParam(name = "price") int price,
    		@WebParam(name = "start_year") int start_year, 		@WebParam(name = "start_month") int start_month, 
    		@WebParam(name = "start_date") int start_date, 		@WebParam(name = "end_year") int end_year, 
    		@WebParam(name = "end_month") int end_month, 		@WebParam(name = "end_date") int end_date) {
    	
    	Calendar start = new GregorianCalendar(start_year, start_month-1, start_date);
    	Calendar end = new GregorianCalendar(end_year, end_month-1, end_date);
    	
    	System.out.println("Listing property");
    	
    	return propertyManager.addProperty(name, district, num_bedrooms, price, start, end);
    }

    // Place a bid on a property
    @WebMethod
	public String placeBidOnProperty(
			@WebParam(name = "client_id") int client_id, 
			@WebParam(name = "property_id") int property_id, 
			@WebParam(name = "bid_amount") double bid_amount) {

		Property property = propertyManager.getProperty(property_id);
		if(property == null)
			return "Bid unsucessful: Property not found";
		
		return property.setHighestBid(client_id, bid_amount);
	}
	
	// Get all viewing times and details for a particular property
	@WebMethod
	public List<Booking> getBookingSlots(@WebParam(name = "property_id") int property_id) {
		
		Property property = propertyManager.getProperty(property_id);
		if(property == null)
			return null;
		else
			return property.getViewingTimes();
	}
	
	// Add viewing times
	@WebMethod
	public boolean addBookingSlot(
			@WebParam(name = "property_id") int property_id,
			@WebParam(name = "year") int year, @WebParam(name = "month") int month, 
    		@WebParam(name = "date") int day,  @WebParam(name = "time") int time) {
		
		Calendar date = new GregorianCalendar(year, month, day, time, 0);
		Property property = propertyManager.getProperty(property_id);
		if(property == null)
			return false;
		
		property.setViewingTime(date);
		return true;
	}
	
	@WebMethod
	public boolean placeBooking(
			@WebParam(name = "client_id") int client_id,
			@WebParam(name = "property_id") int property_id,
			@WebParam(name = "booking_id") int booking_id) {
		
		Property property = propertyManager.getProperty(property_id);
		if(property == null)
			return false;
		
		return property.setBooking(client_id, booking_id);
	}

	@WebMethod
	public List<Notification> getNotifications(){

		return notificationManager.getNotifications();
	}

	@WebMethod
	public List<Notification> getNotificationsForClient(@WebParam(name = "client_id")int client_id){

		return notificationManager.getNotificationsForClient(client_id);
	}
}