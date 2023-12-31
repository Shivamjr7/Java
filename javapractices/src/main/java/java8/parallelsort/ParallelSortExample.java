package java8.parallelsort;

import java.util.Arrays;

public class ParallelSortExample {


    public static void main(String[] args) {
        int [] array1  = {15,6,2,3,4,1,0,-1};

        Arrays.parallelSort(array1);
        System.out.println(Arrays.toString(array1));
    }


}
