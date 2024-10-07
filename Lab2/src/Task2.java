import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        // Вариант 9
        // (-1)^(N-1) * x^N/N
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число X, |X| < 1: ");
        String X = scanner.nextLine();
        System.out.print("Введите целое число N, N > 0: ");
        String N = scanner.nextLine();

        try
        {
            if (Math.abs(Double.parseDouble(X)) >= 1) {
                throw new NumberFormatException("Модуль Х должен быть меньше единицы.");
            }
            if (Integer.parseInt(N) <= 0) {
                throw new NumberFormatException("Число N должно быть больше нуля.");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        double newX = Double.parseDouble(X);
        int newN = Integer.parseInt(N);
        double sum = newX;

        if (newN == 1) {
            System.out.println(sum);
        }
        else {
            for (int i = 2; i <= newN; i++) {
                sum += Math.pow(-1, i-1) * Math.pow(newX, i) / i;
            }

            System.out.println(sum);
        }
    }
}