package rxjava;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Ambiguous {

    public static void main(String[] args) {

        //When we have multiple observable and want to get the data from the fastest one


        Observable<Long> observable1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS);


        Observable.ambArray(observable1,observable2)
                .subscribe(System.out::println);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
