package System;

import javax.xml.ws.Endpoint;

/**
 * the publisher for the endpoints
 */
public class EstateAgentPublisher {

    public static void main(String[]args) {
    	
        EstateAgentImplementation manager = new EstateAgentImplementation();
        Endpoint.publish("http://localhost:8000/EstateAgent", manager);
    }

}