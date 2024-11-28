package model;

import util.Position;

import java.util.List;

public class FirefighterUpdate implements Update{
    private model.TargetStrategy targetStrategy=new model.TargetStrategy();

    public FirefighterUpdate() {}

    @Override
    public void influence(BoardElement element) {

    }
}
