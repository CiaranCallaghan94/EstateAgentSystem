package System;

import javax.jws.WebService;
import java.util.List;

// Service Endpoint
@WebService
public class EstateAgentImplementation{

	private PropertyManager PropertyManager = new PropertyManager();

    public List<Property> getProperties() {
        List<Property> allProperties = PropertyManager.getProperties();
        return allProperties;
    }
}