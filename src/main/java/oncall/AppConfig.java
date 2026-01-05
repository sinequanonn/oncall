package oncall;

import oncall.controller.OnCallController;
import oncall.repository.CrewRepository;
import oncall.repository.DayOfWeekRepository;
import oncall.repository.ResultRepository;
import oncall.service.OnCallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {
    private InputView inputView;
    private OutputView outputView;
    private OnCallService onCallService;
    private OnCallController onCallController;

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private OnCallService onCallService() {
        if (onCallService == null) {
            onCallService = new OnCallService(
                    new CrewRepository(),
                    new ResultRepository(),
                    new DayOfWeekRepository()
            );
        }
        return onCallService;
    }

    public OnCallController onCallController() {
        if (onCallController == null) {
            onCallController = new OnCallController(inputView(), outputView(), onCallService());
        }
        return onCallController;
    }
}
