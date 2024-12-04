package model;

import Movable.Update;

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
    public BoardElement createElements() {
        return new Firefighter(update, initialNumber,firefighterBoard);
    }
}
