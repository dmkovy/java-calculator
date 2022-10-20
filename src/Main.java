import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Считываем данные из консоли, формат ввода данных: 3 + 5
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scan.nextLine();
        // Выводим результат в консоль
        System.out.println(calc(expression));
    }


    public static String calc(String input) {
        String[] operations = {"*", "/", "+", "-"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        // Определяем арифметическое действие
        int index = -1;
        for (int i = 0; i < operations.length; i++) {
            if (input.contains(operations[i])) {
                index = i;
                break;
            }
        }

        // Добавляем в массив оба операнда и оператор
        String[] data = input.split(" ");

        // Если в выражении нет знаков арифметического действия {"*", "/", "+", "-"}, выдаем ошибку
        if (index == -1 || data.length < 3) {
            return ("Некорректное выражение! т.к. строка не является математической операцией");
        }

        /* Если в массиве data больше 3 элементов, то выводим ошибку, т.к. формат математической операции
           не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)
        */
        if (data.length > 3) {
            return ("Некорректное выражение! Поддерживаемый формат математической операции - два операнда и один оператор (+, -, /, *)");
        }

        int a, b;
        boolean isRoman = true; // оба числа римские
        boolean isRoman1 = true; // первый операнд в римском формате
        boolean isRoman2 = true; // второй операнд в римском формате

        // Проверяем какие числа введены: римские или арабские
        for (String number : numbers) {
            if (data[0].contains(number)) {
                isRoman1 = false;
            }
            if (data[2].contains(number)) {
                isRoman2 = false;
            }
        }

        if (!isRoman1 && !isRoman2) {
            isRoman = false;
        }

        // Если в одном выражении присутствуют числа разных форматов, то выводим ошибку
        if (isRoman1 != isRoman2) {
            return ("Ошибка. Числа должны быть одного формата!");
        }

        // Если числа римские, то используем Enum -> конвертируем в арабские
        if (isRoman) {
            try {
                RomanConverter romanCharA = RomanConverter.valueOf(data[0]);
                RomanConverter romanCharB = RomanConverter.valueOf(data[2]);
            } catch (IllegalArgumentException e) {
                return ("Некорректное выражение! Нераспознанные символы/ Диапазон поддерживаемых чисел от 1 до 10 включительно");
            }
            RomanConverter romanCharA = RomanConverter.valueOf(data[0]);
            RomanConverter romanCharB = RomanConverter.valueOf(data[2]);
            a = romanCharA.getConvert();
            b = romanCharB.getConvert();

        } else { // Если числа арабские -> конвертируем из строки в число
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[2]);
        }

        // Если введены числа вне диапазона от 1 до 10, то выдаем ошибку
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            return ("Некорректное выражение! Диапазон поддерживаемых чисел от 1 до 10 включительно");
        }

        int result;
        // Выполняем арифметическое действие
        switch (operations[index]) {
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "+":
                result = a + b;
                break;
            default:
                result = a - b;
                break;
        }


        String resultStr;

        // Выводим результат в римском или арабском формате, в зависимости от исходных данных
        if (isRoman) {
            if (result < 1) {
                return ("Некорректное выражение! В римской системе нет отрицательных чисел");
            }
            resultStr = IntToRoman.intToRoman(result);

        } else {
            resultStr = Integer.toString(result);

        }

        return resultStr;
    }
}
