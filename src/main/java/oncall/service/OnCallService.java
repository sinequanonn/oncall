package oncall.service;

import oncall.domain.Month;
import oncall.exception.ErrorMessage;
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
        Validator.validateDuplicateName(crews);
        crewRepository.saveWeekdayCrews(crews);
    }

    public void saveWeekendCrews(List<String> crews) {
        validateCrewSize(crews);
        validateSameCrew(crews);
        crewRepository.saveWeekendCrews(crews);
    }

    private void validateSameCrew(List<String> crews) {
        if (!crewRepository.isEqualCrews(crews)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WEEKEND_CREW.getMessage());
        }
    }

    private void validateCrewSize(List<String> crews) {
        if (!crewRepository.isSameSize(crews.size())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WEEKEND_CREW_SIZE.getMessage());
        }
    }
}
