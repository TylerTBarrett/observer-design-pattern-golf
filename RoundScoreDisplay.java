public class RoundScoreDisplay implements Observer {
    private Subject golfer;
    private int strokesTotal;
    private int parTotal;

    public RoundScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        this.golfer.registerObserver(this);
    }

    public void update(int strokes, int par) {
        this.strokesTotal += strokes;
        this.parTotal += par;
        DisplayCurrentScore();
    }

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
