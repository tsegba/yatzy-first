package service.rules;

import model.Dice;
import model.Roll;

import static java.util.Arrays.asList;

public class LargeRoll extends DiceRoll {

    @Override
    public int getScore(Roll rollDices) {
        boolean isLarge = sortedDicesFace(rollDices).equals(asList(2, 3, 4, 5, 6));
        return isLarge ? Roll.YATZY_LARGE : Roll.YATZY_BLANK;
    }
}
