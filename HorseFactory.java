public class HorseFactory {
    public static Horse createHorse() {
        String name = HorsePropertyGenerator.generateName(HorsePropertyGenerator.customNameStrategy);
        boolean healthy = HorsePropertyGenerator.isHorseHealthy();
        String warCry = HorsePropertyGenerator.generateWarCry();

        return new Horse(name, healthy, warCry);
    }
}
