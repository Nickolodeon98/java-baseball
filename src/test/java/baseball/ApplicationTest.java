package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    Application application;
    List<Integer> testPlayer;
    @BeforeEach
    void setUp() {
        List<Integer> testComputer = new ArrayList<>();
        testComputer.add(7);
        testComputer.add(2);
        testComputer.add(9);
        application = new Application(testComputer);

        testPlayer = new ArrayList<>();
        testPlayer.add(4);
        testPlayer.add(2);
        testPlayer.add(7);
    }

    @DisplayName("무작위 세 수를 만드는지")
    @Test
    void randomNumberCreation() {
        List<Integer> rndNumbers = application.createRndNumbers();
        Assertions.assertEquals(3, rndNumbers.size());
        Assertions.assertNotSame(rndNumbers.get(0), rndNumbers.get(1));
        Assertions.assertNotSame(rndNumbers.get(1), rndNumbers.get(2));
        Assertions.assertNotSame(rndNumbers.get(0), rndNumbers.get(2));
    }

    @DisplayName("볼 카운트를 정상적으로 하는지")
    @Test
    void ballCountJudgement() {
        int hintInt1 = application.isStrikeOrBallOrNothing(7, 0);
        int hintInt2 = application.isStrikeOrBallOrNothing(9, 1);
        int hintInt3 = application.isStrikeOrBallOrNothing(3, 1);

        Assertions.assertEquals(1, hintInt1);
        Assertions.assertEquals(2, hintInt2);
        Assertions.assertEquals(0, hintInt3);
    }

    @DisplayName("볼 카운트를 저장하는 맵에 잘 매핑해 들어가는지")
    @Test
    void recordBallCounts() {
        Map<String, Integer> ballCountMap = application.distinguish(testPlayer);

        Assertions.assertEquals(1, ballCountMap.get("스트라이크"));
        Assertions.assertEquals(1, ballCountMap.get("볼"));
        Assertions.assertEquals(1, ballCountMap.get("낫싱"));
    }

    @DisplayName("볼 카운트 정보가 올바르게 출력되는지")
    @Test
    void printCorrectly() {
        String result = application.printToConsole(application.distinguish(testPlayer));
        Assertions.assertEquals("1볼 1스트라이크", result);
    }
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
