/**
 * A virtual representation of a golfer
 * @author Tyler Barrett
 * 
 */

import java.util.ArrayList;

public class Golfer {
    private ArrayList<Observer> observers;
    private String name;

    public Golfer(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    public void registerObserver(Observer observer) {
        if(observer != null) {
            this.observers.add(observer);
        }
    }

    public void removeObservera(Observer observer) {
        if(observer != null) {
            this.observers.remove(observer);
        }
    }

    public void notifyObservers(int strokes, int par) {
        for(Observer observer : observers) {
            observer.update(strokes, par);
        }
    }

    public void enterScore(int strokes, int par) {
        notifyObservers(strokes, par);
    }

    public String getName() {
        return this.name;
    }

}
