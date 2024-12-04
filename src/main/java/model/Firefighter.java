package model;

import Movable.Fire;
import Movable.Update;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Firefighter implements BoardElement{
    private List<Position> positions;
    private FirefighterBoard firefighterBoard;
    private Update update;
    private final model.TargetStrategy targetStrategy = new model.TargetStrategy();

    public Firefighter(Update update, int initialFirefighterCount, FirefighterBoard firefighterBoard) {
        positions = new ArrayList<>();
        for (int index = 0; index < initialFirefighterCount; index++)
            positions.add(firefighterBoard.randomPosition());

        this.firefighterBoard = firefighterBoard;
        this.update = update;
    }

    @Override
    public List<Position> getPosition() {
        return positions;
    }

    @Override
    public void update() {
        List<Position> firefighterNewPositions = new ArrayList<>();
        for (Position firefighterPosition : positions) {
            Position newFirefighterPosition = targetStrategy.neighborClosestToFire(firefighterPosition,
                    getFirePositions(), firefighterBoard.getNeighbors());
            firefighterNewPositions.add(newFirefighterPosition);
            extinguish(newFirefighterPosition);
            List<Position> neighborFirePositions = firefighterBoard.getNeighbors().get(newFirefighterPosition).stream()
                    .filter(getFirePositions()::contains).toList();
            for (Position firePosition : neighborFirePositions)
                extinguish(firePosition);
        }
        positions.clear();
        positions.addAll(firefighterNewPositions);
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

    public Update getUpdate() {return update;}


}
