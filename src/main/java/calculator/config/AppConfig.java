package calculator.config;

import calculator.controller.Controller;
import calculator.model.Calculator;
import calculator.model.InputParser;
import calculator.model.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    private static AppConfig instance;

    private Validator validator;
    private InputParser inputParser;
    private Calculator calculator;
    private InputView inputView;
    private OutputView outputView;
    private Controller controller;

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public Validator validator() {
        if (validator == null) {
            validator = new Validator();
        }
        return validator;
    }

    public InputParser inputParser() {
        if (inputParser == null) {
            inputParser = new InputParser(validator());
        }
        return inputParser;
    }

    public Calculator calculator() {
        if (calculator == null) {
            calculator = new Calculator(inputParser());
        }
        return calculator;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public Controller controller() {
        if (controller == null) {
            controller = new Controller(
                    inputView(),
                    outputView(),
                    calculator()
            );
        }
        return controller;
    }
}
