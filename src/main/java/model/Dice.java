package model;

import error.InvalidDiceFaceException;

public class Dice {
    private final int face;

    public Dice(int face) {
        if(face<1 || face>6){
            throw new InvalidDiceFaceException("Dice face value must be in [1,6]");
        }
        this.face = face;
    }

    public int getFace() {
        return face;
    }
}
