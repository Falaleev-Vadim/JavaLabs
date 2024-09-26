import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        // Вариант 9
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число Х: ");
        double x = scanner.nextDouble();
        System.out.println(Math.exp(x * 2) + Math.sqrt((4 * x) / 8));
    }
}