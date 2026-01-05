package oncall.utils;

import oncall.exception.ErrorMessage;

import java.util.List;

public class Validator {
    public static void validateMonthAndDayOfWeekSize(List<String> monthAndDayOfWeek) {
        if (monthAndDayOfWeek.size() != 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    public static void validateCrewSize(List<String> crews) {
        if (crews.size() < 5 || crews.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CREW_SIZE.getMessage());
        }
    }

    public static void validateCrewNameSize(List<String> crews) {
        for (String crew : crews) {
            if (crew.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CREW_NAME_SIZE.getMessage());
            }
        }
    }

    public static void validateDuplicateName(List<String> crews) {
        for (String name : crews) {
            long count = crews.stream()
                    .filter(crew -> crew.equals(name))
                    .count();
            if (count > 1) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CREW.getMessage());
            }
        }
    }
}
