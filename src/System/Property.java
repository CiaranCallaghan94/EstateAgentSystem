package System;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * class to represent a room
 *
 * a room can be requested by a person using SOAP
 * if the room is not already occupied when a person requests
 * the room then the will receive it, otherwise they will be
 * added to a waiting list of people for the room at their
 * desired time
 *
 * a room booking can also be cancelled using the booking
 * id as a reference
 *
 * the rooms can only be accessed by one client at a time
 * and reentrant locks have been used to ensure mutual exclusion
 *
 * Example Room(name=L125, capacity=40, bookableFor=8hrs)
 *
 */

class Property {
    private int capacity;
    private String name;
    private Queue<String>[][] calendar;
    private Map<String, Integer> dayMap;
    private final Lock lock = new ReentrantLock();

    /**
     * full args constructor for the room
     * @param name to be assigned to the room
     * @param capacity of the room
     * @param hours of operation
     */
    Property(String name, int capacity, int hours) {
        this.capacity = capacity;
        this.name = name;

        calendar = new LinkedList[7][hours];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < hours; j++){
                Queue<String> d = new LinkedList<>();
                calendar[i][j] = d;
            }
        }
        /*
        this map is used to map the string days to their
        position in the MDArray
         */
        dayMap = new LinkedHashMap<>();
        dayMap.put("monday", 0);
        dayMap.put("tuesday", 1);
        dayMap.put("wednesday", 2);
        dayMap.put("thursday", 3);
        dayMap.put("friday", 4);
        dayMap.put("saturday", 5);
        dayMap.put("sunday", 6);
    }

    /**
     * function to return the capacity of a room
     * @return Integer representing the capacity of the room
     */
    public int getCapacity() {
        lock.lock();
        try {
            return this.capacity;
        }finally {
            lock.unlock();
        }
    }

    /**
     * @return String representation of the weekly calendar
     */
    public String getWeeklyCalendar(){
        String week = "";
        for (Map.Entry<String, Integer> day : dayMap.entrySet()){
            week += day.getKey() + " available hours: ";

            for (int i = 0; i < calendar[day.getValue()].length; i++){
                if (calendar[day.getValue()][i].isEmpty()){
                    week += i + " ";
                }
            }
            week += "\n";
        }
        return week;
    }

    /**
     * @return String name of the room
     */
    public String getName(){
        return name;
    }

    /**
     * function to check whether the room is free on this
     * day at this time
     * @param day of the week being checked
     * @param hour of the day being checked
     * @return boolean representing whether the room is free
     */
    public boolean isAvailable(String day, int hour) {
        lock.lock();
        try {
            day = day.toLowerCase();
            int dayValue = dayMap.get(day);
            return calendar[dayValue][hour].isEmpty();
        }
        catch (NullPointerException e){
            return false;
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * function to make a booking for a room
     * @param day of the week
     * @param hour in the day
     * @param id of the booking
     * @return boolean value representing whether the booking was successful
     * @throws InterruptedException
     */
    public boolean makeBooking(String day, int hour, String id) throws InterruptedException{
        try {
            lock.lock();

            day = day.toLowerCase();
            int dayValue = dayMap.get(day);

            calendar[dayValue][hour].add(id);
            return true;
        }
        catch (NullPointerException e){
            return false;
        }
        finally{
            lock.unlock();
        }
    }

    /**
     * function to cancel a room booking
     * @param day of the week
     * @param hour in the day
     * @param id of the booking
     * @return boolean value representing whether the cancel was successful
     */
    public boolean cancelBooking(String day, int hour, String id) {
        lock.lock();

        try {
            day = day.toLowerCase();
            int dayValue = dayMap.get(day);
            if (calendar[dayValue][hour].contains(id)) {
                calendar[dayValue][hour].remove(id);
                return true;
            }
            else return false;
        }catch (NullPointerException e){
            return false;
        }

        finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

}