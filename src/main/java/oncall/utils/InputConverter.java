package oncall.utils;

import java.util.Arrays;
import java.util.List;

public class InputConverter {
    public static final String DELIMITER_COMMA = ",";

    public static List<String> convertInputToList(String input) {
        return Arrays.stream(input.split(DELIMITER_COMMA))
                .map(String::trim)
                .toList();
    }
}
