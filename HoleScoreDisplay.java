public class HoleScoreDisplay implements Observer {
    private Subject golfer;
    private int strokes;
    private int par;

    public HoleScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        this.golfer.registerObserver(this);
    }

    public void update(int strokes, int par) {
        this.strokes = strokes;
        this.par = par;
        displayCurrentScore();
    }

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
