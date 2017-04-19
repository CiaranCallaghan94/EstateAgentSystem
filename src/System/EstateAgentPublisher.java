package System;

import javax.xml.ws.Endpoint;

// Publish the endpoints
public class EstateAgentPublisher {

    public static void main(String[]args) {
    	
        EstateAgentImplementation manager = new EstateAgentImplementation();
        Endpoint.publish("http://localhost:8080/EstateAgent", manager);
    }
}