package oncall;

import oncall.controller.OnCallController;

import java.time.Month;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OnCallController onCallController = appConfig.onCallController();

        onCallController.run();
    }
}
