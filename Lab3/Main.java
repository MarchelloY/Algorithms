package Lab3;

/*
9.Разработать следующий алгоритм и программу с использованием рекурсии.
Ввод одномерного массива и линейного поиска целочисленного значения ключа в нем.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите размерность массива: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arrayNum = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите " + (i + 1) + " число в массив: ");
            arrayNum[i] = scan.nextInt();
        }
        System.out.print("Введите цифру, которую нужно найти: ");
        int number = scan.nextInt();
        long start, end;
        start = System.nanoTime();
        int result = RecursionSearchWord(arrayNum, number);
        end = System.nanoTime();
        System.out.println(result == 0 ? "Такое число отсутствует!" : "Число найдено! Вернувшееся значение: " + result);
        System.out.println("Алгоритм поиска проработал " + ((double) (end - start) / 1000000) + " миллисекунд!");
    }

    private static int RecursionSearchWord(int[] arrayNum, int number){
        int size = arrayNum.length/2;
        for(int j = 0; j < size; j++)
            if(arrayNum[j] == number)
                return arrayNum[j];
        if(arrayNum.length == 1)
            return arrayNum[0] == number ? arrayNum[0] : 0;
        return RecursionSearchWord(Arrays.copyOfRange(arrayNum, size, arrayNum.length), number);
    }
}
