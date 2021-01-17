/**
 * Display for statistics on the current hole
 * @author Tyler Barrett
 * 
 */

public class HoleScoreDisplay implements Observer {
    private Subject golfer;
    private int strokes;
    private int par;

    /**
     * Constructs a new HolScoreDisplay observer and registers that observer to
     * receive updates from Golfer
     * @param golfer The golfer that will be used to assign a name value for this observer
     */
    public HoleScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        this.golfer.registerObserver(this);
    }

    /**
     * Will print out updates for the current hole based on inputted strokes and par
     * @param strokes The amount of strokes the golfer took for the current hole
     * @param par The amount of strokes for par for that hole
     */
    public void update(int strokes, int par) {
        this.strokes = strokes;
        this.par = par;
        displayCurrentScore();
    }

    /**
     * Will print out the current hole par and strokes taken
     */
    private void displayCurrentScore() {
        System.out.println("\nCurrent Hole stats\nPar: " + par + "\n" + 
            "Strokes: " + strokes);
        int parDeterminant = strokes - par;
        if(parDeterminant == 0) {
            System.out.println("Made par");
        } else if(parDeterminant < 0) {
            int output = Math.abs(parDeterminant);
            System.out.println(output + " under par");
        } else {
            System.out.println(parDeterminant + " over par");
        }
    }
}
