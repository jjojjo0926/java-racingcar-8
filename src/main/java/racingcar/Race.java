package racingcar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Race {
    Queue<Car> carsInRace;
    int lead;

    public Race(){
        this.carsInRace = new LinkedList<>();
        this.lead = 0;
    }

    public void participateInRace(String carName){
        carsInRace.offer(Car.of(carName));
    }

    public void run(){
        Iterator<Car> iter = carsInRace.iterator();
        while(iter.hasNext()){
            Car car = iter.next();
            car.advance();
            if(car.isLeader(lead)){
                lead = car.advancedTimes;
            }
        }
    }

    public void printCarLocation(){
        Iterator<Car> iter = carsInRace.iterator();
        while(iter.hasNext()){
            Car car = iter.next();
            car.printAdvancedTimes();
        }

        System.out.println();
    }

    public void printResult() {
        System.out.print("최종 우승자 : ");
        Iterator<Car> iter = carsInRace.iterator();
        Queue<Car> winners = new LinkedList<>();
        while(iter.hasNext()){
            Car car = iter.next();
            if(car.isLeader(lead)){
                winners.add(car);
            }
        }

        boolean isFirst = true;
        while(!winners.isEmpty()){
            Car car = winners.poll();

            if(isFirst){
                isFirst = false;
                System.out.print(car.name);
            }else{
                System.out.print(", " + car.name);
            }
        }
    }
}
