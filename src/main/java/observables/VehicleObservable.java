package observables;

import observers.ManagementTabObserver;

public interface VehicleObservable {

    /**
     * @param mto registers an observer to the observable
     */
    void register(ManagementTabObserver mto);

    /**
     * Notifies an observer
     */
    void notifyObservers();

    /**
     * @return an String of the current car type.
     */

    String getType();

    String getLicensePlate();
}
