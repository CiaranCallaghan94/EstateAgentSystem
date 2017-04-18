package System;

import java.util.List;

import javax.jws.WebService;

// Service Endpoint
@WebService
public class EstateAgentImplementation{

	private PropertyManager PropertyManager = new PropertyManager();

    public String getProperties() {
        List<Property> allProperties = PropertyManager.getProperties();
        return allProperties.toString();
    }
}