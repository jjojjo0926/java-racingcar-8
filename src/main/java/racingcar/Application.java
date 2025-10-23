package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameOfCars = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int trialCount = readTrialCount(Console.readLine());

        Race race = new Race();

        Set<String> participatedCars = new HashSet<>();
        StringTokenizer st = new StringTokenizer(nameOfCars, ",");

        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }

            if (participatedCars.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }

            participatedCars.add(carName);
            race.participateInRace(carName);
        }

        while (trialCount-- > 0) {
            race.run();
            race.printCarLocation();
        }
        race.printResult();

    }

    private static int readTrialCount(String trialCount) {
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
