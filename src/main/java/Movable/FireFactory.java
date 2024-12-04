package Movable;

import model.BoardElement;
import model.BoardElementFactory;
import model.FirefighterBoard;

public class FireFactory implements BoardElementFactory {
    private int initialNumber;
    private Update update;
    private FirefighterBoard firefighterBoard;

    public FireFactory(int initialNumber, Update update, FirefighterBoard firefighterBoard ){
        this.initialNumber=initialNumber;
        this.update=update;
        this.firefighterBoard=firefighterBoard;
    }

    @Override
    public int getInitialNumber() {return initialNumber;}
    @Override
    public BoardElement createElements() {return new Fire(initialNumber,update,firefighterBoard);}
}

