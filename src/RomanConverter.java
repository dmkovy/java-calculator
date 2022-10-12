public enum RomanConverter {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
    private int convert;
    RomanConverter(int convert) {
        this.convert = convert;
    }

    public int getConvert() {
        return convert;
    }
}
