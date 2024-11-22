package model;

import java.util.List;

public class FireFactory implements BoardElementFactory{
    private int initialNumber;
    private Update update;

    public FireFactory(int initialNumber, Update update ){
        this.initialNumber=initialNumber;
        this.update=update;
    }

    @Override
    public int getInitialNumber() {return 0;}

    @Override
    public List<BoardElement> createElements(int rowCount, int columnCount) {return null;}
}

