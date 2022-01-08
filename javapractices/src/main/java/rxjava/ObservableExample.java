package rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ObservableExample {

    public static void main(String[] args) {


        //Observable emits data , create method to create observable
        Observable<String> observable = Observable.create(emitter -> {
           try {
               emitter.onNext("Shivam");
               emitter.onNext("Abhinav");
               emitter.onNext("Asif");
               emitter.onComplete();
           }
           catch(Exception e)
           {
               emitter.onError(e);
           }
        });

        //2nd method to create
        Observable<String> observable1 = Observable.just("Ronaldo","Sancho","Baily");

        //3rd method , will create cold observable
        Observable<String> observable2 = Observable.fromIterable(new ArrayList<>
                (Arrays.asList("1","2","3")));

        observable2.subscribe(System.out::println);


        //creating a hot observable , will emit data simultaneously for all observers
        ConnectableObservable hotObservable = observable.publish();
        hotObservable.connect();



    }
}
