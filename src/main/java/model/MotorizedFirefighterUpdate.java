package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class MotorizedFirefighterUpdate implements Update{
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
                    Fire.getFirePositions(),
                    firefighterBoard.getNeighbors()
            );

            firefighterNewPositions.add(newFirefighterPosition);

            extinguish(newFirefighterPosition);

            List<Position> neighborFirePositions = firefighterBoard.getNeighbors()
                    .get(newFirefighterPosition)
                    .stream()
                    .filter(Fire.getFirePositions()::contains)
                    .toList();
            for (Position firePosition : neighborFirePositions) {
                extinguish(firePosition);
            }
        }

        element.getPosition().clear();
        element.getPosition().addAll(firefighterNewPositions);
    }

    private void extinguish(Position position) {
        Fire.getFirePositions().remove(position);
    }
}
