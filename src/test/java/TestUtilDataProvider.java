import model.RollDices;
import org.junit.jupiter.params.provider.Arguments;
import service.Yatzy;

import java.util.stream.Stream;

public class TestUtilDataProvider {

    private static Stream<Arguments> chanceScoringRule() {
        return Stream.of(
            Arguments.of(2, 3, 4, 5, 1, 15),
            Arguments.of(3, 3, 4, 5, 1, 16)
        );
    }
    private static Stream<Arguments> yatzyScoringRule() {
        return Stream.of(
            Arguments.of(4, 4, 4, 4, 4, 50),
            Arguments.of(6, 6, 6, 6, 6, 50),
            Arguments.of(6, 6, 6, 6, 3, 0)
        );
    }
    private static Stream<Arguments> onesScoringRule() {
        return Stream.of(
            Arguments.of(1, 2, 3, 4, 5, 1),
            Arguments.of(1, 2, 1, 4, 5, 2),
            Arguments.of(6, 2, 2, 4, 5, 0),
            Arguments.of(1, 2, 1, 1, 1, 4)
        );
    }
    private static Stream<Arguments> twosScoringRule() {
        return Stream.of(
            Arguments.of(1, 2, 3, 2, 6, 4),
            Arguments.of(2, 2, 2, 2, 2, 10),
            Arguments.of(6, 2, 2, 4, 5, 4),
            Arguments.of(1, 2, 1, 1, 1, 2)
        );
    }
    private static Stream<Arguments> threesScoringRule() {
        return Stream.of(
            Arguments.of(1, 2, 3, 2, 3, 6),
            Arguments.of(2, 3, 3, 3, 3, 12)
        );
    }
    private static Stream<Arguments> foursScoringRule() {
        return Stream.of(
            Arguments.of(4, 4, 4, 5, 5, 12),
            Arguments.of(4, 4, 5, 5, 5, 8),
            Arguments.of(4, 5, 5, 5, 5, 4)
        );
    }
    private static Stream<Arguments> fivesScoringRule() {
        return Stream.of(
            Arguments.of(4, 4, 4, 5, 5, 10),
            Arguments.of(4, 4, 5, 5, 5, 15),
            Arguments.of(4, 5, 5, 5, 5, 20)
        );
    }
    private static Stream<Arguments> sixesScoringRule() {
        return Stream.of(
            Arguments.of(4, 4, 4, 5, 5, 0),
            Arguments.of(4, 4, 6, 5, 5, 6),
            Arguments.of(6, 5, 6, 6, 5, 18)
        );
    }

}
