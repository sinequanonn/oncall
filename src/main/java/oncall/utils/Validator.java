package oncall.utils;

import oncall.exception.ErrorMessage;

import java.util.List;

public class Validator {
    public static void validateMonthAndDayOfWeekSize(List<String> monthAndDayOfWeek) {
        if (monthAndDayOfWeek.size() != 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
