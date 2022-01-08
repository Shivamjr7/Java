package rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class ObservableFactories {

    public static void main(String[] args) {

        //the below observable will emit  int starting from 0 at an interval defined(200 ms)
        Observable.interval(200, TimeUnit.MILLISECONDS).subscribe(System.out::println);

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        // will emit a range of values
        Observable.range(1,10).subscribe((i)->{
            System.out.println("Range Factory :"+i +" and thread : "+Thread.currentThread().getName());
        });


        //empty factory
        Observable.empty().subscribe(i->{
            System.out.println("Empty Factory" +i);
        });


        //Error Factory
        Observable.error(new Exception("Error Factory..")).subscribe(System.out::println,Throwable::printStackTrace,System.out::println);


        //to stop or dispose the observer
        Disposable disposable = Observable.interval(100,TimeUnit.MILLISECONDS).subscribe(System.out::println);
        disposable.dispose();
    }
}
