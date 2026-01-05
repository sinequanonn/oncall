package oncall.utils;

import oncall.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputConverter {
    public static final String DELIMITER_COMMA = ",";

    public static List<String> convertInputToList(String input) {
        return Arrays.stream(input.split(DELIMITER_COMMA))
                .map(String::trim)
                .toList();
    }

    public static int convertStrToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
