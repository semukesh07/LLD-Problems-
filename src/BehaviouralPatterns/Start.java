interface PricingStrategy {
    double calculateFare(double km, int minutes);
}

class StandardPricing implements PricingStrategy {
    public double calculateFare(double km, int minutes) {
        return 10 * km;
    }
}

class PremiumPricing implements PricingStrategy {
    public double calculateFare(double km, int minutes) {
        return (18 * km) + (2 * minutes);
    }
}

class SurgePricing implements PricingStrategy {
    private final double multiplier;

    SurgePricing(double multiplier) {
        this.multiplier = multiplier;
    }

    public double calculateFare(double km, int minutes) {
        return 10 * km * multiplier;
    }
}

class Ride {
    private final double km;
    private final int minutes;
    private PricingStrategy pricing;

    Ride(double km, int minutes, PricingStrategy pricing) {
        this.km = km;
        this.minutes = minutes;
        this.pricing = pricing;
    }

    void setPricing(PricingStrategy pricing) {   // swap at runtime
        this.pricing = pricing;
    }

    double calculateFare() {
        return pricing.calculateFare(km, minutes);
    }
}

public class Start {
    public static void main(String[] args) {
        Ride ride = new Ride(6, 20, new PremiumPricing());
        System.out.println(ride.calculateFare());   // 148.0

        ride.setPricing(new SurgePricing(1.5));
        System.out.println(ride.calculateFare());   // 90.0
    }
}