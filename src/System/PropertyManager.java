package System;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class PropertyManager {

    private List<Property> properties;

    public PropertyManager(){
    	properties = new LinkedList<Property>();
    }
    
    public void addProperty(String name, int district, int num_beds, int price, Calendar start, Calendar end) {
    	
    	Property new_prop = new Property(name, district, num_beds, price, start, end);
    	properties.add(new_prop);
    	new_prop.setPropertyId(properties.indexOf(new_prop));
    }

    public int getAmountOfProperties() {
        return properties.size();
    }

	public List<Property> getProperties() {

        properties.sort((p1, p2) -> new Integer(p1.getAuctionPrice()).compareTo(new Integer(p2.getAuctionPrice())));

		return properties;
	}

    public Property getProperty(int index){

    	if(index > properties.size() || index < 0) {
    		return null;
    	}
    	return properties.get(index);
    }
}