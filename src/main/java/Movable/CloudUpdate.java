package Movable;

import model.BoardElement;
import model.FirefighterBoard;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class CloudUpdate implements Update {
    private model.TargetStrategy targetStrategy;
    private FirefighterBoard firefighterBoard;

    public CloudUpdate(FirefighterBoard firefighterBoard) {
        targetStrategy = new model.TargetStrategy();
        this.firefighterBoard = firefighterBoard;
    }
    @Override
    public void influence(BoardElement element) {
        List<Position> newCloudPositions = new ArrayList<>();
        for (Position cloudPosition : element.getPosition()) {
            Position newCloudPosition = firefighterBoard.randomPosition();
            newCloudPositions.add(newCloudPosition);
            extinguish(newCloudPosition);
            List<Position> neighborFirePositions = firefighterBoard.getNeighbors()
                    .get(newCloudPosition)
                    .stream()
                    .filter(getFirePositions()::contains)
                    .toList();
            for (Position firePosition : neighborFirePositions) {
                extinguish(firePosition);
            }
        }
        element.getPosition().clear();
        element.getPosition().addAll(newCloudPositions);
    }

    private List<Position> getFirePositions(){
        for (BoardElement element:firefighterBoard.getElements()){
            if(element instanceof Fire) return element.getPosition();
        }
        return null;
    }

    private void extinguish(Position position) {
        getFirePositions().remove(position);
    }




}
