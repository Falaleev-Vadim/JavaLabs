class Utility {
    public static <T extends Comparable<T>> int compare(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }
}