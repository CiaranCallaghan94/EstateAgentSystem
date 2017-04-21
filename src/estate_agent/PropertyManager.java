package estate_agent;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * PropertyManager is in charge of all the properties on the server.
 * It is responsible for adding new properties to the list of properties,
 * returning a list of all properties and returning a property given the property_id
 */
public class PropertyManager {

    private List<Property> properties;
    NotificationManager notificationManager;

    public PropertyManager(NotificationManager notificationManager){
    	properties = new LinkedList<Property>();
        this.notificationManager = notificationManager;
    }

	// Adds a new property to the list of properties
    public boolean addProperty(String name, int district, int num_beds, double price, Calendar start, Calendar end) {
    	
    	if(!propertyValid(district, num_beds, price, start, end))
    		return false;
    	
    	Property new_prop = new Property(notificationManager,name, district, num_beds, price, start, end);
    	properties.add(new_prop);
    	new_prop.setPropertyId(properties.indexOf(new_prop));
    	return true;
    }

	// Checks whether the property is valid
    public boolean propertyValid(int district, int num_beds, double price, Calendar start, Calendar end) {
    	
    	if(district < 0 || num_beds < 0 || price < 0)
    		return false;
    	
    	if(start.compareTo(end) > 0) {
    		System.out.println("Start after end");
    		return false;
    	}
    	return true;
    }

	// Returns a list of all the properties
	public List<Property> getProperties() {

        properties.sort((p1, p2) -> Double.compare(p1.getAuctionPrice(), p2.getAuctionPrice()));
		return properties;
	}

	//Returns a property specified by the index
    public Property getProperty(int index){

    	if(index > properties.size()-1 || index < 0) {
    		return null;
    	}
    	return properties.get(index);
    }
}