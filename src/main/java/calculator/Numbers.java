package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> list;

    public Numbers(StringArray strings) {
        String[] stringArray = strings.getStrings();
        list = new ArrayList<Integer>();

        for (String element : stringArray) {
            int newInt = Integer.parseInt(element);
            list.add(newInt);
        }
    }

    public int getSum() {
        int sum = 0;
        for (int element : list) {
            sum += element;
        }
        return sum;
    }
}
