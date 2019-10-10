package Lab2;

/*
8.Разработать алгоритм и программу ускоренного линейного поиска.
 В качестве исходных данных использовать строку текста,
 из которой необходимо выделить слова.
 Затем слова упорядочить по алфавиту. Аргумент поиска – слово.
*/


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = "Бурого медведя считают хозяином смешанных лесов. " +
                "Он очень любит малину и мёд. Косолапый часто совершает набеги на жилища диких пчёл. " +
                "Забредает порой на пасеки. Пчёлы мстят медведю. Они жалят его в кончик носа, язык. " +
                "Зверю приходится спасаться бегством.";
        String[] words = text.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");
        System.out.println("Неотстортированный массив слов: " + Arrays.toString(words));
        Arrays.sort(words);
        System.out.println("Отстортированный массив слов: " + Arrays.toString(words));
        System.out.print("Введите слово, которое нужно найти: ");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        long end, start;
        start = System.nanoTime();
        int position = SearchWord(words, word);
        end = System.nanoTime();
        if(position == -1){
            System.out.println("Нету совпадений");
        } else {
            System.out.println("Слово было найдено на " + (position + 1) + "-ой позиции в отсортированном массиве!");
        }
        System.out.println("Алгоритм поиска проработал " + ((double) (end - start) / 1000000) + " миллисекунд!");
    }

    private static int SearchWord(String[] str, String word){
        for(int i = 0; i < str.length; i++){
            if(str[i].equals(word)) return i;
        }
        return -1;
    }
}
