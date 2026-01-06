package oncall.service;

import oncall.domain.Holiday;
import oncall.dto.LastCrew;
import oncall.domain.Month;
import oncall.domain.OnCall;
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

    public void makeTodayOnCall(boolean isWeekday, boolean isHoliday) {

    }

    public Month findMonth() {
        return resultRepository.getMonth();
    }

    public boolean checkTodayIsWeekday() {
        return dayOfWeekRepository.checkTodayIsWeekday();
    }

    public boolean checkTodayIsHoliday(Month month, int day) {
        return Holiday.contains(month.getMonth(), day);
    }

    public void makeWeekendOnCall(int day, LastCrew lastCrew, boolean isHoliday) {
        String dayOfWeek = dayOfWeekRepository.getDayOfWeek();
        if (crewRepository.checkDuplicateNextWeekendCrew(lastCrew.getLastCrew())) {
            crewRepository.changeWeekendOrder();
        }
        String crew = crewRepository.getWeekendCrew();
        resultRepository.addOnCall(new OnCall(day, dayOfWeek, crew, isHoliday));
    }

    public void makeWeekdayOnCall(int day, LastCrew lastCrew) {
        String dayOfWeek = dayOfWeekRepository.getDayOfWeek();
        if (crewRepository.checkDuplicateNextWeekdayCrew(lastCrew.getLastCrew())) {
            crewRepository.changeWeekdayOrder();
        }
        String crew = crewRepository.getWeekdayCrew();
        resultRepository.addOnCall(new OnCall(day, dayOfWeek, crew, false));
    }
}
