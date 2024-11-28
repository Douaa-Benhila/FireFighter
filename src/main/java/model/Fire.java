package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Fire implements BoardElement ,PositionControl {
    private List<Position> positions;
    private Update update;
    private FirefighterBoard  firefighterBoard;

    public Fire(int initialFireCount, Update update , FirefighterBoard firefighterBoard) {
        positions = new ArrayList<>();
        for (int index = 0; index < initialFireCount; index++)
            positions.add(positions.get(index).randomPosition());

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
            update.influence(this);

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


