package oncall.repository;

import oncall.exception.ErrorMessage;

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

    public boolean isSameSize(int size) {
        return weekdayCrews.size() == size;
    }

    public boolean isEqualCrews(List<String> crews) {
        for (String crewName : crews) {
            long count = weekdayCrews.stream()
                    .filter(crew -> crew.equals(crewName))
                    .count();
            if (count != 1) {
                return false;
            }
        }
        return true;
    }
}
