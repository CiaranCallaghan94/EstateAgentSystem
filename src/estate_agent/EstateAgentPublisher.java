package estate_agent;

import javax.xml.ws.Endpoint;

/**
 * Sean Anglim 		- 13382496
 * Ciaran Callaghan	- 13435438
 * 
 * [MAIN] This object, when run, will publish the endpoint.
 * This enables requests to be made to the EstateAgent
 * through the given address

 */
public class EstateAgentPublisher {

	// Publish the endpoints
    public static void main(String[]args) {
    	
        EstateAgent manager = new EstateAgent();
        Endpoint.publish("http://localhost:8080/EstateAgent", manager);
    }
}