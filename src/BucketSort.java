import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    public static void sort(int[] array, int n) {

        List<Integer>[] buckets = new List[n];

        for (int i = 0; i < n; i++)
            buckets[i] = new LinkedList<>();

        for (int num : array)
            buckets[hash(num, n)].add(num);

        for (List<Integer> bucket : buckets)
            Collections.sort(bucket);

        int index = 0;

        for (List<Integer> bucket : buckets)
            for (int num : bucket)
                array[index++] = num;
    }

    private static int hash(int num, int size) {
        return num / size;
    }
}
