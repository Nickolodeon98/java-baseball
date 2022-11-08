package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Integer> computerSide;

    public Application() {
        this.computerSide = new ArrayList<>();
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
