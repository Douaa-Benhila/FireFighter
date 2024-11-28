package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Firefighter implements BoardElement, PositionControl{
    private List<Position> positions;
    private Update update;
    private final model.TargetStrategy targetStrategy = new model.TargetStrategy();

    public Firefighter(Update update, int initialFirefighterCount) {
        positions = new ArrayList<>();
        for (int index = 0; index < initialFirefighterCount; index++)
            positions.add(positions.get(index).randomPosition());

        this.update = update;
    }

    @Override
    public List<Position> getPosition() {
        return positions;
    }

    @Override
    public void update() {
        for (Position firefighterPosition : positions) {
            Position newFirefighterPosition =
                    targetStrategy.neighborClosestToFire(firefighterPosition,
                            positions, firefighterPosition.getNeighbors());
            extinguish(newFirefighterPosition);
            positions.add(newFirefighterPosition);
            List<Position> neighborFirePositions = newFirefighterPosition.getNeighbors().get(newFirefighterPosition).stream()
                    .filter(positions::contains).toList();
            for (Position firePosition : neighborFirePositions)
                extinguish(firePosition);
            positions.addAll(neighborFirePositions);
        }
    }

    private void extinguish(Position position) {
        positions.remove(position);
    }

    public Update getUpdate() {return update;}

    @Override
    public void deletePosition(Position position) {
        positions.remove(position);
    }

    @Override
    public void addPosition(Position position) {
        positions.add(position);
    }
}
