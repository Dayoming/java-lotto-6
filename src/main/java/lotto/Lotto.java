package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> deduplicationList = numbers
                .stream()
                .distinct()
                .collect(Collectors.toList());

        if (deduplicationList.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}
