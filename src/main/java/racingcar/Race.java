package racingcar;

import java.util.*;

public class Race {
    private Set<String> participatedCars;
    private Queue<Car> carsInRace;
    private int lead;

    public static Race from(Queue<String> carsNameFromUser) {
        Race race = new Race();

        while (!carsNameFromUser.isEmpty()) {
            String carName = carsNameFromUser.poll();

            race.participateInRace(Car.of(carName));
        }

        return race;
    }

    private Race() {
        this.participatedCars = new HashSet<>();
        this.carsInRace = new LinkedList<>();
        this.lead = 0;
    }

    public void participateInRace(Car car) {
        if (participatedCars.contains(car.getName())) {
            throw new IllegalArgumentException("동일한 차량 이름이 존재합니다.");
        }
        carsInRace.offer(car);
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

    public Queue<Car> getCarsInRace() {
        return carsInRace;
    }

    public boolean isLeader(Car car) {
        return car.isLeader(this.lead);
    }
}
