package calculator;

public class StringArray {
    private String[] strings;

    public StringArray(String[] strings) {
        this.strings = strings;

        try {
            checkValid();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValid() {
        if (this.strings == null) {
            return;
        }

        for (String element : this.strings) {
            int checkValue = Integer.parseInt(element);
            negative(checkValue);
        }
    }

    private void negative(int checkValue) {
        if (checkValue < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String[] getStrings(){
        return strings;
    }
}