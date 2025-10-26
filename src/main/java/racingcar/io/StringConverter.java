package racingcar.io;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StringConverter {
    public Queue<String> getCarsNameFrom(String carsNameList) {
        Queue<String> nameOfCars = new LinkedList<>();

        carsNameList = carsNameList.trim();
        StringTokenizer st = new StringTokenizer(carsNameList, ",");

        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            carName = carName.trim();

            if (!carName.isEmpty()) nameOfCars.offer(carName);
        }

        return nameOfCars;
    }

    public int getTrialCountFrom(String trialCount) {
        int count = 0;
        for (int i = 0; i < trialCount.length(); i++) {
            if (trialCount.charAt(i) >= '0' && trialCount.charAt(i) <= '9') {
                count = count * 10 + (trialCount.charAt(i) - '0');
                continue;
            }
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return count;
    }
}
