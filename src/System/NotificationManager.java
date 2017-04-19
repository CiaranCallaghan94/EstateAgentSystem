package System;

import java.util.LinkedList;
import java.util.List;


public class NotificationManager {

    private List<Notification> allNotifications;

    public NotificationManager(){
        allNotifications = new LinkedList<Notification>();
    }

    public List<Notification> getNotifications(){

        return allNotifications;
    }

    public List<Notification> getNotificationsForClient(int client_id){
        List<Notification> specificNotifications = new LinkedList<>();

        for(Notification n: allNotifications) {
            if (n.getClientId() == client_id) {
                specificNotifications.add(n);
            }
        }
        return specificNotifications;
    }

    public boolean addNotification(int client_id, String notification_message){

        allNotifications.add(new Notification(client_id,notification_message));
        return true;
    }
}
