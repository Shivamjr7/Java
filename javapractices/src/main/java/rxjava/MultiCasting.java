package rxjava;

import io.reactivex.rxjava3.core.Observable;

public class MultiCasting {

    public static void main(String[] args) {


        //use autoconnect only if you know the number of observers
        Observable<Integer> observable = Observable.just(1,2,3).publish().autoConnect(2);

        //Now both observers/subscribers will receive data at the same time
        observable.subscribe((i)->{
            System.out.println("Subscriber-1-"+i);
        });


        observable.subscribe((i)->{
            System.out.println("Subscriber-2-"+i);
        });

    }

}
