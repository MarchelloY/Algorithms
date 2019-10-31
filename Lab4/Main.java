package Lab4;

/*
9. Составить две программы, которые реализуют алгоритмы
ускоренной сортировки «пузырьком» и выбором. Исходные данные
задавать с помощью датчика случайных чисел.
*/

public class Main {
    public static void main(String[] args) {
        int n = 100000;
        int[] numbersOne = new int[n], numbersTwo = new int[n];
        //Заполнение массивов целочисленными значениями от 0 до 100
        for(int i = 0; i < n; i++){
            numbersOne[i] = (int) (Math.random() * 100);
            numbersTwo[i] = numbersOne[i];
        }
        long start, end;
        start = System.nanoTime();
        /*int[] resultOne =*/
        SpeedSortBubble(numbersOne, 1, true);
        end = System.nanoTime();
        System.out.println("Ускоренный алгоритм сортировки пузырьком для " + n
                + " элементов проработал " + ((double) (end - start) / 1000000000) + " секунд!"
                /*+ "\nПолучившийся массив: " + Arrays.toString(resultOne)*/);
        start = System.nanoTime();
        /*int[] resultTwo =*/
        SortChoice(numbersTwo);
        end = System.nanoTime();
        System.out.println("Алгоритм сортировки вставками для " + n
                + " элементов проработал " + ((double) (end - start) / 1000000000) + " секунд!"
                /*+ "\nПолучившийся массив: " + Arrays.toString(resultTwo)*/);
    }

    //Ускоренный алгоритм сортировки пузырьком
    public static int[] SpeedSortBubble(int[] numbers, int k, boolean flag){
        while(flag){
            flag = false;
            for (int j = 0; j < numbers.length - k; j++)
                if(numbers[j] > numbers[j + 1]){
                    numbers[j] = numbers[j] + numbers[j + 1] - (numbers[j + 1] = numbers[j]);
                    flag = true;
                }
            k++;
        }
        return numbers;
    }

    //Сортировка вставками
    public static int[] SortChoice(int[] numbers){
        for(int i = 1; i < numbers.length; i++)
            for(int j = i; j > 0 && numbers[j - 1] > numbers[j]; j--){
                numbers[j] = numbers[j] + numbers[j - 1] - (numbers[j - 1] = numbers[j]);
            }
        return numbers;
    }
}
