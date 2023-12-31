package parallelstreams;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import util.DataSet;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListSpliteratorExampleTest {

    LinkedListSpliteratorExample linkedListSpliteratorExample = new LinkedListSpliteratorExample();

    @RepeatedTest(5)
    void inputListmultiplyEachValue() {
        //given
        int size = 100000;
        LinkedList<Integer> integerLinkedList = DataSet.generateIntegerLinkedList(size);

        //when
        List<Integer> result = linkedListSpliteratorExample.inputListmultiplyEachValue(integerLinkedList, 2, false);

        //then
        assertEquals(size, result.size());
    }

    @RepeatedTest(5)
    void inputListmultiplyEachValue_parallel() {
        //given
        int size = 100000;
        LinkedList<Integer> integerLinkedList = DataSet.generateIntegerLinkedList(size);

        //when
        List<Integer> result = linkedListSpliteratorExample.inputListmultiplyEachValue(integerLinkedList, 2, true);

        //then
        assertEquals(size, result.size());
    }
}