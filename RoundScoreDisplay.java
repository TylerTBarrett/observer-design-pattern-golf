/**
 * Display observer for the total Round Score of golf
 * @author Tyler Barrett
 * 
 */

public class RoundScoreDisplay implements Observer {
    private Subject golfer;
    private int strokesTotal;
    private int parTotal;

    /**
     * Constructs a Display and registers the display for updates from the Golfer class
     * @param golfer inputted Subject will be used to assign a value to the current golfer
     */
    public RoundScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        this.golfer.registerObserver(this);
    }

    /**
     * Updates the strokesTotal and parTotal values, then prints out those values
     * @param strokes Integer value indicating strokes taken on the hole
     * @param par Integer value indicating strokes for par on a hole
     */
    public void update(int strokes, int par) {
        this.strokesTotal += strokes;
        this.parTotal += par;
        DisplayCurrentScore();
    }

    /**
     * Will print out the total stats for the round, including
     * the total strokes and total par
     */
    private void DisplayCurrentScore() {
        System.out.println("\nRound Stats:\nPar: " + parTotal +
            "\nStrokes: " + strokesTotal);
        int parTotalDeterminant = strokesTotal - parTotal;
        if(parTotalDeterminant == 0) {
            System.out.println("Making Par");
        } else if(parTotalDeterminant < 0) {
            int output = Math.abs(parTotalDeterminant);
            System.out.println(output + " under par");
        } else {
            System.out.println(parTotalDeterminant + " over par");
        }
    }
}
