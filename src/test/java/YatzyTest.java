
import model.Roll;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import service.Yatzy;


import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @ParameterizedTest
    @CsvSource({
        "2, 3, 4, 5, 1, 15",
        "3, 3, 4, 5, 1, 16"
    })
     void chance_scores_sum_of_all_dice(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.chance(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }


    @ParameterizedTest
    @CsvSource({
        "4, 4, 4, 4, 4, 50",
        "6, 6, 6, 6, 6, 50",
        "6, 6, 6, 6, 3, 0"
    })
    void yatzy_scores_50(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.yatzy(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, 4, 5, 1",
        "1, 2, 1, 4, 5, 2",
        "6, 2, 2, 4, 5, 0",
        "1, 2, 1, 1, 1, 4"
    })
    void test_1s(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.ones(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, 2, 6, 4",
        "2, 2, 2, 2, 2, 10",
        "6, 2, 2, 4, 5, 4",
        "1, 2, 1, 1, 1, 2"
    })
    void test_2s(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.twos(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, 2, 3, 6",
        "2, 3, 3, 3, 3, 12"
    })
    void test_threes(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.threes(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }


    @ParameterizedTest
    @CsvSource({
        "4, 4, 4, 5, 5, 12",
        "4, 4, 5, 5, 5, 8",
        "4, 5, 5, 5, 5, 4"
    })
    void fours_test(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(d1, d2, d3, d4, d5).fours());
    }



    @ParameterizedTest
    @CsvSource({
        "4, 4, 4, 5, 5, 10",
        "4, 4, 5, 5, 5, 15",
        "4, 5, 5, 5, 5, 20"
    })
    void fives(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(d1, d2, d3, d4, d5).fives());
    }


    @ParameterizedTest
    @CsvSource({
        "4, 4, 4, 5, 5, 0",
        "4, 4, 6, 5, 5, 6",
        "6, 5, 6, 6, 5, 18"
    })
    void sixes_test(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, new Yatzy(d1, d2, d3, d4, d5).sixes());
    }

    @ParameterizedTest
    @CsvSource({
        "3, 4, 3, 5, 6, 6",
        "5, 3, 3, 3, 5, 10",
        "5, 3, 6, 6, 5, 12"
    })
    void one_pair(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.scorePair(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "3, 3, 5, 4, 5, 16",
        "3, 3, 5, 5, 5, 16"
    })
    void two_Pair(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.twoPair(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "3, 3, 3, 4, 5, 9",
        "5, 3, 5, 4, 5, 15",
        "3, 3, 3, 3, 5, 9"
    })
    void three_of_a_kind(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.threeOfAKind(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, 4, 5, 0",
        "3, 3, 3, 3, 5, 12",
        "5, 5, 5, 4, 5, 20",
        "3, 3, 3, 3, 3, 12"
    })
    void four_of_a_knd(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.fourOfAKind(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, 4, 5, 15",
        "2, 3, 4, 5, 1, 15",
        "1, 2, 2, 4, 5, 0"
    })
    void smallStraight(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.smallStraight(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "6, 2, 3, 4, 5, 20",
        "2, 3, 4, 5, 6, 20",
        "1, 2, 2, 4, 5, 0"
    })
    void largeStraight(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.largeStraight(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }

    @ParameterizedTest
    @CsvSource({
        "6, 2, 2, 2, 6, 18",
        "2, 3, 4, 5, 6, 0",
        "1, 2, 3, 4, 5, 0",
        "4, 4, 4, 4, 4, 0",
    })
    void fullHouse(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        assertEquals(expectedScore, Yatzy.fullHouse(new Roll(new int[]{d1, d2, d3, d4, d5})));
    }
}
