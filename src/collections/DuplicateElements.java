package collections;
import java.util.*;

public class DuplicateElements {


    public static <T> ArrayList <T> removeDuplicateElements(ArrayList<T> list)
    {
        HashSet<T> set = new HashSet<T>(list);
        return new ArrayList<T>(set);
    }

    public static void main(String args[])
    {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 11, 2, 23, 2, 4, 15, 15);



        System.out.println("ArrayList with duplicates: " + list);

        ArrayList<Integer> newList = removeDuplicateElements(list);

        System.out.println("ArrayList without duplicates: " + newList);
    }
}


