package service;

import enums.CategoryEnum;
import enums.FaceEnum;
import error.InvalidRollDiceException;
import error.InvalidYatzyCategoryException;
import model.Dice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class RollDices {
    private final List<Dice> dices;
    private static final  int YATZY_FULL = 50;
    private static final  int YATZY_SMALL = 15;
    private static final  int YATZY_LARGE = 20;
    private static final  int YATZY_BLANK = 0;
    public RollDices(final int[] dices) {
        if(dices == null || dices.length != 5){
            throw new InvalidRollDiceException("Invalid roll size: require 5 dice face");
        }
        this.dices = Arrays.stream(dices).mapToObj(Dice::new).collect(Collectors.toList());
    }
    public int getScore(final CategoryEnum category){
        if(category == null ) {
            throw new InvalidYatzyCategoryException("Invalid category chosen");
        }
        switch (category) {
            case CHANCE:
                return sum();
            case YATZY:
                return yatzy();
            case ONES:
                return sumOfFace(FaceEnum.ONE.getFaceValue());
            case TWOS:
                return sumOfFace(FaceEnum.TWO.getFaceValue());
            case THREES:
                return sumOfFace(FaceEnum.THREE.getFaceValue());
            case FOURS:
                return sumOfFace(FaceEnum.FOUR.getFaceValue());
            case FIVES:
                return sumOfFace(FaceEnum.FIVE.getFaceValue());
            case SIXES:
                return sumOfFace(FaceEnum.SIX.getFaceValue());
            case PAIR:
                return getPair();
            case TWO_PAIRS:
                return sumOccurenceGreaterThan(FaceEnum.TWO.getFaceValue());
            case THREE_OF_A_KIND:
                return sumOccurenceGreaterThan(FaceEnum.THREE.getFaceValue());
            case FOUR_OF_A_KIND:
                return sumOccurenceGreaterThan(FaceEnum.FOUR.getFaceValue());
            case SMALL_STRAIGHT:
                return getSmallStraight();
            case LARGE_STRAIGHT:
                return getLargeStraight();
            case FULL_HOUSE:
                return getFullHouse();
            default:
                throw new InvalidYatzyCategoryException("Invalid category chosen");
        }
    }
    private int sum() {
        return this.dices.stream().map(Dice::getFace).mapToInt(Integer::intValue).sum();
    }
    private int yatzy() {
        boolean isYatzy = this.dices.stream().map(Dice::getFace).distinct().count() == 1;
        return  isYatzy ? YATZY_FULL : YATZY_BLANK;
    }

    private int sumOfFace(int face){
        return this.dices.stream().map(Dice::getFace).filter(v -> v == face).reduce(0, Integer::sum);
    }

    private int getPair(){
        final OptionalInt max = this.mapDiceOccurence().entrySet().stream().filter(val -> val.getValue() == 2).mapToInt(Map.Entry::getKey).max();
        return max.isPresent() ? max.getAsInt() * 2 : YATZY_BLANK;
    }
    private int sumOccurenceGreaterThan(int face) {
        return this.mapDiceOccurence().entrySet().stream().filter(val -> val.getValue() >= face)
            .mapToInt(val -> val.getKey() * face).sum();
    }
    private Map<Integer, Long> mapDiceOccurence() {
        return this.dices.stream().map(Dice::getFace).collect(groupingBy(val -> val, counting()));
    }

    private int getSmallStraight() {
        boolean isSmall = sortedDicesFace().equals(asList(1,2,3,4,5));
        return isSmall ? YATZY_SMALL : YATZY_BLANK;
    }
    private int getLargeStraight() {
        boolean isLarge = sortedDicesFace().equals(asList(2, 3, 4, 5, 6));
        return isLarge ? YATZY_LARGE : YATZY_BLANK;
    }
    private List<Integer> sortedDicesFace() {
        return this.dices.stream().map(Dice::getFace).sorted().collect(Collectors.toList());
    }
    private  int getFullHouse() {
        return this.yatzy() ==  YATZY_FULL ? YATZY_BLANK : sumOccurenceGreaterThan(FaceEnum.THREE.getFaceValue()) + getPair();
    }
}
