package System;

import javax.xml.ws.Endpoint;

/**
 * EstateAgentPublisher will be run which publishes the endpoint.
 * This enables requests to be made to the EstateAgentImplementation through the given address
 */
// Publish the endpoints
public class EstateAgentPublisher {

    public static void main(String[]args) {
    	
        EstateAgentImplementation manager = new EstateAgentImplementation();
        Endpoint.publish("http://localhost:8080/EstateAgent", manager);
    }
}