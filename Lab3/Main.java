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
        Arrays.sort(arrayNum);
        long start, end;
        start = System.nanoTime();
        int result = RecursionSearchNum(arrayNum,0, arrayNum.length - 1, number);
        end = System.nanoTime();
        System.out.println(result == -1 ? "Такое число отсутствует!" : "Число найдено! Вернувшееся значение: " + result);
        System.out.println("Алгоритм поиска проработал " + ((double) (end - start) / 1000000) + " миллисекунд!");
    }

    private static int RecursionSearchNum(int[] arr, int first, int last, int num){
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == num) return arr[mid];
            if (arr[mid] > num) return RecursionSearchNum(arr, first, mid - 1, num);
            return RecursionSearchNum(arr, mid + 1, last, num);
        }
        return -1;
    }
}
