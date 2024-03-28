package service.rules;

import enums.FaceEnum;
import model.Dice;
import model.Roll;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public abstract class DiceRoll {

    public abstract int getScore(final Roll rollDices);

    protected Map<Integer, Long> mapDiceOccurence(final Roll rollDices) {
        return rollDices.getDices().stream().map(Dice::getFace).collect(groupingBy(val -> val, counting()));
    }

    protected List<Integer> sortedDicesFace(final Roll rollDices) {
        return rollDices.getDices().stream().map(Dice::getFace).sorted().collect(Collectors.toList());
    }
    protected int sumOccurenceGreaterThan(Roll rollDices, FaceEnum face) {
        return mapDiceOccurence(rollDices).entrySet().stream().filter(val -> val.getValue() >= face.getFaceValue())
            .mapToInt(val -> val.getKey() * face.getFaceValue()).sum();
    }

    protected boolean isYatzy(Roll rollDices){
        return rollDices.getDices().stream().map(Dice::getFace).distinct().count() == 1;
    }
}
