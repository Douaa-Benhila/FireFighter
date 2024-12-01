package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Rockery implements MotionlessElement{
    private List<Position> positions;
    private FirefighterBoard firefighterBoard;
    private Impact impact;

    public Rockery(Impact impact, int initialRockeryCount, FirefighterBoard firefighterBoard) {
        positions = new ArrayList<>();
        for (int index = 0; index < initialRockeryCount; index++)
            positions.add(firefighterBoard.randomPosition());
        this.firefighterBoard = firefighterBoard;
        this.impact = impact;
    }

    @Override
    public List<Position> getPosition() {
        return positions;
    }

    @Override
    public void update() {
        impact();
    }

    @Override
    public Update getUpdate() {
        return null;
    }

    @Override
    public void impact() {
        impact.impact();
    }
}
