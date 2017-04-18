package System;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertyManager {

    private List<Property> properties = new LinkedList<Property>();

    public PropertyManager(){
    	
    	properties.add(new Property("Property_1", 2, 2, 100000));
    	properties.add(new Property("Property 2", 3, 3, 200000));
    	System.out.println("Created properties");
    }

    public int getAmountOfProperties() {
        return properties.size();
    }

	public List<Property> getProperties() {
		return properties;
	}
}