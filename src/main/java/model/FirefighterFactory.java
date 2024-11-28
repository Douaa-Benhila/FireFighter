package model;

import java.util.List;

public class FirefighterFactory implements BoardElementFactory{
    private int initialNumber;
    private Update update;

    public FirefighterFactory(int initialNumber, Update update) {
        this.initialNumber = initialNumber;
        this.update = update;
    }

    @Override
    public int getInitialNumber() {
        return initialNumber;
    }

    @Override
    public BoardElement createElements(int rowCount, int columnCount) {
        return new Firefighter(update, initialNumber);
    }
}
