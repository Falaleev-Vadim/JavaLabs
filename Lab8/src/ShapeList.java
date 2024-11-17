import java.util.ArrayList;

class ShapeList<T extends Shape> {
    private ArrayList<T> shapes;

    public ShapeList() {
        shapes = new ArrayList<>();
    }

    public void addShape(T shape) {
        shapes.add(shape);
    }

    public T getShape(int index) {
        return shapes.get(index);
    }

    public int size() {
        return shapes.size();
    }

    public void displayShapes() {
        if (shapes.isEmpty()) {
            System.out.println("Список фигур пуст.");
            return;
        }
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i).toString());
        }
    }

    public T removeShape(int index) {
        return shapes.remove(index);
    }
}

