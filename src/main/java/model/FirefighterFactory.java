package model;

import java.util.List;

public class FirefighterFactory implements BoardElementFactory{
    private int initialNumber;
    private Update update;

    public FirefighterFactory(int initialNumber, Update update) {}

    @Override
    public int getInitialNumber() {
        return 0;
    }

    @Override
    public List<BoardElement> createElements(int rowCount, int columnCount) {
        return null;
    }
}
