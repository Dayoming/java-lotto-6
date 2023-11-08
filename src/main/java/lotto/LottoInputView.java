package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public void inputPurchaseAmount() {
        try {
            String amount = Console.readLine();
            divideValidation(amount);
            purchaseAmountHasString(amount);
            purchaseAmountHasBlank(amount);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            inputPurchaseAmount();
        }
    }

    public void divideValidation(String amount) {
        Integer purchaseAmount = Integer.parseInt(amount);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.");
        }
    }

    public void purchaseAmountHasString(String amount) {
        try {
            Integer purchaseAmount = Integer.parseInt(amount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액에는 문자가 포함될 수 없습니다.");
        }
    }

    public void purchaseAmountHasBlank(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액에는 공백이 입력될 수 없습니다.");
        }
    }
}
