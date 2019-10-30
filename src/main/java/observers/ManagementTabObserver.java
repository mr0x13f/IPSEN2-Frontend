package observers;

import models.Vehicle;
import observables.VehicleObservable;

public interface ManagementTabObserver {

    void update(VehicleObservable ro);
}
