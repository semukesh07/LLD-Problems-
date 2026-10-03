package BehaviouralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface StockObservable {
    void add(StockObserver observer);
    void remove(StockObserver observer);
    void notifyObservers();
    void addStock(int count);
    int getStockCount();
}

interface StockObserver {
    void update();
}

class IphoneObservable implements StockObservable {
    private int stockCount = 0;
    private final List<StockObserver> observers = new ArrayList<>();

    @Override
    public void add(StockObserver observer) { observers.add(observer); }

    @Override
    public void remove(StockObserver observer) { observers.remove(observer); }

    @Override
    public void notifyObservers() {
        for (StockObserver o : observers) {
            o.update();
        }
    }

    @Override
    public void addStock(int count) {
        boolean wasOutOfStock = (stockCount == 0);
        stockCount += count;
        if (wasOutOfStock && stockCount > 0) {
            notifyObservers();
        }
    }

    @Override
    public int getStockCount() { return stockCount; }
}

class EmailObserver implements StockObserver {
    private final String emailId;
    private final StockObservable observable;

    EmailObserver(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Email to " + emailId + ": iPhone is back in stock ("
                + observable.getStockCount() + " units)");
    }
}

class MobileObserver implements StockObserver {
    private final String number;
    private final StockObservable observable;

    MobileObserver(String number, StockObservable observable) {
        this.number = number;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("SMS to " + number + ": iPhone is back in stock!");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockObservable iphone = new IphoneObservable();

        iphone.add(new EmailObserver("abc1@gmail.com", iphone));
        iphone.add(new MobileObserver("9999999999", iphone));

        iphone.addStock(10);   // 0 -> 10: observers notified
        iphone.addStock(5);    // already in stock: no notification
    }
}