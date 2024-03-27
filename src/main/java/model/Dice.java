package model;

public class Dice {
    private int d1;
    private int d2;
    private int d3;
    private int d4;
    private int d5;

    public Dice(int d1, int d2, int d3, int d4, int d5) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
    }

    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }

    public int getD3() {
        return d3;
    }

    public int getD4() {
        return d4;
    }

    public int getD5() {
        return d5;
    }
}
