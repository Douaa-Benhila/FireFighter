package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class MountainImpact implements Impact{
    private FirefighterBoard firefighterBoard;

    public MountainImpact(FirefighterBoard firefighterBoard) {
        this.firefighterBoard = firefighterBoard;
    }
    @Override
    public void impact() {
        List<Position> toRemove = new ArrayList<>();

        for (List<Position> positions : firefighterBoard.getNeighbors().values()) {
            for (Position position2 : positions) {
                if (getMountainPositions().contains(position2)) {
                    toRemove.add(position2);
                }
            }
        }

        for (Position position : toRemove) {
            firefighterBoard.getNeighbors().values().forEach(positions -> positions.remove(position));
        }
    }

    private List<Position> getMountainPositions(){
        for (BoardElement element:firefighterBoard.getElements()){
            if (element instanceof Mountain){return element.getPosition();}
        }
        return new ArrayList<>();
    }


}
