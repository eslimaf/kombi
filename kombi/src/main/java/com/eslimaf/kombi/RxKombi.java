package com.eslimaf.kombi;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * The type Kombi with a PublishSubject.
 *
 * @param <T> the type parameter
 */
public class RxKombi<T> {
    private PublishSubject<T> mBus = PublishSubject.create();
    private String mLicensePlate;

    public RxKombi(String licensePlate) {
        mLicensePlate = licensePlate;
    }

    /**
     * Create rx kombi.
     *
     * @param <T> the type parameter
     * @return the rx kombi
     */
    public static <T> RxKombi<T> create() {
        return new RxKombi<>("");
    }

    /**
     * Send.
     *
     * @param t the t
     */
    public void send(T t) {
        mBus.onNext(t);
    }

    /**
     * To observable observable.
     *
     * @return the observable
     */
    public Observable<T> toObservable() {
        return mBus;
    }

    /**
     * Has observers boolean.
     *
     * @return the boolean
     */
    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    /**
     * Gets license plate.
     *
     * @return the license plate
     */
    public String getLicensePlate() {
        return mLicensePlate;
    }
}
