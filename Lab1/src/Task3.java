import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        // Вариант 9
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число Х: ");
        double x = scanner.nextDouble();

        System.out.print("Введите число Y: ");
        double y = scanner.nextDouble();

        System.out.print("Введите число Z: ");
        double z = scanner.nextDouble();

        double min = Math.min(Math.min(x, y), z);
        double max = Math.max(Math.max(x, y), z);

        System.out.println("Минимальным числом является:\n" + min);
        System.out.println("Максимальным числом является:\n" + max);
    }
}