package oncall.controller;

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
    }

    private void initOnCallMonthAndStartDayOfWeek() {
        inputMonthAndDayOfWeek();
    }

    private List<String> inputMonthAndDayOfWeek() {
        return execute(() -> {
            String input = inputView.inputMonthAndDayOfWeek();
            List<String> monthAndDayOfWeek = InputConverter.convertInputToList(input);
            Validator.validateMonthAndDayOfWeekSize(monthAndDayOfWeek);
            return monthAndDayOfWeek;
        });
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
