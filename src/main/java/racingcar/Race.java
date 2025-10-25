package racingcar;

import java.util.*;

public class Race {
    private Queue<Car> carsInRace;
    private int lead;

    public static Race from(Queue<String> carsNameFromUser) {
        Race race = new Race();

        Set<String> participatedCars = new HashSet<>();

        while (!carsNameFromUser.isEmpty()) {
            String carName = carsNameFromUser.poll();

            if (participatedCars.contains(carName)) {
                throw new IllegalArgumentException("동일한 차량 이름이 존재합니다.");
            }

            participatedCars.add(carName);
            race.participateInRace(carName);
        }

        return race;
    }

    private Race() {
        this.carsInRace = new LinkedList<>();
        this.lead = 0;
    }

    public void participateInRace(String carName) {
        carsInRace.offer(Car.of(carName));
    }

    public void run() {
        Iterator<Car> iter = carsInRace.iterator();
        while (iter.hasNext()) {
            Car car = iter.next();
            car.advance();
            if (car.isLeader(lead)) {
                lead = car.getAdvancedTimes();
            }
        }
    }

    public Iterator<Car> carsIterator() {
        return carsInRace.iterator();
    }

    public boolean isLeader(Car car) {
        return car.isLeader(this.lead);
    }
}
