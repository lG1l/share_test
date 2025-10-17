package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static String getDelimiter(String input) {
        String returnDelimiter = "|";

        int endIdx = input.indexOf("\\n");

        String newDelimiter = input.substring(2, endIdx);

        returnDelimiter += Pattern.quote(newDelimiter);

        return returnDelimiter;
    }

    public static String[] getAllDelimiter(String input){
        String delimiter = ",|:";

        while(input.startsWith("//") && input.contains("\\n")) {
            delimiter = delimiter.concat(getDelimiter(input));

            int startIdx = input.indexOf("\\n") + 2;
            int endIdx = input.length();
            input = input.substring(startIdx, endIdx);
        }

        return new String[]{input, delimiter};
    }

    public static String[] getSeparateInput(String input, String delimiter){
        return input.split(delimiter);
    }

    public static int getSum(String[] separateInput){
        int sum = 0;

        try{
            for(String str : separateInput){
                int tmp = Integer.parseInt(str);
                if(tmp<0){
                    throw new IllegalArgumentException();
                }
                sum += tmp;
            }
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 구분자와 input 설정
        String[] tmp = getAllDelimiter(input);
        input = tmp[0];
        String delimiter = tmp[1];

        // 입력받은 값을 구분자 단위로 끊음
        String[] separateInput = getSeparateInput(input, delimiter);

        // 문자열 연산 결과
        int sum = getSum(separateInput);

        // 결과 출력
        System.out.print("결과 : " + sum);
    }
}
