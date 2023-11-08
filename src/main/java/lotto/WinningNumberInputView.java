package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumberInputView {
    public Lotto winningNumberInput() {
        List<Integer> splitNumbers = new ArrayList<>();
        try {
            String number = Console.readLine();
            winningNumberHasBlank(number);
            String[] numbers = number.split(",");
            splitNumbers = winningNumberHasString(numbers);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            winningNumberInput();
        }
        Lotto winningNumber = createWinningNumber(splitNumbers);
        return winningNumber;
    }

    public void winningNumberHasBlank(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 공백을 입력할 수 없습니다.");
        }
    }

    public List<Integer> winningNumberHasString(String[] numbers) {
        List<Integer> splitNumbers = new ArrayList<>();
        try {
            for (String num : numbers) {
                Integer numToInteger = Integer.parseInt(num);
                splitNumbers.add(numToInteger);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표 이외의 문자를 입력할 수 없습니다.");
        }
        return splitNumbers;
    }

    public Lotto createWinningNumber(List<Integer> splitNumbers) {
        Lotto winningNumber = new Lotto(splitNumbers);
        return winningNumber;
    }
}
