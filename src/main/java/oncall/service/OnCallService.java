package oncall.service;

import oncall.domain.Month;
import oncall.repository.DayOfWeekRepository;
import oncall.repository.ResultRepository;

public class OnCallService {
    private final ResultRepository resultRepository;
    private final DayOfWeekRepository dayOfWeekRepository;

    public OnCallService(ResultRepository resultRepository, DayOfWeekRepository dayOfWeekRepository) {
        this.resultRepository = resultRepository;
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public void saveMonth(int month) {
        resultRepository.saveMonth(Month.of(month));
    }

    public void saveDayOfWeek(String dayOfWeek) {
        dayOfWeekRepository.initDayOfWeek(dayOfWeek);
    }
}
