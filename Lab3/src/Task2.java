import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        //Вариант 9
        /*
        Дан массив размера N.
        Найти номера тех элементов массива, которые больше своего левого соседа, и количество таких элементов.
        Найденные номера выводить в порядке их убывания.
         */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int N = scanner.nextInt();

        int[] array = new int[N];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        List<Integer> indices = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            if (array[i] > array[i - 1]) {
                indices.add(i);
            }
        }

        indices.sort(Collections.reverseOrder());

        System.out.println("Индексы элементов, больших своих левых соседей (в порядке убывания): " + indices);
        System.out.println("Количество таких элементов: " + indices.size());
    }
}