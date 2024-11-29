package model;

import util.Position;

import java.util.List;

public class FirefighterUpdate implements Update{
    private model.TargetStrategy targetStrategy;

    public FirefighterUpdate() {targetStrategy = new model.TargetStrategy();}

    @Override
    public void influence(BoardElement element) {

    }
}
