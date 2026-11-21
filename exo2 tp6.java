import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class QuicksortTP6 {

    private static final Random RANDOM = new Random();

    public static void quicksort(ArrayList<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quicksort(list, 0, list.size() - 1);
    }

    private static void quicksort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quicksort(list, low, pivotIndex - 1);
            quicksort(list, pivotIndex + 1, high);
        }
    }

    public static int partition(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list, i, high);
        return i;
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        if (i != j) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static void randomInit(ArrayList<Integer> input, int size) {
        input.clear();
        input.ensureCapacity(size);
        for (int i = 0; i < size; i++) {
            input.add(RANDOM.nextInt());
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> exemple = new ArrayList<>();
        exemple.add(25);
        exemple.add(10);
        exemple.add(40);
        exemple.add(15);
        exemple.add(30);
        exemple.add(5);
        quicksort(exemple);
        System.out.println("Exemple trie : " + exemple);

        int[] sizes = {1000, 5000, 10000, 50000, 100000, 250000};
        System.out.println("taille;temps_ns;temps_ms");
        for (int size : sizes) {
            ArrayList<Integer> data = new ArrayList<>();
            randomInit(data, size);

            long startNs = System.nanoTime();
            quicksort(data);
            long endNs = System.nanoTime();

            long elapsedNs = endNs - startNs;
            double elapsedMs = elapsedNs / 1_000_000.0;
            System.out.printf(Locale.US, "%d;%d;%.3f%n", size, elapsedNs, elapsedMs);
        }
    }
}