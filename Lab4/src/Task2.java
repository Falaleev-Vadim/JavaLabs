import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        CircleCalculator calculator = new CircleCalculator();
        calculator.start();
    }
}

class Circle {
    private double radius;
    private double area;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
        this.area = calculateArea();
    }

    private double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return area;
    }
}

class CircleCalculator {
    private Circle[] circles;
    private int count;
    private final int maxCircles = 10;

    public CircleCalculator() {
        circles = new Circle[maxCircles];
        count = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (count < maxCircles) {
                        addCircle(scanner);
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
                    showResults();
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    System.out.println();
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Выполнить расчет площади круга");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход из программы");
        System.out.println("5. Показать результаты расчетов");
        System.out.print("Выберите опцию: ");
    }

    private void addCircle(Scanner scanner) {
        double radius = getRadius(scanner);
        if (radius > 0) {
            circles[count] = new Circle(radius);
            System.out.printf("Площадь круга с радиусом %.2f равна %.2f%n", radius, circles[count].getArea());
            count++;
        }
    }

    private double getRadius(Scanner scanner) {
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

    private void showProgramInfo() {
        System.out.println("Это программа для расчета площади круга на основе введенного радиуса.");
        System.out.println();
    }

    private void showDeveloperInfo() {
        System.out.println("Разработчик: Фалалеев Вадим. Версия 1.0");
        System.out.println();
    }

    private void showResults() {
        if (count == 0) {
            System.out.println("Нет выполненных расчетов.");
            return;
        }
        System.out.println("Результаты расчетов:");
        for (int i = 0; i < count; i++) {
            System.out.printf("Радиус: %.2f, Площадь: %.2f%n", circles[i].getRadius(), circles[i].getArea());
        }
        System.out.println();
    }
}