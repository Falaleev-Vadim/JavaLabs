import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        //Вариант 9
        /*
        Дан массив A размера N. Вывести его элементы в следующем порядке:
        A1, A2, An, A(n-1), A3, A4, A(n-2), A(n-3), ...
         */

        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = A.length;

        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        int index = 0;

        while (left <= right) {
            result[index++] = A[left++];
            if (left <= right) {
                result[index++] = A[left++];
            }
            if (left <= right) {
                result[index++] = A[right--];
                if (left <= right) {
                    result[index++] = A[right--];
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }
}