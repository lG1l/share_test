package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private String delimiter;

    public StringParser() {
        delimiter = ",|:";
    }

    public StringArray parse(InputString input) {
        while (checkCustomDelimiter(input.getInput())) {
            fixDelimiter(input);
        }

        String inputString = input.getInput();
        return new StringArray(inputString.split(delimiter));
    }

    public boolean checkCustomDelimiter(String inputString) {
        int endIndex = inputString.indexOf("\\n");

        if (inputString.startsWith("//") && endIndex != -1) {
            return true;
        }
        return false;
    }

    public void fixDelimiter(InputString input) {
        String inputString = input.getInput();
        int endIndex = inputString.indexOf("\\n");
        String plusDelimiter = inputString.substring(2, endIndex);
        plusDelimiter = "|" + Pattern.quote(plusDelimiter);
        delimiter = delimiter.concat(plusDelimiter);

        int startIndex = endIndex + 2;
        endIndex = inputString.length();
        String fixString = inputString.substring(startIndex, endIndex);
        input.setInput(fixString);
    }
}
