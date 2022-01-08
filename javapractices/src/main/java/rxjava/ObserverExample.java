package rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObserverExample {

    public static void main(String[] args) {

        //Observer emits data , so is the source of data
        Observable<String> observable = Observable.just("A","B","C");

        //observer subscribes to the observable and receives the data
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("On_Next :"+s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Data emission completed");
            }
        };


        observable.subscribe(observer);



        Observable<String> observable1 = Observable.just("E","F","G");
        //first lambda or arg is onNext , second onError and last onComplete
        observable1.subscribe(System.out::println,Throwable::printStackTrace,()->System.out.println("Data emission completed"));

    }
}
