package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListOperations {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();

        while(list.size() < 10) {
            int x = random.nextInt(50);
            if (!list.contains(x)) {
                list.add(x);
            }
        }

        int min = Collections.min(list);
        int max = Collections.max(list);
        double sum = 0;
        for (double x: list)
        {
            sum += x;
        }
        double average = sum/ list.size();

        System.out.println(list);
        System.out.println("Maximum value is: " + max);
        System.out.println("Minimum value is: " + min);
        System.out.println("Average value is: " + average);
    }
}
