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
    
    public boolean listPropertyForSale(@WebParam(name = "name") String name, int district, int num_bedrooms, int price,
    		int start_year, int start_month, int start_date, int end_year, int end_month, int end_date) {
    	
    	Calendar start = new GregorianCalendar(start_year, start_month, start_date);
    	Calendar end = new GregorianCalendar(end_year, end_month, end_date);
    	
    	propertyManager.addProperty(name, district, num_bedrooms, price, start, end);
    	return true;
    }
}