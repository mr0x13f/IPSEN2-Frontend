package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import observables.Observable;
import observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class JourneyList implements Observable {

    public ObservableList<Journey> journeys = FXCollections.observableArrayList();

    //private ArrayList<Observer> observers;
    private List<Observer> observers = new ArrayList<Observer>();


    public ObservableList<Journey> getJourneys() {
        return journeys;
    }

    public void addJourney(Journey journey){
        journeys.add(journey);
        System.out.println(journeys.size());
        notifyObservers();
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
