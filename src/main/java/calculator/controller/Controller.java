package calculator.controller;


import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;


    public Controller(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        try {
            String input = inputView.getInput();
            int result = calculator.calculate(input);
            outputView.printResult(result);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
