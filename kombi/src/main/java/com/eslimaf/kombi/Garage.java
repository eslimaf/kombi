package com.eslimaf.kombi;

import java.util.HashMap;

public class Garage {
    private static Garage sInstance;
    private HashMap<String, RxKombi> mInstanceMap = new HashMap<>();

    private Garage() {
    }

    public static synchronized Garage getsInstance() {
        if (sInstance == null) {
            sInstance = new Garage();
        }
        return sInstance;
    }

    public <T> RxKombi<T> rideKombi(String licensePlate) {
        if (!mInstanceMap.containsKey(licensePlate)) {
            mInstanceMap.put(licensePlate, RxKombi.create());
        }
        return mInstanceMap.get(licensePlate);
    }

    public void sellKombi(String licensePlate) {
        mInstanceMap.remove(licensePlate);
    }

    public void clearGarage() {
        mInstanceMap.clear();
    }
}
