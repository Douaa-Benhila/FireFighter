package model;

import util.Position;

import java.util.List;

public class Firefighter implements BoardElement, PositionControl{
    private List<Position> positions;
    private Update update;

    public Firefighter(List<Position> positions, Update update) {}

    public List<Position> getPositions() {return null;}

    @Override
    public List<Position> getPosition() {
        return null;
    }

    @Override
    public void update() {

    }

    public Update getUpdate() {return null;}

    @Override
    public void deletePosition(Position position) {

    }

    @Override
    public void addPosition(Position position) {

    }
}
