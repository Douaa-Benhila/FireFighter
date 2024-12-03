package model;

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

        List<Position> roadPositions = getRoadPositions();
        for (Position roadPosition : roadPositions) {
            List<Position> neighbors = firefighterBoard.getNeighbors().get(roadPosition);
            List<Position> toRemove = new ArrayList<>();
            for (Position neighbor : neighbors) {
                List<BoardElement> elements = firefighterBoard.getState(neighbor);
                boolean isBlocked = true;
                for (BoardElement element : elements) {
                    if (element instanceof Firefighter || element instanceof MotorizedFirefighter) {
                        isBlocked = false;
                        break;
                    }
                }
                if (isBlocked) {
                    toRemove.add(neighbor);
                }
            }
            neighbors.removeAll(toRemove);
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