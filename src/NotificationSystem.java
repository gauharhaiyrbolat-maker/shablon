// Интерфейс
interface INotification {
    void prepareMessage();
    void send();
    String getStatus();
}

// Email notification
class EmailNotification implements INotification {

    @Override
    public void prepareMessage() {
        System.out.println("Email хабарламасы дайындалды");
    }

    @Override
    public void send() {
        System.out.println("Email жіберілді");
    }

    @Override
    public String getStatus() {
        return "Email: sent";
    }
}

// SMS notification
class SMSNotification implements INotification {

    @Override
    public void prepareMessage() {
        System.out.println("SMS хабарламасы дайындалды");
    }

    @Override
    public void send() {
        System.out.println("SMS жіберілді");
    }

    @Override
    public String getStatus() {
        return "SMS: sent";
    }
}

// Push notification
class PushNotification implements INotification {

    @Override
    public void prepareMessage() {
        System.out.println("Push хабарлама дайындалды");
    }

    @Override
    public void send() {
        System.out.println("Push жіберілді");
    }

    @Override
    public String getStatus() {
        return "Push: sent";
    }
}

// Factory Method
class NotificationFactory {

    public static INotification createNotification(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Белгісіз notification түрі");
        }
    }
}

// Main class
public class NotificationSystem {
    public static void main(String[] args) {

        INotification notification =
                NotificationFactory.createNotification("email");

        notification.prepareMessage();
        notification.send();
        System.out.println(notification.getStatus());
    }
}
