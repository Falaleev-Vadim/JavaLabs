import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в программу для расчета площади круга.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите радиус круга (должен быть положительным числом): ");
        String input = scanner.nextLine();

        double radius;
        try
        {
            radius = Double.parseDouble(input);
            if (radius <= 0) {
                throw new NumberFormatException("Радиус должен быть больше нуля.");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        double area = Math.PI * Math.pow(radius, 2);
        System.out.printf("Площадь круга с радиусом %.2f равна %.2f%n", radius, area);
    }
}