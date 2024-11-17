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