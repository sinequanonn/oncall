package oncall.controller;

import oncall.domain.Month;
import oncall.dto.LastCrew;
import oncall.service.OnCallService;
import oncall.utils.InputConverter;
import oncall.utils.Validator;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class OnCallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OnCallService onCallService;

    public OnCallController(InputView inputView, OutputView outputView, OnCallService onCallService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.onCallService = onCallService;
    }

    public void run() {
        initOnCallMonthAndStartDayOfWeek();
        initOnCallWeekdayCrews();
        initOnCallWeekendCrews();

        executeOnCallProcess();
    }

    private void executeOnCallProcess() {
        Month month = onCallService.findMonth();
        LastCrew lastCrew = LastCrew.init();
        for (int day = 1; day <= month.getLastDay(); day++) {
            makeTodayOnCall(month, day, lastCrew);
        }
    }

    private void makeTodayOnCall(Month month, int day, LastCrew lastCrew) {
        boolean isHoliday = onCallService.checkTodayIsHoliday(month, day);
        boolean isWeekday = onCallService.checkTodayIsWeekday();
        // 평일이면서 법정 공휴일인 경우
        if (isWeekday && !isHoliday) {
            onCallService.makeWeekdayOnCall(day, lastCrew);
            return;
        }
        onCallService.makeWeekendOnCall(day, lastCrew, isHoliday);
    }

    private void initOnCallWeekendCrews() {
        while (true) {
            try {
                String input = inputView.inputWeekendCrews();
                List<String> crews = InputConverter.convertInputToList(input);
                onCallService.saveWeekendCrews(crews);
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    private void initOnCallWeekdayCrews() {
        while (true) {
            try {
                String input = inputView.inputWeekdayCrews();
                List<String> crews = InputConverter.convertInputToList(input);
                Validator.validateCrewSize(crews);
                Validator.validateCrewNameSize(crews);
                onCallService.saveWeekdayCrews(crews);
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    private void initOnCallMonthAndStartDayOfWeek() {
        while (true) {
            try {
                String input = inputView.inputMonthAndDayOfWeek();
                List<String> monthAndDayOfWeek = InputConverter.convertInputToList(input);
                Validator.validateMonthAndDayOfWeekSize(monthAndDayOfWeek);
                onCallService.saveMonth(InputConverter.convertStrToInt(monthAndDayOfWeek.get(0)));
                onCallService.saveDayOfWeek(monthAndDayOfWeek.get(1));
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }


    private <T> T execute(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }
}
