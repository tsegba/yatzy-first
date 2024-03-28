package service;


import enums.FaceEnum;
import model.Roll;
import service.rules.ANumberKindOfRoll;
import service.rules.ChanceRoll;
import service.rules.FullRoll;
import service.rules.LargeRoll;
import service.rules.NumerRoll;
import service.rules.PairRoll;
import service.rules.SmallRoll;
import service.rules.YatzyRoll;

public class Yatzy {
    private final Roll rollDices;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        this.rollDices = new Roll(new int[]{d1, d2, d3, d4, d5});
    }

    public static int chance(final Roll rollDices) {
        return new ChanceRoll().getScore(rollDices);
    }

    public static int yatzy(final Roll rollDices) {
        return new YatzyRoll().getScore(rollDices);
    }

    public static int ones(final Roll rollDices) {
        return new NumerRoll(FaceEnum.ONE).getScore(rollDices);
    }

    public static int twos(final Roll rollDices) {
        return new NumerRoll(FaceEnum.TWO).getScore(rollDices);
    }

    public static int threes(final Roll rollDices) {
        return new NumerRoll(FaceEnum.THREE).getScore(rollDices);
    }

    public int fours() {
        return new NumerRoll(FaceEnum.FOUR).getScore(rollDices);
    }

    public int fives() {
        return new NumerRoll(FaceEnum.FIVE).getScore(rollDices);
    }

    public int sixes() {
        return new NumerRoll(FaceEnum.SIX).getScore(rollDices);
    }

    public static int scorePair(final Roll rollDices) {
        return new PairRoll().getScore(rollDices);
    }

    public static int twoPair(final Roll rollDices) {
        return new ANumberKindOfRoll(FaceEnum.TWO).getScore(rollDices);
    }

    public static int threeOfAKind(final Roll rollDices) {
        return new ANumberKindOfRoll(FaceEnum.THREE).getScore(rollDices);
    }

    public static int fourOfAKind(final Roll rollDices) {
        return new ANumberKindOfRoll(FaceEnum.FOUR).getScore(rollDices);
    }


    public static int smallStraight(final Roll rollDices) {
        return new SmallRoll().getScore(rollDices);
    }

    public static int largeStraight(final Roll rollDices) {
        return new LargeRoll().getScore(rollDices);
    }

    public static int fullHouse(final Roll rollDices) {
        return new FullRoll().getScore(rollDices);
    }
}



