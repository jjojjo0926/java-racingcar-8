package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.Race;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ConsoleIOHandler {
    private final StringConverter stringConverter = new StringConverter();

    public Queue<String> getCarsNameFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameOfCars = Console.readLine();

        return stringConverter.getCarsNameFrom(nameOfCars);
    }

    public int getTrialCountFromUser() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return stringConverter.getTrialCountFrom(Console.readLine());
    }

    public void printRaceSituation(Race race) {
        Iterator<Car> iter = race.carsIterator();
        while (iter.hasNext()) {
            Car car = iter.next();
            car.printAdvancedTimes();
        }

        System.out.println();
    }

    public void printRaceWinner(Race race) {
        System.out.print("최종 우승자 : ");
        Iterator<Car> iter = race.carsIterator();
        Queue<String> winners = new LinkedList<>();

        while (iter.hasNext()) {
            Car car = iter.next();
            if (race.isLeader(car)) {
                winners.add(car.getName());
            }
        }

        boolean isFirst = true;
        while (!winners.isEmpty()) {
            String winningCarName = winners.poll();

            if (isFirst) {
                isFirst = false;
                System.out.print(winningCarName);
            } else {
                System.out.print(", " + winningCarName);
            }
        }
    }
}
