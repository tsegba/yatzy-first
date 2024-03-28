package service.rules;

import model.Roll;

public class YatzyRoll extends DiceRoll {

    @Override
    public int getScore(Roll rollDices){
        return  isYatzy(rollDices) ? Roll.YATZY_FULL : Roll.YATZY_BLANK;
    }
}
