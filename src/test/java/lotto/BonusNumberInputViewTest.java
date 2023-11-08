package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberInputViewTest {

    BonusNumberInputView bonusNumberInputView = new BonusNumberInputView();

    @DisplayName("입력한 보너스 번호가 공백인 경우 예외가 발생한다.")
    @Test
    void bonusNumberHasBlank() {
        String number = "";

        assertThatThrownBy(() -> bonusNumberInputView.bonusNumberHasBlank(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 공백을 입력할 수 없습니다.");
    }

    @DisplayName("보너스 번호에 문자가 입력된 경우 예외가 발생한다.")
    @Test
    void bonusNumberHasString() {
        String number = "a";
        assertThatThrownBy(() -> bonusNumberInputView.bonusNumberHasString(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호에는 문자가 포함될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 범위를 벗어난 경우 예외가 발생한다.")
    @Test
    void bonusNumberOutOfRange() {
        String number = "57";
        assertThatThrownBy(() -> bonusNumberInputView.bonusNumberOutOfRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 범위 내에서만 입력할 수 있습니다.");
    }
}
