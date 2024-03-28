package service.rules;

import enums.FaceEnum;
import model.Dice;
import model.Roll;

public class NumerRoll extends DiceRoll{
    private final FaceEnum face;
    public NumerRoll(final FaceEnum face){
        this.face = face;
    }
    @Override
    public int getScore(Roll rollDices) {
        return sumOfFace(rollDices);
    }
    private int sumOfFace(Roll rollDices){
        return rollDices.getDices().stream().map(Dice::getFace).filter(v -> v == face.getFaceValue()).reduce(0, Integer::sum);
    }
}
