package estate_agent;

/**
 * Notification is an object which contains the client_id that the message will be sent to
 * and notification_message which is the message itself
 */

public class Notification {

    private int client_id;
    private String notification_message;

    Notification() {
    }

    public Notification(int client_id, String notification_message) {

        this.client_id = client_id;
        this.notification_message = notification_message;
    }

    public int getClientId() {
        return this.client_id;
    }

    public void setClientId(int client_id) {
        this.client_id = client_id;
    }

    public String getNotificationMessage() {
        return this.notification_message;
    }

    public void setNotificationMessage(String notification_message) {
        this.notification_message = notification_message;
    }
}