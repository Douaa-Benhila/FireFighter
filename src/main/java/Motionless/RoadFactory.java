package Motionless;

import model.BoardElement;
import model.BoardElementFactory;
import model.FirefighterBoard;

public class RoadFactory implements BoardElementFactory {
    private int initialNumber;
    private Impact impact;
    private FirefighterBoard firefighterBoard;
    public RoadFactory(int initialNumber, Impact impact, FirefighterBoard firefighterBoard) {
        this.initialNumber = initialNumber;
        this.impact = impact;
        this.firefighterBoard = firefighterBoard;
    }
    @Override
    public int getInitialNumber() {
        return initialNumber;
    }

    @Override
    public BoardElement createElements() {
        return new Road(impact, initialNumber, firefighterBoard);
    }

}
