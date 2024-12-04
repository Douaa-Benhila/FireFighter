package model;

import Movable.Fire;
import Movable.Update;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class MotorizedFirefighterUpdate implements Update {
    private model.TargetStrategy targetStrategy;
    private FirefighterBoard firefighterBoard;

    public MotorizedFirefighterUpdate(FirefighterBoard firefighterBoard) {
        targetStrategy = new model.TargetStrategy();
        this.firefighterBoard = firefighterBoard;
    }

    @Override
    public void influence(BoardElement element) {
        List<Position> firefighterNewPositions = new ArrayList<>();
        for (Position firefighterPosition : element.getPosition()) {
            Position newFirefighterPosition = targetStrategy.neighborClosestToFire(
                    firefighterPosition,
                    getFirePositions(),
                    firefighterBoard.getNeighbors()
            );

            firefighterNewPositions.add(newFirefighterPosition);

            extinguish(newFirefighterPosition);

            List<Position> neighborFirePositions = firefighterBoard.getNeighbors()
                    .get(newFirefighterPosition)
                    .stream()
                    .filter(getFirePositions()::contains)
                    .toList();
            for (Position firePosition : neighborFirePositions) {
                extinguish(firePosition);
            }
        }

        element.getPosition().clear();
        element.getPosition().addAll(firefighterNewPositions);
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
