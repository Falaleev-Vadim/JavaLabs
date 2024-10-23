import java.util.Scanner;

public class Task4 {

    public static void printSpiral(int[][] A) {
        int M = A.length;
        int top = 0, bottom = M - 1, left = 0, right = M - 1;

        while (top <= bottom && left <= right) {
            for (int i = top; i <= bottom; i++) {
                System.out.print(A[i][left] + " ");
            }
            left++;

            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    System.out.print(A[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(A[i][right] + " ");
                }
                right--;
            }

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(A[top][i] + " ");
                }
                top++;
            }
        }
    }

    public static void main(String[] args) {
        //Вариант 9
        /*
        Дана квадратная матрица A порядка M (M — нечетное число).
        Начиная с элемента A1,1 и перемещаясь против часовой стрелки, вывести все ее элементы по спирали:
        первый столбец, последняя строка, последний столбец в обратном порядке, первая строка в обратном порядке,
        оставшиеся элементы второго столбца и т. д.; последним выводится центральный элемент матрицы.
         */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы (нечетное число): ");
        int M = scanner.nextInt();

        if (M % 2 == 0) {
            System.out.println("Размер матрицы должен быть нечетным числом.");
            return;
        }

        int[][] A = new int[M][M];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Элементы матрицы по спирали (против часовой стрелки):");
        printSpiral(A);
    }
}