package CreationalPatterns;


interface Notification{
    void send();
}

// product
class EmailNotification implements Notification{

    public void send(){
        System.out.println("Hey im a email Notification");
    }
}

// createrService
class EmailService extends  NotificationService{

    public Notification createNotification() {
        return new EmailNotification();
    }
}

//creater
abstract class NotificationService{

    //factory method
    abstract Notification createNotification();

}


public class FactoryPattern {

    public static void main(String[] args){
        NotificationService notificationService = new EmailService();
        notificationService.createNotification().send();

    }
}
