package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.domain.exception.ErrorMessage;

public class NameExtractor {
    private static final String DELIMITER = ",";

    public static List<String> extractCarNames(String input) {
        validateNull(input);

        if (!input.contains(DELIMITER)) {
            String name = input.trim();
            validateName(name);
            return List.of(name);
        }

        String[] carArr = input.split(DELIMITER);
        List<String> nameList = Arrays.stream(carArr)
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();

        validateNameList(nameList);
        return nameList;
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME);
        }
    }

    private static void validateNameList(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME);
        }
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME);
        }
    }

    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME);
        }
    }
}
