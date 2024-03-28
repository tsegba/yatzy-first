package model;

import error.InvalidDiceFaceException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiceTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void initDiceValidWhenFaceValid(int face) {
         assertDoesNotThrow( () -> {  new Dice(face);});
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 7, 21, 10})
    void initDiceFailWhenPassInvalidFaceValue(int face) {
        InvalidDiceFaceException exception = assertThrows(InvalidDiceFaceException.class, () -> {
            new Dice(face);
        });
        assertEquals("Dice face value must be in [1,6]", exception.getMessage());
    }

}