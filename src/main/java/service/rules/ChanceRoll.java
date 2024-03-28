package service.rules;

import model.Dice;
import model.Roll;

public class   ChanceRoll extends DiceRoll {

    @Override
    public int getScore(Roll rollDices) {
        return rollDices.getDices().stream().map(Dice::getFace).mapToInt(Integer::intValue).sum();

    }
}
