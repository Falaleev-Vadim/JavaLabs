import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        // Вариант 9
        // 1/(n^2 - 1)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число N, N >= 2: ");
        String NString = scanner.nextLine();

        int N;
        try {
            N = Integer.parseInt(NString);

            if (N < 2){
                throw new NumberFormatException("N должен быть больше 2");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        double sum = 0;

        for (int i = 2; i <= N; i++){
            sum += 1 / (Math.pow(i, 2) - 1);
        }

        System.out.print(sum);
    }
}