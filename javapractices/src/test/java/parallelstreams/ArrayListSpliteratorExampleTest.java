package parallelstreams;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import util.DataSet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListSpliteratorExampleTest {


    ArrayListSpliteratorExample arrayListSpliteratorExample = new ArrayListSpliteratorExample();

    @RepeatedTest(5)
    void inputListmultiplyEachValue() {

        int size = 1000000;

        //given
        ArrayList<Integer> integers = DataSet.generateArrayList(size);

        //when
        List<Integer> res = arrayListSpliteratorExample.inputListmultiplyEachValue(integers, 2, false);

        //then

        assertEquals(size, res.size());

    }

    //this will have greater performance since it is run in parallel
    @RepeatedTest(5)
    void inputListmultiplyEachValue_parallel() {

        int size = 1000000;

        //given
        ArrayList<Integer> integers = DataSet.generateArrayList(size);

        //when
        List<Integer> res = arrayListSpliteratorExample.inputListmultiplyEachValue(integers, 2, true);

        //then

        assertEquals(size, res.size());

    }
}