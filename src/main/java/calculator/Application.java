package calculator;

import calculator.config.AppConfig;
import calculator.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        AppConfig appConfig = AppConfig.getInstance();
        Controller controller = appConfig.controller();
        controller.run();


    }
}
