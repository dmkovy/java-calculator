import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operations = {"*", "/", "+", "-"};
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = scan.nextLine();
//        System.out.println(expression);
        String[] data = expression.split("");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[2]);
        String sign = data[1];

        int index=-1;
        for (int i = 0; i < operations.length; i++) {
            if(expression.contains(operations[i])){
                index = i;
                break;
            }
        }


        int result;

        switch (operations[index]) {
            case "*":
                result = a*b;
                break;
            case "/":
                result = a/b;
                break;
            case "+":
                result = a+b;
                break;
            default:
                result = a-b;
                break;
        }


        System.out.println(result);

    }
}
