package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Fire implements BoardElement ,PositionControl {
    private List<Position> positions;
    private Update update;
    private FirefighterBoard  firefighterBoard;

    public Fire(List<Position> positions, Update update , FirefighterBoard firefighterBoard) {
        this.positions = positions;
        this.update = update;
        this.firefighterBoard = firefighterBoard;
    }

    @Override
    public List<Position> getPosition() {
        return positions;
    }
    @Override
    public void update() {
        if (firefighterBoard.getStep() % 2 == 0) {
            List<Position> newFirePositions = new ArrayList<>();
            for (Position fire : positions) {
                newFirePositions.addAll(fire.getNeighbors().get(fire));
            }
            positions.addAll(newFirePositions);

        }


    }

    @Override
    public Update getUpdate() {
        return update;
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


