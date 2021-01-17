/**
 * A virtual representation of a golfer
 * @author Tyler Barrett
 * 
 */

import java.util.ArrayList;

public class Golfer implements Subject{

    /**
     * Array List to store all current observers
     */
    private ArrayList<Observer> observers;
    private String name;

    /**
     * Constructs a golfer and Observer array list based on inputted name
     * @param String Will be used to assign a name for the golfer
     */
    public Golfer(String name) {
        if(name != null) {
            this.name = name;
        observers = new ArrayList<Observer>();
        }
    }

    /**
     * Adds an observer to the observers arraylist for notifications on updates
     * @param observer The observer to be added to the arraylist
     */
    public void registerObserver(Observer observer) {
        if(observer != null) {
            this.observers.add(observer);
        }
    }

    /**
     * Will remove an observer from the observers arraylist so they will no longer 
     * receive notifications on updates
     * @param observer The obvserver to be removed from the arraylist
     */
    public void removeObserver(Observer observer) {
        if(observer != null) {
            this.observers.remove(observer);
        }
    }

    /**
     * Will update the observers in the arraylist observers, giving them the 
     * value for both par and strokes
     * @param strokes The number of strokes the golfer took on the hole
     * @param par The number of strokes to match par for the hole
     */
    public void notifyObservers(int strokes, int par) {
        for(Observer observer : observers) {
            observer.update(strokes, par);
        }
    }

    /**
     * Allows a score to be entered for the hole, will notify the observers
     * @param strokes The number of strokes taken on the hole
     * @param par The number of strokes needed for par on the hole
     */
    public void enterScore(int strokes, int par) {
        notifyObservers(strokes, par);
    }

    /**
     * Will return the golfer's name
     * @return A String that will include the name of the golfer
     */
    public String getName() {
        return this.name;
    }
}
