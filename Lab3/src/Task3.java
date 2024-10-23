import java.util.Scanner;

public class Task3 {

    public static double[] calculateAverages(int[] A) {
        int N = A.length;
        double[] B = new double[N];

        double sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += A[i];
            B[i] = sum / (N - i);
        }

        return B;
    }

    public static void main(String[] args) {
        //Вариант 9
        /*
        Дан массив A размера N.
        Сформировать новый массив B того же размера по следующему правилу:
        элемент BK равен среднему арифметическому элементов массива A с номерами от K до N.
        Реализовать в виде отдельного статического метода.
         */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int N = scanner.nextInt();

        int[] A = new int[N];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        double[] B = calculateAverages(A);

        System.out.print("Массив B: ");
        for (double b : B) {
            System.out.printf("%.2f ", b);
        }
    }
}