package service;

import error.InvalidRollDiceException;
import model.Roll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollDicesTest {

    @Test
    void initRollDiceFailWhenPassMoreDiceFaceNumber() {
        InvalidRollDiceException exception = assertThrows(InvalidRollDiceException.class, () ->
                new Roll(new int[]{1,2,3,4,5,2})
            );
        assertEquals("Invalid roll size: require 5 dice face",exception.getMessage());
    }
    @Test
    void initRollDiceFailWhenPassFewDiceFaceNumber() {
        InvalidRollDiceException exception = assertThrows(InvalidRollDiceException.class, () ->
                new Roll(new int[]{1,2,3,4})
            );
        assertEquals("Invalid roll size: require 5 dice face",exception.getMessage());
    }
}