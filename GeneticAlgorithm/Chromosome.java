package GeneticAlgorithm;

public class Chromosome {

    private int[] genes = new int[Config.GENES_COUNT];
    private float fitness;
    private float likelihood;

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public float getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(float likelihood) {
        this.likelihood = likelihood;
    }

    public float calculateFitness() {
        int u = genes[0];
        int w = genes[1];
        int x = genes[2];
        int y = genes[3];
        int z = genes[4];
        int closeness = Math.abs(Config.TARGET_VALUE - Main.function(u, w, x, y, z));
        Main.log("Близость: " + closeness);
        return 0 != closeness ? 1 / (float) closeness : Config.TARGET_IS_REACHED_FLAG;
    }

    public Chromosome mutateWithGivenLikelihood() {
        Main.log("*** НАЧАЛО мутации...\nВероятность мутации = " + Config.MUTATION_LIKELIHOOD);
        Chromosome result = (Chromosome) this.cloneChromosome();
        for (int i = 0; i < Config.GENES_COUNT; ++i) {
            float randomPercent = Main.getRandomFloat(0, 100);
            if (randomPercent < Config.MUTATION_LIKELIHOOD) {
                int oldValue = result.getGenes()[i];
                int newValue = Main.getRandomGene();
                Main.log("Мутация произошла в гене №" + i + ", Рандомное число = " + randomPercent
                        + ", старое значение = " + oldValue + ", новое значение = " + newValue);
                result.getGenes()[i] = newValue;
            }
        }
        Main.log("*** КОНЕЦ мутации...");
        return result;
    }

    public Chromosome[] doubleCrossover(Chromosome chromosome) {
        Main.log("*** НАЧАЛО двойного скрещивания...");
        Main.log("Хромосома 1 родителя: " + this);
        Main.log("Хромосома 2 родителя: " + chromosome);
        int crossoverLine = getRandomCrossoverLine();
        Chromosome[] result = new Chromosome[2];
        result[0] = new Chromosome();
        result[1] = new Chromosome();
        for (int i = 0; i < Config.GENES_COUNT; ++i) {
            if (i <= crossoverLine) {
                result[0].getGenes()[i] = this.getGenes()[i];
                result[1].getGenes()[i] = chromosome.getGenes()[i];
            } else {
                result[0].getGenes()[i] = chromosome.getGenes()[i];
                result[1].getGenes()[i] = this.getGenes()[i];
            }
        }
        Main.log("Итогововая хромосома №0:\n" + result[0]);
        Main.log("Итогововая хромосома №1:\n" + result[1]);
        Main.log("*** КОНЕЦ двойного скрещивания...");
        return result;
    }

    public Chromosome singleCrossover(Chromosome chromosome) {
        Main.log("*** НАЧАЛО одиночного скрещивания...\nВызов двойного скрещивания...");
        Chromosome[] children = doubleCrossover(chromosome);
        Main.log("Выбор одного из двух ребенков, вернувшихся из двойного скрещивания...");
        int childNumber = Main.getRandomInt(0, 1);
        Main.log("Выбранный ребенок №" + childNumber + ", с хромосомой: " + children[childNumber]);
        Main.log("*** КОНЕЦ одиночного скрещивания...");
        return children[childNumber];
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("(");
        for (int i = 0; i < Config.GENES_COUNT; ++i) {
            result.append(genes[i]);
            result.append(i < Config.GENES_COUNT - 1 ? ", " : "");
        }
        result.append(")");
        return result.toString();
    }

    private static int getRandomCrossoverLine() {
        int line = Main.getRandomInt(0, Config.GENES_COUNT - 2);
        Main.log("Линия скрещивания будет на позиции " + line);
        return line;
    }

    protected Object cloneChromosome() {
        Chromosome resultChromosome = new Chromosome();
        resultChromosome.setFitness(this.getFitness());
        resultChromosome.setLikelihood(this.getLikelihood());
        resultChromosome.setGenes(this.genes.clone());
        return resultChromosome;
    }
}