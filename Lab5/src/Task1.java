import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        ShapeCalculator calculator = new ShapeCalculator();
        calculator.start();
    }
}

abstract class Shape {
    protected double area;

    public abstract double calculateArea();

    public double getArea() {
        return area;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
        this.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius + ", Area: " + area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle other = (Circle) obj;
        return Double.compare(radius, other.radius) == 0;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными числами.");
        }
        this.base = base;
        this.height = height;
        this.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return "Triangle with base: " + base + ", height: " + height + ", Area: " + area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triangle)) return false;
        Triangle other = (Triangle) obj;
        return Double.compare(base, other.base) == 0 && Double.compare(height, other.height) == 0;
    }
}

class ShapeCalculator {
    private Shape[] shapes;
    private int count;
    private final int maxShapes = 10;

    public ShapeCalculator() {
        shapes = new Shape[maxShapes];
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
                    if (count < maxShapes) {
                        addShape(scanner);
                    } else {
                        System.out.println("Достигнуто максимальное количество фигур. Пожалуйста, очистите данные для новых расчетов.");
                    }
                    break;
                case "2":
                    showResults();
                    break;
                case "3":
                    exit = true;
                    System.out.println("Выход из программы. Спасибо за использование!");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Добавить фигуру");
        System.out.println("2. Показать результаты расчетов");
        System.out.println("3. Выход из программы");
        System.out.print("Выберите опцию: ");
    }

    private void addShape(Scanner scanner) {
        System.out.println("Выберите фигуру для добавления (1 - Круг, 2 - Треугольник): ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.print("Введите радиус круга: ");
                double radius = scanner.nextDouble();
                shapes[count++] = new Circle(radius);
                break;
            case "2":
                System.out.print("Введите основание треугольника: ");
                double base = scanner.nextDouble();
                System.out.print("Введите высоту треугольника: ");
                double height = scanner.nextDouble();
                shapes[count++] = new Triangle(base, height);
                break;
            default:
                System.out.println("Неверный выбор фигуры.");
                break;
        }
        scanner.nextLine();
    }

    private void showResults() {
        if (count == 0) {
            System.out.println("Нет выполненных расчетов.");
            return;
        }
        System.out.println("Результаты расчетов:");
        for (int i = 0; i < count; i++) {
            System.out.println(shapes[i].toString());
        }
    }
}