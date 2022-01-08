package rxjava;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import util.CommonUtil;

public class SchedulersExample {

    public static void main(String[] args) {


        Observable<Integer> observable = Observable.just(1, 2)
                .map(i -> {
                    System.out.println("map func1 Thread running on " + Thread.currentThread().getName());
                    return i * 1;
                })
                .subscribeOn(Schedulers.computation());


        observable.observeOn(Schedulers.io()).subscribe(i -> {
            System.out.println("Observer onNext running on" + Thread.currentThread().getName());
        });


        CommonUtil.delay(5000);

    }
}
