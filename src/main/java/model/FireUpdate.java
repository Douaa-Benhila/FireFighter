package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class FireUpdate implements Update{
    private FirefighterBoard firefighterBoard;
    public FireUpdate(FirefighterBoard firefighterBoard){
        this.firefighterBoard = firefighterBoard;
    }
    public void influence(BoardElement element){
        List<Position> newFirePositions = new ArrayList<>();
        for (Position fire : element.getPosition()){
            newFirePositions.addAll(firefighterBoard.getNeighbors().get(fire));
        }
        element.getPosition().addAll(newFirePositions);
    }
}
