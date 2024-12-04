package Motionless;

import model.BoardElement;
import model.BoardElementFactory;
import model.FirefighterBoard;

public class RockeryFactory implements BoardElementFactory {
    private int initialNumber;
    private Impact impact;
    private FirefighterBoard firefighterBoard;

    public RockeryFactory(int initialNumber, Impact impact, FirefighterBoard firefighterBoard) {
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
        return new Rockery(impact, initialNumber, firefighterBoard);
    }
}
