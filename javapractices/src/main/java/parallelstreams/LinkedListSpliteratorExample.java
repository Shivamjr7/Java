package parallelstreams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.CommonUtil.*;

public class LinkedListSpliteratorExample {


    List<Integer> inputListmultiplyEachValue(LinkedList<Integer> inputList, int multiplyValue, boolean isParallel) {

        stopWatchReset();
        startTimer();
        Stream<Integer> integerStream = inputList.stream();

        if (isParallel)
            integerStream.parallel();

        List<Integer> result = integerStream.map(integer -> integer * multiplyValue)
                .collect(Collectors.toList());

        timeTaken();
        return result;


    }
}
