package oncall.service;

import oncall.domain.Month;
import oncall.repository.CrewRepository;
import oncall.repository.DayOfWeekRepository;
import oncall.repository.ResultRepository;
import oncall.utils.Validator;

import java.util.List;

public class OnCallService {
    private final CrewRepository crewRepository;
    private final ResultRepository resultRepository;
    private final DayOfWeekRepository dayOfWeekRepository;

    public OnCallService(CrewRepository crewRepository, ResultRepository resultRepository, DayOfWeekRepository dayOfWeekRepository) {
        this.crewRepository = crewRepository;
        this.resultRepository = resultRepository;
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public void saveMonth(int month) {
        resultRepository.saveMonth(Month.of(month));
    }

    public void saveDayOfWeek(String dayOfWeek) {
        dayOfWeekRepository.initDayOfWeek(dayOfWeek);
    }

    public void saveWeekdayCrews(List<String> crews) {
        crewRepository.saveWeekdayCrews(crews);
    }
}
