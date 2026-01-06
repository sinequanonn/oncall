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

    public boolean checkDuplicateNextWeekendCrew(String lastCrew) {
        return weekendCrews.get(0).equals(lastCrew);
    }

    public void changeWeekendOrder() {
        String crew = weekendCrews.remove(0);
        weekendCrews.add(1, crew);
    }

    public String getWeekendCrew() {
        String crew = weekendCrews.remove(0);
        weekendCrews.add(crew);
        return crew;
    }

    public boolean checkDuplicateNextWeekdayCrew(String lastCrew) {
        return weekdayCrews.get(0).equals(lastCrew);
    }

    public void changeWeekdayOrder() {
        String crew = weekdayCrews.remove(0);
        weekdayCrews.add(1, crew);
    }

    public String getWeekdayCrew() {
        String crew = weekdayCrews.remove(0);
        weekdayCrews.add(crew);
        return crew;
    }
}
