import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Horse extends HorseRacing{
    private String name;
    private boolean healthy;
    private Integer distanceTraveled;
    private String warCry;
    private static AtomicInteger orderCounter = new AtomicInteger(1);
    private AtomicInteger order = new AtomicInteger(0);



    public Horse(String name, boolean healthy, String warCry) {
        this.name = name;
        this.healthy = healthy;
        this.distanceTraveled = 0;
        this.warCry = warCry;
    }

    public String getName() {
        return name;
    }
    public String setName(String name){
        this.name = name;
        return name;
    }

    public int getDistanceTraveled(){
        return distanceTraveled;
    }

    public String getWarCry() {
        return warCry;
    }


    public boolean isHealthy(){
        return healthy;
    }

    //generic method that checks if the Optional contains a value or not
    public static <T> void ifPresentOrElse(Optional<T> optional, Consumer<T> action, Runnable emptyAction) {
        if (optional.isPresent()) {
            action.accept(optional.get());
        } else {
            emptyAction.run();
        }
    }

    // Method for simulating a race turn
    public void raceTurn(int finishLineDistance) {
        while (distanceTraveled < finishLineDistance) {
            int speed = HorsePropertyGenerator.generateRandomSpeed(); // Generate random speed every turn
            distanceTraveled += speed;
            int distanceLeft = Math.max(0, finishLineDistance - distanceTraveled); // Ensure distanceLeft is non-negative

            System.out.println(name + " - Distance Traveled: " + distanceTraveled + " | Distance Left: " + distanceLeft);

            if (distanceLeft == 0) {
                order.set(orderCounter.getAndIncrement());
                ifPresentOrElse(
                        Optional.ofNullable(warCry),
                        wc -> System.out.println(name + " - " + wc ),
                        () -> System.out.println(name + " - No war cry")

                );
            }
            try {
                Thread.sleep(1000); // Sleep for 1 second for each turn
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public int getOrder() {
        return order.get();
    }



}
