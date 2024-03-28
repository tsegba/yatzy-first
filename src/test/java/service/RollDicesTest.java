package service;

import enums.CategoryEnum;
import error.InvalidRollDiceException;
import error.InvalidYatzyCategoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollDicesTest {
    RollDices rollDices=new RollDices(new int[]{1,2,3,4,5});
    @BeforeEach

    @Test
    void getScoreFailWhenPassNullCategory() {
        InvalidYatzyCategoryException exception = assertThrows(InvalidYatzyCategoryException.class, () ->
            rollDices.getScore(null));
        assertEquals("Invalid category chosen",exception.getMessage());
    }

    @Test
    void getScoreFailWhenUnExistingCategory() {
        CategoryEnum fake =CategoryEnum.valueOf("FAKE");
        InvalidYatzyCategoryException exception = assertThrows(InvalidYatzyCategoryException.class, () ->
            rollDices.getScore(fake));
        assertEquals("Invalid category chosen",exception.getMessage());
    }
    @Test
    void initRollDiceFailWhenPassInvalidDiceFaceNumber() {
        InvalidRollDiceException exception = assertThrows(InvalidRollDiceException.class, () ->
                rollDices=new RollDices(new int[]{1,2,3,4,5,2})
            );
        assertEquals("Invalid roll size: require 5 dice face",exception.getMessage());
    }
}