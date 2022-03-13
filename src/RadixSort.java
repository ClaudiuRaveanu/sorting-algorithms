import java.util.Arrays;

public class RadixSort {

    public static void sort(int[] array) {

        int max = getMax(array);

        for (int placeValue = 1; max / placeValue > 0; placeValue *= 10)
            countSort(array, placeValue);
    }

    public static void countSort(int[] array, int placeValue) {

        int output[] = new int[array.length];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < array.length; i++)
            count[(array[i] / placeValue) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / placeValue) % 10] - 1] = array[i];
            count[(array[i] / placeValue) % 10]--;
        }

        for (int i = 0; i < array.length; i++)
            array[i] = output[i];
    }

    public static int getMax(int[] array) {

        int max = array[0];

        for (int i = 0; i < array.length; i++)
            if (array[i] > max)
                max = array[i];

        return max;
    }
}
