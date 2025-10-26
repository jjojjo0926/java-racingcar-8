package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    @DisplayName("Race를 생성하면 자동차의 advancedTimes는 0이 기본 값이다.")
    @Test
    void createRace() {
        List<String> nameOfCars = List.of("poni", "woni", "java");
        Race race = Race.from(new LinkedList<>(nameOfCars));

        assertThat(race.getCarsInRace()).hasSize(3)
                .extracting("name", "advancedTimes")
                .containsExactly(
                        tuple("poni", 0),
                        tuple("woni", 0),
                        tuple("java", 0)
                );
    }

    @DisplayName("동일한 차량이름이 입력되는 경우 예외 처리된다.")
    @Test
    void createRace2() {
        List<String> nameOfCars = List.of("poni", "poni", "java");

        assertThatThrownBy(() -> Race.from(new LinkedList<>(nameOfCars)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("동일한 차량 이름이 존재합니다.");
    }

    @DisplayName("동일한 이름의 차량이 추가되는 경우 예외 처리된다.")
    @Test
    void participateSameCar() {
        List<String> nameOfCars = List.of("poni", "java");
        Race race = Race.from(new LinkedList<>(nameOfCars));

        assertThatThrownBy(() -> race.participateInRace(Car.of("poni")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("동일한 차량 이름이 존재합니다.");
    }

}