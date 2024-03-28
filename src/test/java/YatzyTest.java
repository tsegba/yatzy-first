import service.RollDices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.Yatzy;


import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#chanceScoringRule")
     void chance_scores_sum_of_all_dice(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        int actual = Yatzy.chance(new RollDices(new int[]{d1, d2, d3, d4, d5}));
        assertEquals(expectedScore, actual);
    }


    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#yatzyScoringRule")
    void yatzy_scores_50(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        int actual = Yatzy.yatzy(new RollDices(new int[]{d1, d2, d3, d4, d5}));
        assertEquals(expectedScore, actual);
    }


    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#onesScoringRule")
    void test_1s(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.ones(new RollDices(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#twosScoringRule")
    void test_2s(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.twos(new RollDices(new int[]{d1, d2, d3, d4, d5})));
    }


    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#threesScoringRule")
    void test_threes(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.threes(new RollDices(new int[]{d1, d2, d3, d4, d5})));
    }


    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#foursScoringRule")
    void fours_test(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(d1, d2, d3, d4, d5).fours());
    }


    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#fivesScoringRule")
    void fives(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(d1, d2, d3, d4, d5).fives());
    }


    @ParameterizedTest
    @MethodSource("TestUtilDataProvider#sixesScoringRule")
    void sixes_test(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(d1, d2, d3, d4, d5).sixes());
    }

    @Test
    void one_pair() {
        assertEquals(6, Yatzy.scorePair(new RollDices(new int[]{3, 4, 3, 5, 6})));
        assertEquals(10, Yatzy.scorePair(new RollDices(new int[]{5, 3, 3, 3, 5})));
        assertEquals(12, Yatzy.scorePair(new RollDices(new int[]{5, 3, 6, 6, 5})));
    }

    @Test
    void two_Pair() {
        assertEquals(16, Yatzy.twoPair(new RollDices(new int[]{3, 3, 5, 4, 5})));
        assertEquals(16, Yatzy.twoPair(new RollDices(new int[]{3, 3, 5, 5, 5})));
    }

    @Test
    void three_of_a_kind() {
        assertEquals(9, Yatzy.threeOfAKind(new RollDices(new int[]{3, 3, 3, 4, 5})));
        assertEquals(15, Yatzy.threeOfAKind(new RollDices(new int[]{5, 3, 5, 4, 5})));
        assertEquals(9, Yatzy.threeOfAKind(new RollDices(new int[]{3, 3, 3, 3, 5})));
    }

    @Test
    void four_of_a_knd() {
        assertEquals(12, Yatzy.fourOfAKind(new RollDices(new int[]{3, 3, 3, 3, 5})));
        assertEquals(20, Yatzy.fourOfAKind(new RollDices(new int[]{5, 5, 5, 4, 5})));
        assertEquals(9, Yatzy.threeOfAKind(new RollDices(new int[]{3, 3, 3, 3, 3})));
    }

    @Test
    void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(new RollDices(new int[]{1, 2, 3, 4, 5})));
        assertEquals(15, Yatzy.smallStraight(new RollDices(new int[]{2, 3, 4, 5, 1})));
        assertEquals(0, Yatzy.smallStraight(new RollDices(new int[]{1, 2, 2, 4, 5})));
    }

    @Test
    void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(new RollDices(new int[]{6, 2, 3, 4, 5})));
        assertEquals(20, Yatzy.largeStraight(new RollDices(new int[]{2, 3, 4, 5, 6})));
        assertEquals(0, Yatzy.largeStraight(new RollDices(new int[]{1, 2, 2, 4, 5})));
    }

    @Test
    void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(new RollDices(new int[]{6, 2, 2, 2, 6})));
        assertEquals(0, Yatzy.fullHouse(new RollDices(new int[]{2, 3, 4, 5, 6})));
    }
}
