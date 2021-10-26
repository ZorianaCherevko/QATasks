package collections;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 11, 2, 23, 4, 15, 7, 89, 1);

        int min = Collections.min(list);
        int max = Collections.max(list);
        int sum = 0;
        for (double x: list)
        {
            sum += x;
        }
        int average = sum/ list.size();

        System.out.println("Maximum value is: " + max);
        System.out.println("Minimum value is: " + min);
        System.out.println("Average value is: " + average);
    }
}
