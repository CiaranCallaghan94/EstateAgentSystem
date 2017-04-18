package System;

import java.util.LinkedList;
import java.util.List;

public class PropertyManager {

    private List<Property> properties = new LinkedList<Property>();

    public PropertyManager(){
    	
    	properties.add(new Property("Property_1", 2, 2, 100000));
    	properties.add(new Property("Property_2", 3, 3, 200000));
    	System.out.println("Created properties");
    }

    public int getAmountOfProperties() {
        return properties.size();
    }

	public List<Property> getProperties() {
		return properties;
	}
}