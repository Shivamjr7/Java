package com.shivam.java.javapractices.parallelstreams;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parallelstreams.ParallelStreamsExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamsTest {

    ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();

    @Test
    void testStringTransform() {
        //given
        List<String> names = new ArrayList<>(Arrays.asList("Shivam", "Asif", "Messi", "Ronaldo"));

        //when
        List<String> result = parallelStreamsExample.stringTransformInParallel(names);
        Assertions.assertEquals(4, result.size());

        result.forEach(name -> {
                    assert (name.contains("-"));
                }
        );

    }

    @Test
    public void testStringTransformForSeqAndParallel(boolean isParallel) {
        //given
        List<String> names = new ArrayList<>(Arrays.asList("Shivam", "Asif", "Messi", "Ronaldo"));

        //when
        List<String> result = parallelStreamsExample.stringTransformInSequentialAndParallel(names, isParallel);
        Assertions.assertEquals(4, result.size());

        result.forEach(name -> {
                    assert (name.contains("-"));
                }
        );

    }


}
