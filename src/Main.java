import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operations = {"*", "/", "+", "-"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scan.nextLine();

        boolean isRoman =true;
        boolean isRoman1 = true;
        boolean isRoman2 = true;
        int a, b;
        String romanResult = "Римское число";

        String[] data = expression.split("");

        // Проверяем какие числа введены: римские или арабские
        for (int i = 0; i< numbers.length; i++) {
            if(data[0].contains(numbers[i])) {
                isRoman1 = false;
            }
            if (data[2].contains(numbers[i])) {
                isRoman2 = false;
            }
        }

        // Если в одном выражении присутствуют числа разных форматов, то выводим ошибку
        if (isRoman1 != isRoman2) {
            System.out.println("Ошибка. Числа должны быть одного формата!");
            return;
        }

        if (!isRoman1 & !isRoman2) {
            isRoman = false;
        }

        // Если числа римские, то используем Enum -> конвертируем в арабские
        if (isRoman) {
            RomanConverter romanCharA = RomanConverter.valueOf(data[0]);
            RomanConverter romanCharB = RomanConverter.valueOf(data[2]);
            a = romanCharA.getConvert();
            b = romanCharB.getConvert();
        } else { // Если числа арабские -> конвертируем из строки в число
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[2]);
        }

        // Определяем арифметическое действие
        int index=-1;
        for (int i = 0; i < operations.length; i++) {
            if(expression.contains(operations[i])){
                index = i;
                break;
            }
        }

        // Если в выражении нет знаков арифметического действия {"*", "/", "+", "-"}, выдаем ошибку
        if (index == -1) {
            System.out.println("Некорректное выражение!");
            return;
        }


        int arabianResult;

        // Выполняем арифметическое действие
        switch (operations[index]) {
            case "*":
                arabianResult = a*b;
                if (isRoman){
                    IntToRoman intToRoman1 = IntToRoman.valueOf("R"+arabianResult);
                    romanResult = intToRoman1.getString();
                }
                break;
            case "/":
                arabianResult = a/b;
                if (isRoman){
                    IntToRoman intToRoman2 = IntToRoman.valueOf("R"+arabianResult);
                    romanResult = intToRoman2.getString();
                }
                break;
            case "+":
                arabianResult = a+b;
                if (isRoman){
                    IntToRoman intToRoman3 = IntToRoman.valueOf("R"+arabianResult);
                    romanResult = intToRoman3.getString();
                }
                break;
            default:
                arabianResult = a-b;
                if (isRoman){
                    IntToRoman intToRoman4 = IntToRoman.valueOf("R"+arabianResult);
                    romanResult = intToRoman4.getString();
                }
                break;
        }

        // Выводим результат в римском или арабском формате, в зависимости от исходных данных
        if (isRoman)  {
            System.out.println(romanResult);
        } else {
            System.out.println(arabianResult);
        }

    }
}
