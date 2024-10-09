import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    calculateArea(scanner);
                    break;
                case "2":
                    showProgramInfo();
                    break;
                case "3":
                    showDeveloperInfo();
                    break;
                case "4":
                    exit = true;
                    System.out.println("Выход из программы. Спасибо за использование!");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    System.out.println();
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Выполнить расчет площади круга");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход из программы");
        System.out.print("Выберите опцию: ");
    }

    private static void calculateArea(Scanner scanner) {
        double radius = getRadius(scanner);
        if (radius > 0) {
            double area = Math.PI * Math.pow(radius, 2);
            System.out.printf("Площадь круга с радиусом %.2f равна %.2f%n", radius, area);
            System.out.println();
        }
    }

    private static double getRadius(Scanner scanner) {
        double radius = -1;
        while (radius <= 0) {
            System.out.print("Введите радиус круга (должен быть положительным числом): ");
            String input = scanner.nextLine();
            try {
                radius = Double.parseDouble(input);
                if (radius <= 0) {
                    System.out.println("Ошибка: радиус должен быть больше нуля.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        return radius;
    }

    private static void showProgramInfo() {
        System.out.println("Это программа для расчета площади круга на основе введенного радиуса.");
        System.out.println();
    }

    private static void showDeveloperInfo() {
        System.out.println("Разработчик: Фалалеев Вадим. Версия 1.0");
        System.out.println();
    }
}