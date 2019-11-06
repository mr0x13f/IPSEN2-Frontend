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

    //private ArrayList<Observer> observers;
    private List<Observer> observers = new ArrayList<Observer>();

    public JourneyList() {
        journeys = FXCollections.observableArrayList();
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

    public void fillList(Journey[] jList) {
        for(Journey j : jList) {
            journeys.add(j);
        }
    }

    public void getJourneysFromDataBase() {
        String jsonJourneys = HTTPRequestService.getJourneys("nigerfagoot@gmail.com:wachtwoord");
        Type type = new TypeToken<Journey[]>() {}.getType();
        Journey[] jList = (Journey[]) GsonService.fromJson(jsonJourneys, type);
        fillList(jList);
    }

    @Override
    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {

    }

    public void notifyObservers(){
        for (int i = 0; i< observers.size(); i++){
            observers.get(i).update(this);
        }
    }

}
