package model;

import java.util.List;

public class FirefighterFactory implements BoardElementFactory{
    private int initialNumber;
    private Update update;
    private FirefighterBoard firefighterBoard;

    public FirefighterFactory(int initialNumber, Update update, FirefighterBoard firefighterBoard) {
        this.initialNumber = initialNumber;
        this.update = update;
        this.firefighterBoard = firefighterBoard;
    }

    @Override
    public int getInitialNumber() {
        return initialNumber;
    }

    @Override
    public BoardElement createElements(int rowCount, int columnCount) {
        return new Firefighter(update, initialNumber,firefighterBoard);
    }
}
