import java.util.*; 

public class HorsePropertyGenerator{
    private static final String[] baseNames = {"thunder", "shadow", "blaze", "spirit", "luna", "midnight", "stormy"};

    private static final Set<String> usedNames = new HashSet<>();
    private static final String[] additionalNames = {"star", "comet", "galaxy", "moon", "cosmo"};
    private static final List<String> warCries = Arrays.asList("Hoorah", "Charge!", "Onward!", "Victory!", "For Glory!","Hooray", null);
    private static final Random random = new Random();


    public static String generateName(NameGenerationStrategy strategy) {
        return strategy.generateName();
    }

    // instance of NameGenerationStrategy using a lambda expression
    public static NameGenerationStrategy customNameStrategy = () -> {
        String fullName;
        int counter = 2;

        do {
            String baseName = baseNames[random.nextInt(baseNames.length)];
            String additionalName = "";
            fullName = baseName;

            if (usedNames.contains(fullName)) {
                additionalName = additionalNames[random.nextInt(additionalNames.length)];
                fullName = baseName + " " + additionalName;
            }

            if (usedNames.contains(fullName)) {
                fullName = baseName + " " + additionalName + " " + counter;
                counter++;
            }

        } while (!usedNames.add(fullName));

        return fullName;
    };


    public static String generateWarCry() {
        int randomIndex = random.nextInt(warCries.size());
        return warCries.get(randomIndex);
    }


    public static boolean isHorseHealthy() {
        return random.nextBoolean();
    }

    public static int generateRandomSpeed() {
        return random.nextInt(10) + 1; // Generates a random speed between 1 and 10
    }
}
