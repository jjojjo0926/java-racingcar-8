package racingcar;

import racingcar.io.ConsoleIOHandler;

import java.util.Queue;

public class Application {
    public static void main(String[] args) {
        ConsoleIOHandler consoleIOHandler = new ConsoleIOHandler();

        Queue<String> carsNameFromUser = consoleIOHandler.getCarsNameFromUser();
        int trialCount = consoleIOHandler.getTrialCountFromUser();

        Race race = Race.from(carsNameFromUser);

        while (trialCount-- > 0) {
            race.run();
            consoleIOHandler.printRaceSituation(race);
        }

        consoleIOHandler.printRaceWinner(race);
    }
}
