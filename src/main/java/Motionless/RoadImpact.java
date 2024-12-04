package Motionless;

import Movable.MotorizedFirefighter;
import model.*;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class RoadImpact implements Impact {
    private FirefighterBoard firefighterBoard;

    public RoadImpact(FirefighterBoard firefighterBoard) {
        this.firefighterBoard = firefighterBoard;
    }

    @Override
    public void impact() {
        for (Position roadPosition : getRoadPositions()) {
            List<BoardElement> elements = firefighterBoard.getState(roadPosition);

            for(BoardElement element : elements) {
                if (!(element instanceof Firefighter || element instanceof MotorizedFirefighter || element instanceof Road)) {
                    element.getPosition().remove(roadPosition);
                }
            }

        }
    }

    private List<Position> getRoadPositions() {
        List<Position> roadPositions = new ArrayList<>();
        for (BoardElement element : firefighterBoard.getElements()) {
            if (element instanceof Road) {
                roadPositions.addAll(element.getPosition());
            }
        }
        return roadPositions;
    }
}