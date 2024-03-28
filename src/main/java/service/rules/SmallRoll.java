package service.rules;

import model.Roll;

import static java.util.Arrays.asList;

public class SmallRoll extends DiceRoll {

    @Override
    public int getScore(Roll rollDices) {
        boolean isSmall = sortedDicesFace(rollDices).equals(asList(1,2,3,4,5));
        return isSmall ? Roll.YATZY_SMALL : Roll.YATZY_BLANK;
    }
}
