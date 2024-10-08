import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

public class Task4 {

    public static BigDecimal processFloatNumber (double number)
    {
        BigDecimal bdNumber = BigDecimal.valueOf(number);
        BigDecimal integerPart = bdNumber.setScale(0, RoundingMode.DOWN);
        BigDecimal fractionalPart = bdNumber.subtract(integerPart);

        System.out.println("Число: " + bdNumber);
        System.out.println("Целая часть: " + integerPart);
        System.out.println("Дробная часть: " + fractionalPart);

        return fractionalPart;
    }

    public static void main(String[] args) {
        /*
        Вариант 9
        Описать метод, принимающий вещественное число, распечатывает само число,
        его целую часть, его дробную часть, а также возвращает дробную часть.
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вещественное число X: ");
        double x = scanner.nextDouble();

        BigDecimal result = processFloatNumber(x);
        System.out.println("Возвращенная дробная часть: " + result);
    }
}