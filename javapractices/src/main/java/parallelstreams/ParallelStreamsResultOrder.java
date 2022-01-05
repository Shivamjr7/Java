package parallelstreams;

import util.CommonUtil;
import util.LoggerUtil;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreamsResultOrder {


    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(1,2,3,4,5));

        List<Integer> resultIntegers = listOrder(integers);
        Set<Integer> resultset = setOrder(integerSet);

        LoggerUtil.log("list:" +integers);
        LoggerUtil.log("result:" +resultIntegers);

        LoggerUtil.log("set :" +integerSet);
        LoggerUtil.log("result :" +resultset);


    }

    public static List<Integer> listOrder(List<Integer> integers)
    {

        return integers.parallelStream().map(integer -> integer * 2).collect(Collectors.toList());

    }

    public static  Set<Integer> setOrder(Set<Integer> integers)
    {

        return integers.parallelStream().map(integer -> integer * 2).collect(Collectors.toSet());

    }



}


