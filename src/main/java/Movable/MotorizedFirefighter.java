package Movable;

import model.BoardElement;
import model.FirefighterBoard;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class MotorizedFirefighter implements BoardElement {
    private List<Position> positions;
    private FirefighterBoard firefighterBoard;
    private Update update;

    public MotorizedFirefighter(FirefighterBoard firefighterBoard, Update update, int initialMotorizedFirefighter) {
        this.firefighterBoard = firefighterBoard;
        this.update = update;
        positions = new ArrayList<>();
        for (int i=0; i<initialMotorizedFirefighter; i++) {
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
        update.influence(this);
    }

    @Override
    public Update getUpdate() {
        return update;
    }
}
