package w.tasks.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class Speed {

    public static void compareTwoLists(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList){

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(randomWithRange(1,100));
        }
        long timeForArrayList = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(randomWithRange(1,100));
        }
        long timeForLinkedList = System.currentTimeMillis() - startTime;

        if (timeForArrayList < timeForLinkedList) {
            System.out.println("ArrayList is quicker");
        }
        else
        {
            System.out.println("LinkedList is quicker");
        }

    }

    public static int randomWithRange(int min, int max){

        return (int)(Math.random() * max) + min;
    }

    public static void main(String[] args) {
        ArrayList<Integer>arrayList = new ArrayList<Integer>();
        LinkedList<Integer>linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(randomWithRange(1,100));
            linkedList.add(randomWithRange(1,100));
        }
        compareTwoLists(arrayList,linkedList);

    }
}
