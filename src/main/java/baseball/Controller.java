package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    Service service = new Service();

    public void startGame() {
        System.out.println("START_MESSAGE = " + START_MESSAGE);
        List<Integer> answerNum = service.setAnswerNum();
        String inputString = getInputString();
        List<Integer> inputNum = changeInputFormat(inputString);

    }

    private String getInputString() throws IllegalArgumentException {
        System.out.print(INPUT_MESSAGE);
        String inputString = Console.readLine();
        return inputString;
    }

    private List<Integer> changeInputFormat(String inputString) {
        List<Integer> inputNum = new ArrayList<>();

        if(inputString.length() != 3)
            throw new IllegalArgumentException();

        inputString.chars().forEach(c -> {
            Integer temp = Character.getNumericValue(c);
            if(temp < 1 || temp > 9)
                throw new IllegalArgumentException();
            if(inputNum.contains(temp)) {
                throw new IllegalArgumentException();
            }
            inputNum.add(temp);
        });
        return inputNum;
    }
}
