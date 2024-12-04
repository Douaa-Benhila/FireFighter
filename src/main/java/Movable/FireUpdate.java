package Movable;

import model.BoardElement;
import model.FirefighterBoard;
import util.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FireUpdate implements Update {
    private FirefighterBoard firefighterBoard;
    public FireUpdate(FirefighterBoard firefighterBoard){
        this.firefighterBoard = firefighterBoard;
    }

    public void influence(BoardElement element) {
        Set<Position> newFirePositions = new HashSet<>();
        for (Position fire : element.getPosition()) {
            newFirePositions.addAll(firefighterBoard.getNeighbors().getOrDefault(fire, List.of()));
        }

        element.getPosition().addAll(newFirePositions.stream()
                .filter(pos -> !getFirePositions().contains(pos))
                .toList());
    }

    private List<Position> getFirePositions(){
        for (BoardElement element:firefighterBoard.getElements()){
            if(element instanceof Fire) return element.getPosition();
        }
        return null;
    }

}
