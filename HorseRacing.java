import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HorseRacing {

    //creating Horses
    public static List<Horse> createHorses(int numberOfHorses) {
        return Stream.generate(HorseFactory::createHorse)
                .limit(numberOfHorses)
                .collect(Collectors.toList());
    }

    //Filtering the healthy horses and capitalizing the names of horses
    public static List<Horse> filterHealthyHorses(List<Horse> horses) {
        List<Horse> healthyHorses;

        do {
            healthyHorses = horses.stream()
                    .filter(Horse::isHealthy)
                    .peek(h -> h.setName(h.getName().toUpperCase()))
                    .collect(Collectors.toList());

            if (healthyHorses.size() < 2) {
                InputHandler inputHandler = new InputHandler();
                Scanner scanner = new Scanner(System.in);
                int numberOfHorses = inputHandler.getUserInput(scanner, "There are less than 2 healthy horses. Please provide the number of horses again: ");
                horses = createHorses(numberOfHorses);
            }
        } while (healthyHorses.size() < 2);

        return healthyHorses;
    }

        public static void race(List<Horse> healthyHorses, int finishLineDistance) {
            healthyHorses.parallelStream().forEach(horse -> horse.raceTurn(finishLineDistance));
        }



    public static void displayScoreboard(List<Horse> healthyHorses) {
        AtomicInteger rank = new AtomicInteger(1); // Initialize a counter for ranking

        healthyHorses.stream()
                .sorted(Comparator.comparingInt(Horse::getOrder))
                .forEach(horse -> {
                    System.out.println("Rank: " + rank.getAndIncrement() + ", Name: " + horse.getName() + ", Distance Traveled: " + horse.getDistanceTraveled());
                });
    }







}
