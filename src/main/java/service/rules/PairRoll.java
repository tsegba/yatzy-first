package service.rules;

import enums.FaceEnum;
import model.Roll;

import java.util.Map;
import java.util.OptionalInt;

public class PairRoll extends DiceRoll {

    @Override
    public int getScore(Roll rollDices) {
        final OptionalInt max = mapDiceOccurence(rollDices).entrySet().stream().filter(val -> val.getValue() == FaceEnum.TWO.getFaceValue()).mapToInt(Map.Entry::getKey).max();
        return max.isPresent() ? max.getAsInt() * FaceEnum.TWO.getFaceValue() : Roll.YATZY_BLANK;
    }
}