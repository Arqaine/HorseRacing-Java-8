import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("****HORSE RACING GAME****");

        InputHandler inputHandler = new InputHandler();
        Scanner scanner = new Scanner(System.in);

        int finishLineDistance = inputHandler.getUserInput(scanner, "Enter the distance of the finish line: ");
        int numberOfHorses = inputHandler.getUserInput(scanner, "Enter the number of horses: ");

        //creates and filters healthy Horses
        List<Horse> allHorses = HorseRacing.createHorses(numberOfHorses);
        List<Horse> healthyHorses = HorseRacing.filterHealthyHorses(allHorses);

        System.out.println("\nThere are " + healthyHorses.size() + " healthy horses that can proceed to the game!\n");


        // Print information about healthy horses
        for (Horse horse : healthyHorses) {
            String horseName = horse.getName();
            System.out.println("===================");
            System.out.println("Horse Name: " + horseName);
            System.out.println("===================");
        }

        System.out.println("\nLet the game begin!\n");

        //start the race
        HorseRacing.race(healthyHorses, finishLineDistance);

        //display scoreboard
        System.out.println("\nScoreboard:");
        Horse.displayScoreboard(healthyHorses);


    }
}