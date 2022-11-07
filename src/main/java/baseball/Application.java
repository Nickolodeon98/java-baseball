package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public List<Integer> createRndNumbers() {
        List<Integer> computerSide = new ArrayList<>();

        while(computerSide.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerSide.contains(randomNumber)) computerSide.add(randomNumber);
        }

        return computerSide;
    }
}
