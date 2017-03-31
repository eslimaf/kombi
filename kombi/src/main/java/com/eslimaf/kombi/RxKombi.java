package com.eslimaf.kombi;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxKombi<T> {
    private PublishSubject<T> mBus = PublishSubject.create();

    private RxKombi() {
        //Avoid new instance
    }

    public static <T> RxKombi<T> create() {
        return new RxKombi<>();
    }

    public void send(T t) {
        mBus.onNext(t);
    }

    public Observable<T> toObservable() {
        return mBus;
    }

    public boolean hasObservers() {
        return mBus.hasObservers();
    }
}
