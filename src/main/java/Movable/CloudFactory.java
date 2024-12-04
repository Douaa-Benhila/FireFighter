package Movable;

import model.BoardElement;
import model.BoardElementFactory;
import model.FirefighterBoard;

public class CloudFactory implements BoardElementFactory {
    private int initialNumber;
    private FirefighterBoard firefighterBoard;
    private Update update;

    public CloudFactory(int initialNumber, Update update, FirefighterBoard firefighterBoard) {
        this.initialNumber = initialNumber;
        this.firefighterBoard = firefighterBoard;
        this.update = update;
    }
    @Override
    public int getInitialNumber() {
        return initialNumber;
    }

    @Override
    public BoardElement createElements() {
        return new Cloud(firefighterBoard, update, initialNumber);
    }
}
