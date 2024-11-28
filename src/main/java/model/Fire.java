package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Fire implements BoardElement ,PositionControl {
    private List<Position> positions;
    private Update update;

    public Fire(List<Position> positions, Update update) {
        this.positions = positions;
        this.update = update;
    }

    @Override
    public List<Position> getPosition() {
        return positions;
    }
    @Override
    public void update() {
        List<Position> modifiedPositions = new ArrayList<>();
        int step = 0;

        if (step % 2 == 0) {
            List<Position> newFirePositions = new ArrayList<>();
            Position[] firePositions;
            for (Position fire : firePositions) {
                newFirePositions.addAll(neighbors.get(fire));
            }
            firePositions.addAll(newFirePositions);
            modifiedPositions.addAll(newFirePositions);
        }
       ;

    }

    @Override
    public Update getUpdate() {
        return null;
    }

    @Override
    public void deletePosition(Position position) {
        positions.remove(position);
    }

    @Override
    public void addPosition(Position position) {
        positions.add(position);
    }
}


