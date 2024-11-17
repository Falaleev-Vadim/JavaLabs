import java.util.Scanner;

class ShapeCalculator {
    private ShapeList<Shape> shapes;
    private final int maxShapes = 10;

    public ShapeCalculator() {
        shapes = new ShapeList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (shapes.size() < maxShapes) {
                        try {
                            addShape(scanner);
                        } catch (ShapeInputException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Неверный ввод. Попробуйте снова.");
                        }
                    } else {
                        System.out.println("Достигнуто максимальное количество фигур.");
                    }
                    break;
                case "2":
                    showResults();
                    break;
                case "3":
                    exit = true;
                    System.out.println("Выход из программы.");
                    break;
                case "4":
                    resizeShape(scanner);
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Добавить фигуру");
        System.out.println("2. Показать результаты");
        System.out.println("3. Выход");
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
                shapes.addShape(new Circle(radius));
                break;
            case "2":
                System.out.print("Введите основание треугольника: ");
                double base = scanner.nextDouble();
                System.out.print("Введите высоту треугольника: ");
                double height = scanner.nextDouble();
                shapes.addShape(new Triangle(base, height));
                break;
            default:
                System.out.println("Неверный выбор.");
        }
        scanner.nextLine();
    }

    private void showResults() {
        shapes.displayShapes();
    }

    private void resizeShape(Scanner scanner) {
        if (shapes.size() == 0) {
            System.out.println("Нет фигур для изменения.");
            return;
        }

        System.out.println("Выберите фигуру для изменения размера (введите номер фигуры): ");
        showResults();
        int shapeIndex = scanner.nextInt() - 1;

        if (shapeIndex < 0 || shapeIndex >= shapes.size()) {
            System.out.println("Неверный номер фигуры.");
            return;
        }

        System.out.print("Введите коэффициент изменения размера: ");
        double factor = scanner.nextDouble();

        Shape shape = shapes.getShape(shapeIndex);
        if (shape instanceof Resizable) {
            ((Resizable) shape).resize(factor);
            System.out.println("Размер фигуры успешно изменен.");
        } else {
            System.out.println("Эта фигура не поддерживает изменение размера.");
        }

        scanner.nextLine();
    }
}