import java.util.*;


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вычисления от 1 до 10 ЧЕРЕЗ ПРОБЕЛ!");
        List<String> arab = new ArrayList<>();
        Collections.addAll(arab,"1","2","3","4","5","6","7","8","9","10");
        List<String> roman = new ArrayList<>();
        Collections.addAll(roman,"I","II","III","IV","V","VI","VII","VIII","IX","X");

        String AAA = scanner.nextLine();
        String[] str = AAA.split(" ");
        String first = str[0];
        String operation = str[1];
        String second = str[2];

        if (arab.contains(first) && arab.contains(second)) {
           if (operation.equals("+")) {
               long res = new Addition().additionResult(Integer.parseInt(first), Integer.parseInt(second));
               System.out.println("Резултат сложения :" + res);
           } else if (operation.equals("-")) {
               long res = new Subtraction().subtractionResult(Integer.parseInt(first), Integer.parseInt(second));
               System.out.println("Резултат вычитания :" + res);
           } else if (operation.equals("*")) {
               long res = new Multiplication().multiplicationResult(Integer.parseInt(first), Integer.parseInt(second));
               System.out.println("Резултат умножения :" + res);
           } else if (operation.equals("/")) {
               long res = new Division().divisionResult(Integer.parseInt(first), Integer.parseInt(second));
               System.out.println("Резултат деления :" + res);
           }
       }else if (roman.contains(first) && roman.contains(second)){
            if (operation.equals("+")) {
                int res = new Addition().additionResult(roman.indexOf(first) + 1, roman.indexOf(second) + 1);
                System.out.println("Резултат сложения :" + resultRoman(res));
            }else if (operation.equals("-")) {
                int res = new Subtraction().subtractionResult(roman.indexOf(first) + 1, roman.indexOf(second) + 1);
                System.out.println("Резултат вычитания :" + resultRoman(res));
            }else if (operation.equals("*")) {
                int res = new Multiplication().multiplicationResult(roman.indexOf(first) + 1, roman.indexOf(second) + 1);
                System.out.println("Резултат умножения :" + resultRoman(res));
            } else if (operation.equals("/")) {
                int res = new Division().divisionResult(roman.indexOf(first) + 1, roman.indexOf(second) + 1);
                System.out.println("Резултат деления :" + resultRoman(res));
            }
        }else {
            throw new ArithmeticException("Не правильный ввод, Ведите цифры от 1 до 10 через пробел!");
        }
    }
    public static String resultRoman(int number) {
        StringBuilder SB = new StringBuilder();
        int check = 0;
        String[] roman = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };
        int[] arab = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100 };
        for (int i = arab.length - 1; i >= 0; i--) { //8
            check = number / arab[i];
            number %= arab[i];
            while (check > 0) {
                SB.append(roman[i]);
                check--;
            }
        }
        return SB.toString();
    }
}

