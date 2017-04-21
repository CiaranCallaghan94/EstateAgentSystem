package estate_agent;

import java.util.LinkedList;
import java.util.List;

/**
 * NotificationManager stores all the notifications that are created.
 * It enables the functionality to get all the notifications or to get the notifications specific to a client.
 */

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

        // Loop through and add notifications that are related to the client_id
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
