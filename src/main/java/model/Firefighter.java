package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Firefighter implements BoardElement, PositionControl{
    private List<Position> positions;
    private Update update;

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
