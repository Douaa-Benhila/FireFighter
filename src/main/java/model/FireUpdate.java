package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class FireUpdate implements Update{
    public FireUpdate(){}
    public void influence(BoardElement element){
        List<Position> newFirePositions = new ArrayList<>();
        for (Position fire : element.getPosition()){
            newFirePositions.addAll(fire.getNeighbors(fire));
        }
        element.getPosition().addAll(newFirePositions);
    }
}
