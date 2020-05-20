package StainerTree;

/*
    9 ВАРИАНТ
    УСЛОВИЕ: Заданы граф G = (V, E), подмножество R ⊆ V и положительное целое число K ⊆ |V| - 1;
    ВОПРОС: Существует ли поддерево в G, содержащее все вершины из R и имеющее не более K ребер?
*/

/*
    Например |V| = 5
    R ⊆ V        --> r = {0, 1, 2 , 3, 4, 5} вершин
    K ⊆ |V| - 1  --> k = {0, 1, 2, 3, 4}
*/

public class Main {
    public static void main(String[] args) {
        int n = 5;
        for (int r = 0; r <= n; r++) {
            for (int k = 0; k <= n - 1; k++) {
                System.out.println("R = " + r + ", K = " + k + " -> " + isExistSubtree(r, k));
            }
            System.out.println("----------------------");
        }
    }

    public static String isExistSubtree(int r, int k) {
        return r - 1 <= k ? "Существует" : "Не существует";
    }
}