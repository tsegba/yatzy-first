package service.rules;

import enums.FaceEnum;
import model.Roll;

public class FullRoll extends PairRoll {

    @Override
    public int getScore(Roll rollDices) {
        if (isYatzy(rollDices)){
            return Roll.YATZY_BLANK;
        }
       return sumOccurenceGreaterThan(rollDices,FaceEnum.THREE) + super.getScore(rollDices);
    }
}
