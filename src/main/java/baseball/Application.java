package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private List<Integer> computerSide;
    public Application() {
        this.computerSide = new ArrayList<>();
    }

    private final String[] judgeInfo = {"Nothing", "Strike", "Ball"};

    public void distinguish(List<Integer> playerSide) {
        Map<String, Integer> ballCount = new HashMap<>();
        for (int i = 0; i < playerSide.size(); i++) {
            String ballCountInfo = judgeInfo[isStrikeOrBallOrNothing(playerSide.get(i), i)];
            if (ballCount.containsKey(ballCountInfo)) ballCount.put(ballCountInfo, ballCount.get(ballCountInfo)+1);
            ballCount.putIfAbsent(ballCountInfo, 1);
        }
    }

    private int isStrikeOrBallOrNothing(int elemToBeJudged, int pos) {
        if (computerSide.contains(elemToBeJudged)) {
            if (computerSide.indexOf(elemToBeJudged) == pos) return 1;
            return 2;
        }
        return 0;
    }
    public void createRndNumbers() {
        while(computerSide.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerSide.contains(randomNumber)) computerSide.add(randomNumber);
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
