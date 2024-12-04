package Motionless;

import model.FirefighterBoard;
import Movable.Update;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Road implements MotionlessElement {
    private List<Position> positions;
    private FirefighterBoard firefighterBoard;
    private Impact impact;

    public Road (Impact impact, int initialMountainCount, FirefighterBoard firefighterBoard) {
        positions = new ArrayList<>();
        for (int index = 0; index < initialMountainCount; index++)
            positions.add(firefighterBoard.randomPosition());
        this.firefighterBoard = firefighterBoard;
        this.impact = impact;
    }

    @Override
    public List<Position> getPosition() {
        return positions;
    }

    @Override
    public void impact() {
        impact.impact();
    }

    @Override
    public void update() {impact();}

    @Override
    public Update getUpdate() {
        return null;
    }

    public Impact getImpact() {return impact;}

}
