package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest extends IOTest {

    @DisplayName("5글자를 초과하는 자동차 이름이 입력되는 경우 예외 처리된다.")
    @Test
    void createCar(){
        String name = "poniii";

        assertThatThrownBy(()->Car.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void getName() {
        Car poni = Car.of("poni");

        assertThat(poni.getName()).isEqualTo("poni");
    }

    @Test
    void getAdvancedTimes() {
        Car poni = Car.of("poni", 1);

        assertThat(poni.getAdvancedTimes()).isEqualTo(1);
    }

    @Test
    void isLeader_테스트(){
        Car poni = Car.of("poni", 1);

        assertThat(poni.isLeader(1)).isTrue();
        assertThat(poni.isLeader(2)).isFalse();
    }

    @Test
    void printAdvancedTimes_테스트() {
        Car poni = Car.of("poni", 2);

        poni.printAdvancedTimes();

        assertThat(output()).contains("poni : --");
    }

}