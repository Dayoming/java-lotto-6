package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberInputViewTest {

    WinningNumberInputView winningNumberInputView = new WinningNumberInputView();

    @DisplayName("입력한 당첨 번호가 공백인 경우 예외가 발생한다.")
    @Test
    void winningNumberHasBlank() {
        String number = "";

        assertThatThrownBy(() -> winningNumberInputView.winningNumberHasBlank(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 공백을 입력할 수 없습니다.");
    }

    @DisplayName("입력한 당첨 번호에 쉼표 이외의 문자가 입력된 경우 예외가 발생한다.")
    @Test
    void winningNumberHasString() {
        String number = "1,a2,a3,4,5,6";
        String[] numbers = number.split(",");

        assertThatThrownBy(() -> winningNumberInputView.winningNumberHasString(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표 이외의 문자를 입력할 수 없습니다.");
    }

    @DisplayName("입력한 당첨 번호로 당첨 번호 Lotto를 만든다.")
    @Test
    void createWinningNumber() {
        List<Integer> splitNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Lotto winningNumber = winningNumberInputView.createWinningNumber(splitNumbers);

        assertThat(lotto)
                .usingRecursiveComparison()
                .isEqualTo(winningNumber);
    }
}
