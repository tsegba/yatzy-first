package enums;

public enum FaceEnum {
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

    private int face;

    FaceEnum(int category) {
        this.face = category;
    }

    public int getFaceValue() {
        return face;
    }
}
