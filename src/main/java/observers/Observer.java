package observers;

import observables.Observable;

public interface Observer {
    void update(Observable observable);
}
