package service.rules;

import enums.FaceEnum;
import model.Roll;

public class ANumberKindOfRoll extends DiceRoll{
    private final FaceEnum face;

    public ANumberKindOfRoll(final FaceEnum face) {
        this.face = face;
    }
    @Override
    public int getScore(Roll rollDices) {
        return sumOccurenceGreaterThan(rollDices,face);
    }

}