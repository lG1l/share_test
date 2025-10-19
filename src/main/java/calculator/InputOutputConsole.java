package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputOutputConsole {
    public InputString readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        return new InputString(inputString);
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
