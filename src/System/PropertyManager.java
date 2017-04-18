package System;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * class to handle the rooms
 * essentially acts as a wrapper for the room objects
 * to be used in the implementation class
 *
 * generates each of the rooms from a file and then
 * allows for them to be accessed and queried through here
 *
 */
public class PropertyManager {

    private List<Property> properties = new LinkedList<Property>();

    /**
     * no-args constructor
     * it generates the rooms based off a file called room.properties
     */
    public PropertyManager(){
    	
    	properties.add(new Property("hi",2,2));
    	properties.add(new Property("hi 2",3,3));
//        Properties properties = new Properties();
//        InputStream inputStream;
//        String filename = "rooms.properties";
//        try {
////            inputStream = Room.class.getResourceAsStream(filename);
////            properties.load(inputStream);
////
////            Enumeration<?> enumeration = properties.propertyNames();
////
////            while (enumeration.hasMoreElements()) {
////                String key = (String) enumeration.nextElement();
////                String value = properties.getProperty(key);
////                try {
////                    int capacity = Integer.parseInt(value);
////                    rooms.put(key, new Property(key, capacity, 12));
////                } catch (NumberFormatException e) {}
//            }
//        }catch (IOException e){}
    }

    /**
     * @param room the room being referenced
     * @return the capacity of the specified room
     */
    public int getAmountOfProperties() {
        return properties.size();
    }

    /**
     * function to make a booking
     * @param roomName room being referenced
     * @param day of the week
     * @param hour in the day
     * @param id of the booking
     * @return boolean representing whether the booking was made
     * @throws InterruptedException
     */
//    public boolean makeBooking(String roomName, String day, int hour, String id)
//            throws InterruptedException {
//        try {
//            return rooms.get(roomName).makeBooking(day, hour, id);
//        }catch (NullPointerException e){
//            return false;
//        }
//    }

    /**
     * function to cancel a booking
     * @param roomName room being referenced
     * @param day of the week
     * @param hour in the day
     * @param id of the booking
     * @return boolean representing whether the booking was cancelled
     */
//    public boolean cancelBooking(String roomName, String day, int hour, String id) {
//        return rooms.get(roomName).cancelBooking(day, hour, id);
//    }
//
//    /**
//     * function to check if a room is available at a given time
//     * @param roomName room being referenced
//     * @param day of the week
//     * @param hour in the day
//     * @return boolean result
//     */
//    public boolean isAvailable(String roomName, String day, int hour) {
//        return rooms.get(roomName).isAvailable(day, hour);
//    }

	public List<Property> getProperties() {
		// TODO Auto-generated method stub
		return properties;
	}

}