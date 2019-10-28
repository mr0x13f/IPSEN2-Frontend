package main.java.observers;

import main.java.models.VehicleModel;
import main.java.observables.VehicleObservable;

public interface ManagementTabObserver {

    void update(VehicleObservable ro);
}
