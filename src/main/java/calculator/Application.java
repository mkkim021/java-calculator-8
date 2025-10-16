package calculator;

import calculator.controller.Controller;
import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Controller controller = new Controller(new InputView(), new OutputView(), new Calculator());
        controller.run();


    }
}
