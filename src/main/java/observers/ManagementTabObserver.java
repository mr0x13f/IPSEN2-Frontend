package main.java.observers;

import main.java.models.Vehicle;
import main.java.observables.VehicleObservable;

public interface ManagementTabObserver {

    void update(VehicleObservable ro);
}
