import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        // Вариант 9
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число X: ");
        double x = scanner.nextDouble();

        System.out.print("Введите число Y: ");
        double y = scanner.nextDouble();

        System.out.print("Введите число Z: ");
        double z = scanner.nextDouble();

        double min = x;
        double max = x;

        if (y < min) {
            min = y;
        }
        if (z < min) {
            min = z;
        }

        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }

        System.out.println("Минимальным числом является:\n" + min);
        System.out.println("Максимальным числом является:\n" + max);
    }
}