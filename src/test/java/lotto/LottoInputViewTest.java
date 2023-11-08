package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class LottoInputViewTest {
    LottoInputView lottoInputView = new LottoInputView();
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void purchaseAmountDivideBy1000() {
        String amount = "2001";
        assertThatThrownBy(() -> lottoInputView.divideValidation(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.");
    }

    @DisplayName("로또 구입 금액에 문자가 입력된 경우 예외가 발생한다.")
    @Test
    void purchaseAmountHasString() {
        String amount = "1000j";
        assertThatThrownBy(() -> lottoInputView.purchaseAmountHasString(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액에는 문자가 포함될 수 없습니다.");
    }

    @DisplayName("구입 금액이 공백이거나 공백이 포함된 경우 예외가 발생한다.")
    @Test
    void purchaseAmountHasBlank() {
        String amount = " ";
        assertThatThrownBy(() -> lottoInputView.purchaseAmountHasBlank(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액에는 공백이 입력될 수 없습니다.");
    }
}
