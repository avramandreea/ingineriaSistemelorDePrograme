package lab4;

import java.util.*;

public class ListOperations {
    public static void main(String[] args) {
        Random rand = new Random();

        //  val aleatorii
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        rand.ints(5, 0, 11).forEach(x::add);
        rand.ints(7, 0, 11).forEach(y::add);

        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11)); // Val în dom [0,10]
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x: " + x);
        System.out.println("Lista y: " + y);

        // a
        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("Lista xPlusY: " + xPlusY);

        // b
        Set<Integer> zSet = new TreeSet<>(x);
        zSet.retainAll(y);
        System.out.println("Setul zSet: " + zSet);

        // c
        List<Integer> xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y);
        System.out.println("Lista xMinusY: " + xMinusY);

        // d
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        for (int num : xPlusY) {
            if (num <= p) {
                xPlusYLimitedByP.add(num);
            }
        }
        System.out.println("Lista xPlusYLimitedByP (<= " + p + "): " + xPlusYLimitedByP);
    }
}
