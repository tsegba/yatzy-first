package model;

import error.InvalidRollDiceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Roll {
    private final List<Dice> dices;
    public static final  int YATZY_FULL = 50;
    public static final  int YATZY_SMALL = 15;
    public static final  int YATZY_LARGE = 20;
    public static final  int YATZY_BLANK = 0;

    public Roll(final int[] dices){
        if(dices == null || dices.length != 5){
            throw new InvalidRollDiceException("Invalid roll size: require 5 dice face");
        }
        this.dices = Arrays.stream(dices).mapToObj(Dice::new).collect(Collectors.toList());
    }

    public List<Dice> getDices() {
        return dices;
    }
}
