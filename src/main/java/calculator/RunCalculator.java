package calculator;

public class RunCalculator {
    public void run() {
        InputOutputConsole inputOutput = new InputOutputConsole();

        InputString input = inputOutput.readInput();

        StringParser parser = new StringParser();
        StringArray strings = parser.parse(input);

        Numbers numbers = new Numbers(strings);
        int result = numbers.getSum();

        inputOutput.printResult(result);
    }
}
