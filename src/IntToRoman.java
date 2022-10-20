public class IntToRoman {
    public static String intToRoman(int integer) {
        int[] decimalValue = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValue = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String romanResult = "";
        for (int i = 0; i < decimalValue.length; i++) {
            while (decimalValue[i] <= integer) {
                romanResult += romanValue[i];
                integer = integer - decimalValue[i];
            }
        }
        return romanResult;
    }
}

