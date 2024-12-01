package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Cloud implements BoardElement {
    private List<Position> positions;
    private FirefighterBoard firefighterBoard;
    private Update update;

    public Cloud(FirefighterBoard firefighterBoard, Update update, int initialCloud) {
        this.firefighterBoard = firefighterBoard;
        this.update = update;
        positions = new ArrayList<>();
        for (int i=0; i<initialCloud; i++) {
            positions.add(firefighterBoard.randomPosition());
        }
    }
    @Override
    public List<Position> getPosition() {
        return positions;
    }

    @Override
    public void update() {
        update.influence(this);
    }

    @Override
    public Update getUpdate() {
        return update;
    }

}