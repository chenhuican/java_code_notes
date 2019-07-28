package classes;

import java.lang.reflect.Array;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] anArray;
        anArray = new int[10];

        int[] intArray2 = new int[]{0,1,2};

        int[] anArray1 = new int[10];

        anArray1[0] = 100;

        anArray[0] = 100;
        anArray[1] = 200;
        System.out.println("anArray = " + anArray[0]);
    }
}
