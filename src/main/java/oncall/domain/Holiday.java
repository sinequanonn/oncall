package oncall.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum Holiday {
    ONE(1, 1),
    TWO(3, 1),
    THREE(5, 5),
    FOUR(6, 6),
    FIVE(8, 15),
    SIX(10, 3),
    SEVEN(10, 9),
    EIGHT(12, 25),
    ;

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean contains(int month, int day) {
        return Arrays.stream(Holiday.values())
                .anyMatch(holiday -> holiday.day == day && holiday.month == month);
    }
}
