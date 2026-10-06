package CreationalPatterns;


interface NotificationService{
    void sendNotification();
}

class EmailNotification implements  NotificationService{

    @Override
    public void sendNotification() {
        System.out.println("Sending a email notification ... ");
    }
}

class SMSNotification implements NotificationService{

    @Override
    public void sendNotification() {
        System.out.println("Sending a sms notification ... ");
    }
}

class PushNotification implements NotificationService{

    @Override
    public void sendNotification() {
        System.out.println("Sending a push notification ... ");
    }
}


class NotificationFactory{

    public static NotificationService create(String type) {
        switch (type.toUpperCase()) {
            case "EMAIL": return new EmailNotification();
            case "SMS":   return new SMSNotification();
            case "PUSH":  return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

class FactoryPattern{

    public  static void main(String[] args){
        NotificationService n = NotificationFactory.create("SMS");
        n.sendNotification();
    }
}