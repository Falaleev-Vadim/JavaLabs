import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        /*
        Вариант 9
        Дано целое число N (> 0).
        Используя операции деления нацело и взятия остатка от деления,
        вывести все его цифры, начиная с самой правой (разряда единиц)
        */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число N, N > 0: ");
        String NString = scanner.nextLine();

        int N;
        try
        {
            N = Integer.parseInt(NString);

            if (N <= 0) {
                throw new NumberFormatException("Число должно быть больше нуля.");
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        while (N > 9){
            System.out.println(N % 10);
            N /= 10;
        }

        System.out.println(N);
    }
}