package System;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class PropertyManager {

    private List<Property> properties = new LinkedList<Property>();

    public PropertyManager(){
    	
    	System.out.println("Created properties");
    }
    
    public void addProperty(String name, int district, int num_beds, int price, Calendar start, Calendar end) {
    	
    	properties.add(new Property(name, district, num_beds, price, start, end));
    }

    public int getAmountOfProperties() {
        return properties.size();
    }

	public List<Property> getProperties() {
		return properties;
	}

    public Property getProperty(String name){

        for(Property p : properties){

            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
}