import java.util.Scanner;

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
                        try {
                            addShape(scanner);
                        } catch (ShapeInputException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Неверный ввод. Попробуйте снова.");
                        }
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
                case "4":
                    resizeShape(scanner);
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
        System.out.println("4. Изменить размер фигуры");
        System.out.print("Выберите опцию: ");
    }

    private void addShape(Scanner scanner) throws ShapeInputException {
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
            System.out.println((i + 1) + ". " + shapes[i].toString());
        }
    }

    private void resizeShape(Scanner scanner) {
        if (count == 0) {
            System.out.println("Нет фигур для изменения.");
            return;
        }

        System.out.println("Выберите фигуру для изменения размера (введите номер фигуры): ");
        showResults();
        int shapeIndex = scanner.nextInt() - 1;

        if (shapeIndex < 0 || shapeIndex >= count) {
            System.out.println("Неверный номер фигуры.");
            return;
        }

        System.out.print("Введите коэффициент изменения размера: ");
        double factor = scanner.nextDouble();

        if (shapes[shapeIndex] instanceof Resizable) {
            ((Resizable) shapes[shapeIndex]).resize(factor);
            System.out.println("Размер фигуры успешно изменен.");
        } else {
            System.out.println("Эта фигура не поддерживает изменение размера.");
        }

        scanner.nextLine();
    }
}