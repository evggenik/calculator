public enum RomanNum {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50),
    XC(90), C(100);

    private final int number;

    RomanNum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
