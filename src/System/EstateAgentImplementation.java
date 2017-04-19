package System;

import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

// Service Endpoint
@WebService
public class EstateAgentImplementation{

	private PropertyManager propertyManager = new PropertyManager();

    public List<Property> getProperties() {
        List<Property> allProperties = propertyManager.getProperties();
        return allProperties;
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

	public boolean placeBidOnProperty(@WebParam(name = "name") String name, @WebParam(name = "bidAmount")double bidAmount) {

		Property property = propertyManager.getProperty(name);

		if(property != null) {

			if (property.isListed()) {

				if (bidAmount >= property.getAuction_price() && bidAmount > property.getHighest_bid()) {

					property.setHighest_bid(bidAmount);
					return true;
				}
			}
		}
		return false;
	}
}