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