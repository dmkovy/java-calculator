public enum IntToRoman {
    R1("I"), R2("II"), R3("III"), R4("IV"), R5("V"), R6("VI"), R7("VII"), R8("VIII"), R9("IX"), R10("X"), R11("XI"), R12("XII"), R13("XIII"), R14("XIV"), R15("XV"), R16("XVI"), R17("XVII"), R18("XVIII"), R19("XIX"), R20("XX");

    private String s;

    IntToRoman (String s) {
        this.s = s;
    }

    public String getString() {
        return s;
    }
}
