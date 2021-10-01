package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce {


    /**
     * reduce to reduce the list of elements to a single ele
     * after a operation
     */

    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> integerList = Arrays.asList(numbers);




      Integer sum =   integerList.
                  stream()
                 .reduce( (acc,x)->  acc + x)
                 .get();

      System.out.println("sum of all numbers :"+sum);

        // acc is the variable in which result is accumulated
        // x is the element of stream
      BinaryOperator<Integer> binaryOperator = (acc, x)-> acc * x;







    }
}
