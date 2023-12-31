package rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class OperatorsExample {

    public static void main(String[] args) {


        Observable<String> observable = Observable.just("Shivam", "Asif", "Abhinav", "Gaurav");
        //filter operator
        observable.
                filter(name -> name.startsWith("S"))
                .subscribe(System.out::println); //op - Shivam

        System.out.println("-------------");

        // take operator specifies how many items to emit
        observable.take(2)
                .subscribe(System.out::println); //op - Shivam , Asif

        System.out.println("-------------");

        //skip operator - skips the no of items to emit
        observable.skip(2)
                .subscribe(System.out::println); //op - Abhinav , Gaurav


        System.out.println("-------------");

        //take while :as soon as condition is broken , rest items are not emitted

        observable.takeWhile(name -> name.length()>4)
                .subscribe(System.out::println);

        // distinct

        System.out.println("-------------");
        Observable<Integer> integerObservable = Observable.fromIterable(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,7)));
        integerObservable
                .distinct()
                .subscribe(System.out::println);

        observable.distinct(String::length)
                .subscribe(System.out::println);

        System.out.println("-------------");
        //element At
        observable.elementAt(4)
                .subscribe(System.out::println);

        System.out.println("-------------");
        //map
        //same as in java8.streams, to convert from one form to another
        observable.map(String::toUpperCase)
                .subscribe(System.out::println);

        //cast and startwith
       observable.cast(Object.class);

        System.out.println("-------------");
       //default if empty
        Observable.empty().defaultIfEmpty("Shrikant").subscribe(System.out::println);
        Observable.empty().switchIfEmpty(observable).subscribe(System.out::println);


        //sorted
        observable.sorted().subscribe(System.out::println);

        //repeat and scan
        // repeat to emit the elements again
        observable.repeat(2).subscribe(System.out::println);

        //reduce : to reduce to single value
        observable.reduce((a,b)-> a+":"+b)
                .subscribe(System.out::println);

        //all and any : will return true if all or any condition is met
        observable.all(name -> name.length()>1)
                .subscribe(System.out::println);

        //contains - returns true or false
        observable.contains("Shivam")
                .subscribe(System.out::println);


        //to convert items to list or map
        observable.toSortedList()
                .subscribe(System.out::println);


        observable.collect(HashSet::new, HashSet::add)
                .subscribe(System.out::println);
    }
}
