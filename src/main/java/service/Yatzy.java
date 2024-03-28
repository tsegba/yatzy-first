package service;


import enums.CategoryEnum;
import model.RollDices;

public class Yatzy {
    private final RollDices rollDices;
    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        this.rollDices = new RollDices(new int[]{d1, d2, d3, d4, d5});
    }

    public static int chance(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.CHANCE);
    }

    public static int yatzy(final RollDices rollDices)
    {
        return rollDices.getScore(CategoryEnum.YATZY);
    }

    public static int ones(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.ONES);
    }

    public static int twos(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.TWOS);
    }

    public static int threes(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.THREES);
    }

    public int fours() {
        return this.rollDices.getScore(CategoryEnum.FOURS);
    }

    public int fives() {
        return this.rollDices.getScore(CategoryEnum.FIVES);
    }

    public int sixes() {
        return this.rollDices.getScore(CategoryEnum.SIXES);
    }

    public static int score_pair(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.PAIR);
    }

    public static int two_pair(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.TWO_PAIRS);
    }

    public static int three_of_a_kind(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.THREE_OF_A_KIND);
    }

    public static int four_of_a_kind(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.FOUR_OF_A_KIND);
    }


    public static int smallStraight(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.SMALL_STRAIGHT);
    }

    public static int largeStraight(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.LARGE_STRAIGHT);
    }

    public static int fullHouse(final RollDices rollDices) {
        return rollDices.getScore(CategoryEnum.FULL_HOUSE);
    }
}



