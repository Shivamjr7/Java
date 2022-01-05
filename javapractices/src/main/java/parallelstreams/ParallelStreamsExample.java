package parallelstreams;

import util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.CommonUtil.stopWatch;
import static util.CommonUtil.timeTaken;

public class ParallelStreamsExample {


    public List<String> stringTransformInSequential(List<String> names) {
        return names.
                stream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }


    public List<String> stringTransformInSequentialAndParallel(List<String> names, boolean isParallel) {
        Stream<String> stream = names.
                stream();

        //this will run the stream in parallel threads based on flag
        if (isParallel)
            stream.parallel();

        return
                stream
                        .map(this::addNameLengthTransform)
                        .collect(Collectors.toList());
    }

    public List<String> stringTransformInParallel(List<String> names) {
        return names.
                parallelStream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    private String addNameLengthTransform(String name) {
        CommonUtil.delay(500);
        return name.length() + " - " + name;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Sancho", "Ronaldo", "Alex", "Shaw"));

        System.out.println("Transforming string in sequential stream....");

        stopWatch.start();
        List<String> sequentialResult = new ParallelStreamsExample().stringTransformInSequential(names);
        System.out.println(sequentialResult);
        timeTaken();

        stopWatch.reset();
        System.out.println("----------------------------------------------");
        System.out.println("Transforming string in parallel stream....");
        stopWatch.start();
        List<String> parallelResult = new ParallelStreamsExample().stringTransformInParallel(names);
        System.out.println(parallelResult);
        timeTaken();
        System.out.println("----------------------------------------------");


    }
}
