package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int advancedTimes;

    public static Car of(String name) {
        return new Car(name, 0);
    }

    private Car(String name, int advancedTimes) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.advancedTimes = advancedTimes;
    }

    public void advance(){
        int advanceSpace = Randoms.pickNumberInRange(0, 9);
        if(advanceSpace>=4){
            advancedTimes ++;
        }
    }

    public boolean isLeader(int lead) {
        return this.advancedTimes >= lead;
    }

    public void printAdvancedTimes() {
        System.out.print(this.name + " : ");
        for(int i = 0; i < this.advancedTimes; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName(){
        return this.name;
    }

    public int getAdvancedTimes() {
        return this.advancedTimes;
    }
}
