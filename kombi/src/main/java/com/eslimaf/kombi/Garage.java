package com.eslimaf.kombi;

import java.util.HashMap;

/**
 * The type Garage.
 */
public class Garage {
    private static Garage sInstance;
    private HashMap<String, RxKombi> mInstanceMap = new HashMap<>();

    private Garage() {
    }

    /**
     * Get instance.
     *
     * @return the instance of Garage
     */
    public static synchronized Garage getInstance() {
        if (sInstance == null) {
            sInstance = new Garage();
        }
        return sInstance;
    }

    /**
     * Ride kombi rx kombi.
     *
     * @param <T>          the type parameter
     * @param licensePlate identify the bus
     * @return the rx kombi
     */
    @SuppressWarnings("unchecked")
    public <T> RxKombi<T> rideKombi(String licensePlate) {
        if (!mInstanceMap.containsKey(licensePlate)) {
            mInstanceMap.put(licensePlate, RxKombi.create());
        }

        if (mInstanceMap.get(licensePlate) != null) {
            return mInstanceMap.get(licensePlate);
        } else {
            throw new RuntimeException("License plate not found");
        }
    }

    /**
     * Remove a kombi from the garage.
     *
     * @param licensePlate the license plate
     */
    public void sellKombi(String licensePlate) {
        mInstanceMap.remove(licensePlate);
    }

    /**
     * Clear the garage removing all kombis.
     */
    public void clearGarage() {
        mInstanceMap.clear();
    }
}
