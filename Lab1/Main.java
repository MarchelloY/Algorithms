package Lab1;

/*
9.Составить программу, которая формирует матрицу из n*n случайных чисел.
  Определить произведение всех чисел в матрице.
  Значение n меняется в пределах от 5 до 10 тысяч.
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        int n = 5000;
        for(int l = 0; 6 > l; l++) {
            long result = 1;
            long[][] m = new long[n][n];
            for (int i = 0; n > i; i++) {
                for (int j = 0; n > j; j++) {
                    m[i][j] = (int) (1 + Math.random());
                }
            }
            List<Integer> time = new ArrayList<>();
            mainloop:
            for (int k = 0; 5 > k; k++) {
                long start = System.nanoTime();
                for (int i = 0; n > i; i++) {
                    for (int j = 0; n > j; j++) {
                        if(m[i][j]==0) break mainloop;
                        result *= m[i][j];
                    }
                }
                long end = System.nanoTime() - start;
                System.out.println("Значение " + (k + 1) + ": " + (double) end / 1000000 + " миллисекунд");
                time.add((int) end / 1000000);
            }
            System.out.println("Усредненное значение времени для " + (l + 5)*1000 + " элементов: " + ((time.stream().mapToDouble(a -> a).sum() / 5)));
            n += 1000;
        }
    }
}
