package System;

import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

// Service Endpoint
@WebService
public class EstateAgentImplementation{

	private PropertyManager propertyManager = new PropertyManager();

	
    public List<Property> getProperties() {
		List<Property> allProperties = propertyManager.getProperties();
		return allProperties;
	}

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


    
    
    public boolean listPropertyForSale(
    		@WebParam(name = "name") String name, 				@WebParam(name = "district")int district, 
    		@WebParam(name = "num_bedrooms") int num_bedrooms, 	@WebParam(name = "price") int price,
    		@WebParam(name = "start_year") int start_year, 		@WebParam(name = "start_month") int start_month, 
    		@WebParam(name = "start_date") int start_date, 		@WebParam(name = "end_year") int end_year, 
    		@WebParam(name = "end_month") int end_month, 		@WebParam(name = "end_date") int end_date) {
    	
    	Calendar start = new GregorianCalendar(start_year, start_month, start_date);
    	Calendar end = new GregorianCalendar(end_year, end_month, end_date);
    	
    	System.out.println("Listing property");
    	
    	propertyManager.addProperty(name, district, num_bedrooms, price, start, end);
    	return true;
    }

    
	public String placeBidOnProperty(
			@WebParam(name = "client_id") int client_id, 
			@WebParam(name = "property_id") int property_id, 
			@WebParam(name = "bid_amount") double bid_amount) {

		Property property = propertyManager.getProperty(property_id);
		if(property == null)
			return "Property not found";
		
		return property.setHighestBid(client_id, bid_amount);
	}
}