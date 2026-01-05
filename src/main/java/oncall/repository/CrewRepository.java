package oncall.repository;

import java.util.List;

public class CrewRepository {
    private List<String> weekdayCrews;
    private List<String> weekendCrews;

    public void saveWeekdayCrews(List<String> crews) {
        weekdayCrews = crews;
    }

    public void saveWeekendCrews(List<String> crews) {
        weekendCrews = crews;
    }
}
