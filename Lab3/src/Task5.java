import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        double[] radii = new double[10]; // Массив для хранения радиусов
        double[] areas = new double[10];  // Массив для хранения площадей
        int count = 0;                    // Счетчик для отслеживания количества расчетов

        while (!exit) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (count < radii.length) {
                        count = calculateArea(scanner, radii, areas, count);
                    } else {
                        System.out.println("Достигнуто максимальное количество радиусов. Пожалуйста, очистите данные для новых расчетов.");
                    }
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
                case "5":
                    showResults(radii, areas, count);
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
        System.out.println("5. Показать результаты расчетов");
        System.out.print("Выберите опцию: ");
    }

    private static int calculateArea(Scanner scanner, double[] radii, double[] areas, int count) {
        double radius = getRadius(scanner);
        if (radius > 0) {
            double area = Math.PI * Math.pow(radius, 2);
            System.out.printf("Площадь круга с радиусом %.2f равна %.2f%n", radius, area);
            System.out.println();

            radii[count] = radius;
            areas[count] = area;
            count++;
        }
        return count;
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

    private static void showResults(double[] radii, double[] areas, int count) {
        if (count == 0) {
            System.out.println("Нет выполненных расчетов.");
            return;
        }
        System.out.println("Результаты расчетов:");
        for (int i = 0; i < count; i++) {
            System.out.printf("Радиус: %.2f, Площадь: %.2f%n", radii[i], areas[i]);
        }
        System.out.println();
    }
}