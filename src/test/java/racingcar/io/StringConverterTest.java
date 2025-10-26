package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringConverterTest {

    @DisplayName(",를 기준으로 차량 이름을 저장하고 이름이 공백으로 시작하거나 끝나는 경우 공백을 제거한다")
    @Test
    void getCarNameFrom() {
        StringConverter stringConverter = new StringConverter();

        String nameOfCars = "poni, woni, java";

        Queue<String> carsName = stringConverter.getCarsNameFrom(nameOfCars);

        assertThat(carsName).hasSize(3)
                .extracting(String::valueOf)
                .containsExactlyInAnyOrder(
                        "poni", "woni", "java"
                );
    }

    @DisplayName("이름 내부 공백은 인정하지만 이름이 공백이라면 무시한다.")
    @Test
    void getCarNameFrom2() {
        StringConverter stringConverter = new StringConverter();

        String nameOfCars = "po ni, , woni";

        Queue<String> carsName = stringConverter.getCarsNameFrom(nameOfCars);

        assertThat(carsName).hasSize(2)
                .extracting(String::valueOf)
                .containsExactlyInAnyOrder(
                        "po ni", "woni"
                );
    }

    @DisplayName("이름이 공백으로만 입력된다면 예외 처리된다.")
    @Test
    void getCarNameFrom3() {
        StringConverter stringConverter = new StringConverter();

        String nameOfCars = "  ,  ";

        assertThatThrownBy(() -> stringConverter.getCarsNameFrom(nameOfCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력하셔야 합니다.");
    }

    @DisplayName("숫자가 입력되면 형변환 후 반환한다.")
    @Test
    void getTrialCountFrom() {
        StringConverter stringConverter = new StringConverter();

        String trialCount = "32";

        assertThat(stringConverter.getTrialCountFrom(trialCount)).isEqualTo(32);
    }

    @DisplayName("숫자가 아닌 문자만이 입력되면 예외 처리된다.")
    @Test
    void getTrialCountFrom2() {
        StringConverter stringConverter = new StringConverter();

        String trialCount = "asdf";

        assertThatThrownBy(() -> stringConverter.getTrialCountFrom(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @DisplayName("숫자와 숫자가 아닌 문자가 동시에 입력되면 예외 처리된다.")
    @Test
    void getTrialCountFrom3() {
        StringConverter stringConverter = new StringConverter();

        String trialCount = "3a2";

        assertThatThrownBy(() -> stringConverter.getTrialCountFrom(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

}