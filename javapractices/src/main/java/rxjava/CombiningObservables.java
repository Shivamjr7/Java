package rxjava;

import io.reactivex.rxjava3.core.Observable;

public class CombiningObservables {


    public static void main(String[] args) {

        Observable<String> observable1 = Observable.just("a","b","c");
        Observable<String> observable2 = Observable.just("d","e","f");

        //merge doesn't guarantee the order
        observable1.mergeWith(observable2).subscribe(System.out::println);
        Observable.merge(observable1,observable2).subscribe(System.out::println);

        //concat guarantees the order
        Observable.concat(observable1,observable2).subscribe(System.out::println);
        observable1.concatWith(observable2).subscribe(System.out::println);

        //flatmap

        Observable<String> observable = Observable.just("Hello","World");
        observable.flatMap(s->Observable.fromArray(s.split(""))).
                subscribe(System.out::println);
    }
}
