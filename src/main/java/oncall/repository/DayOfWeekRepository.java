package oncall.repository;

import oncall.exception.ErrorMessage;

import java.util.List;

public class DayOfWeekRepository {
    private static List<String> dayOfWeeks = List.of("일", "월", "화", "수", "목", "금", "토");
    private int order;

    public void initDayOfWeek(String dayOfWeek) {
        if (!dayOfWeeks.contains(dayOfWeek)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        this.order = dayOfWeeks.indexOf(dayOfWeek);
    }
}
