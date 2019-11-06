package models;

import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import observables.Observable;
import observers.Observer;
import services.GsonService;
import services.HTTPRequestService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JourneyList implements Observable {

    public ObservableList<Journey> journeys;

    private static ArrayList<Observer> observers = new ArrayList<>();

    public JourneyList() {
        getJourneysFromDataBase();
    }

    public ObservableList<Journey> getJourneys() {
        return journeys;
    }

    public void addJourney(Journey journey){
        journeys.add(journey);
        System.out.println(journeys.size());
        notifyObservers();
    }

    public void getJourneysFromDataBase() {
        journeys = FXCollections.observableArrayList();
        String jsonJourneys = HTTPRequestService.getJourneys("nigerfagoot@gmail.com:wachtwoord");
        Type type = new TypeToken<Journey[]>() {}.getType();
        Journey[] jList = (Journey[]) GsonService.fromJson(jsonJourneys, type);
        journeys.addAll(jList);
    }

    @Override
    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        System.out.println("notify");
        for (Observer o : observers) {
            o.update(this);
        }
    }

}
