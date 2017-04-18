package System;

import java.util.List;

import javax.jws.WebService;


/**
 * service endpoint
 * this is the implementation for the room booking service
 */
@WebService
public class EstateAgentImplementation{

	private PropertyManager PropertyManager = new PropertyManager();

    /**
     * @return String representation of the rooms and tier capacity
     */
    public List<Property> getProperties() {
        List<Property> allProperties = PropertyManager.getProperties();
//        String roomsAndCapacities = "";
//
//        for(String key: keys)
//            roomsAndCapacities = roomsAndCapacities + key + ": "+ PropertyManager.getRoomCapacity(key)+", ";
//
//        if(roomsAndCapacities.length() > 2)
//            roomsAndCapacities = roomsAndCapacities.substring(0, (roomsAndCapacities.length()-2));
        return allProperties;
    }

    /**
     * @param roomName String name of the room being referenced
     * @return String representation of a rooms weekly calendar
     */
//    public String getRoomTimetable(String roomName) {
//        return PropertyManager.getWeeklyCalendar(roomName);
//    }

    /**
     * @param roomName String name of the room being referenced
     * @param day      String day of the week
     * @param hour     int hour in the day
     * @return boolean for whether a room is available
     */
//    public boolean checkRoomAvailability(String roomName, String day, int hour) {
//        return PropertyManager.isAvailable(roomName, day, hour);
//    }
//
//    /**
//     * @param roomName String name of the room being referenced
//     * @param day      String day of the week
//     * @param hour     int hour in the day
//     * @param id       String id of the booking
//     * @return boolean representing the success of a booking
//     * @throws InterruptedException
//     */
//    public boolean makeRoomBooking(String roomName, String day, int hour, String id)
//            throws InterruptedException {
//        return PropertyManager.makeBooking(roomName, day, hour, id);
//    }
//
//    /**
//     * @param roomName String name of the room being referenced
//     * @param day      String day of the week
//     * @param hour     int hour in the day
//     * @param id       String id of the booking
//     * @return boolean representing the success of a cancel
//     */
//    public boolean cancelRoomBooking(String roomName, String day, int hour, String id) {
//        return PropertyManager.cancelBooking(roomName, day, hour, id);
//    }
}