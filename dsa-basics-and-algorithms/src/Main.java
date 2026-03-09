// Strategy Design Pattern: Travel Modes Example

// Step 1: Strategy Interface
interface TransportStrategy {
    void travel(String destination);
}

// Step 2: Concrete Strategies

class Car implements TransportStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Car.");
    }
}

class Bike implements TransportStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Bike.");
    }
}

class Bus implements TransportStrategy {
    public void travel(String destination) {
        System.out.println("Travelling to " + destination + " by Bus.");
    }
}

// Step 3: Context Class
class TravelContext {
    private TransportStrategy strategy;

    public void setStrategy(TransportStrategy strategy) {
        this.strategy = strategy;
    }

    public void goToDestination(String destination) {
        if (strategy == null) {
            System.out.println("Please select a mode of transport first!");
        } else {
            strategy.travel(destination);
        }
    }
}

// Step 4: Main Class (Client)
public class Main {
    public static void main(String[] args) {
        TravelContext context = new TravelContext();

        // Travel by Car
        context.setStrategy(new Car());
        context.goToDestination("Hyderabad");

        // Switch to Bike
        context.setStrategy(new Bike());
        context.goToDestination("University");

        // Switch to Bus
        context.setStrategy(new Bus());
        context.goToDestination("Karachi");
    }
}
