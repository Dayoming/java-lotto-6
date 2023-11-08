package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInputView {
    public Integer inputBonusNumber() {
        String number = Console.readLine();
        try {
            bonusNumberHasBlank(number);
            bonusNumberHasString(number);
            bonusNumberOutOfRange(number);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            inputBonusNumber();
        }
        return Integer.parseInt(number);
    }

    public void bonusNumberHasBlank(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 공백을 입력할 수 없습니다.");
        }
    }

    public void bonusNumberHasString(String number) {
        try {
            Integer numberToInteger = Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에는 문자가 포함될 수 없습니다.");
        }
    }

    public void bonusNumberOutOfRange(String number) {
        Integer numberToInteger = Integer.parseInt(number);
        if (numberToInteger < 1 || numberToInteger > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 범위 내에서만 입력할 수 있습니다.");
        }
    }
}
