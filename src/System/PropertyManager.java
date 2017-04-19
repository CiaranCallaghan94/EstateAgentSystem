package System;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class PropertyManager {

    private List<Property> properties;

    public PropertyManager(){
    	properties = new LinkedList<Property>();
    }
    
    public boolean addProperty(String name, int district, int num_beds, double price, Calendar start, Calendar end) {
    	
    	if(!propertyValid(district, num_beds, price, start, end))
    		return false;
    	
    	Property new_prop = new Property(name, district, num_beds, price, start, end);
    	properties.add(new_prop);
    	new_prop.setPropertyId(properties.indexOf(new_prop));
    	return true;
    }
    
    public boolean propertyValid(int district, int num_beds, double price, Calendar start, Calendar end) {
    	
    	if(district < 0 || num_beds < 0 || price < 0)
    		return false;
    	
    	if(start.compareTo(end) > 0) {
    		System.out.println("Start after end");
    		return false;
    	}
    	return true;
    }

    public int getAmountOfProperties() {
        return properties.size();
    }

	public List<Property> getProperties() {

        properties.sort((p1, p2) -> Double.compare(p1.getAuctionPrice(), p2.getAuctionPrice()));
		return properties;
	}

    public Property getProperty(int index){

    	if(index > properties.size()-1 || index < 0) {
    		return null;
    	}
    	return properties.get(index);
    }
}