package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private List<Integer> computerSide;
    private final String[] judgeInfo = {"낫싱", "스트라이크", "볼"};

    public Application() {
        this.computerSide = new ArrayList<>();
    }

    public Application(List<Integer> computerSide) {
        this.computerSide = computerSide;
    }

    public Map<String, Integer> distinguish(List<Integer> playerSide) {
        Map<String, Integer> ballCount = new HashMap<>();
        for (int i = 0; i < playerSide.size(); i++) {
            String ballCountInfo = judgeInfo[isStrikeOrBallOrNothing(playerSide.get(i), i)];
            if (ballCount.containsKey(ballCountInfo)) ballCount.put(ballCountInfo, ballCount.get(ballCountInfo) + 1);
            ballCount.putIfAbsent(ballCountInfo, 1);
        }
        return ballCount;
    }

    public String printToConsole(Map<String, Integer> ballCount) {
        String hint = "";
        if (!ballCount.containsKey("스트라이크") && !ballCount.containsKey("볼")) return "낫싱";

        for (Map.Entry<String, Integer> countHint : ballCount.entrySet()) {
            if (!countHint.getKey().equals("낫싱")) {
                if (!hint.equals("")) hint = String.join("", " ", hint);
                hint = String.join("", String.format("%d%s", countHint.getValue(), countHint.getKey()), hint);
            }
        }

        return hint;
    }

    public int isStrikeOrBallOrNothing(int elemToBeJudged, int pos) {
        if (computerSide.contains(elemToBeJudged)) {
            if (computerSide.indexOf(elemToBeJudged) == pos) return 1;
            return 2;
        }
        return 0;
    }

    public List<Integer> createRndNumbers() {
        while (computerSide.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerSide.contains(randomNumber)) computerSide.add(randomNumber);
        }
        return computerSide;
    }

    public void commandLineInterface() {
        boolean restart = true;

        while (true) {
            if (restart) {
                computerSide.clear();
                System.out.println("숫자 야구 게임을 시작합니다.");
                createRndNumbers();
                restart = false;
            }
            System.out.print("숫자를 입력해주세요: ");
            String inputNum = Console.readLine();

            List<Integer> playerNum = new ArrayList<>();
            playerNum.add(inputNum.charAt(0) - '0');
            playerNum.add(inputNum.charAt(1) - '0');
            playerNum.add(inputNum.charAt(2) - '0');

            Map<String, Integer> ballCount = distinguish(playerNum);
            String hint = printToConsole(ballCount);
            System.out.println(hint);
            if (hint.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String option = Console.readLine();
                if (option.equals("2")) break;
                else if (option.equals("1")) restart = true;
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        List<Integer> testList = new ArrayList<>();
//        testList.add(5);
//        testList.add(8);
//        testList.add(9);
        Application application = new Application();
        application.commandLineInterface();
    }
}
