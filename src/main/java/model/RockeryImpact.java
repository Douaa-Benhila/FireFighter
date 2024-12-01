package model;

import util.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RockeryImpact implements Impact{
    private FirefighterBoard firefighterBoard;
    private Map<Position, Integer> fireFreezeCounter;

    public RockeryImpact(FirefighterBoard firefighterBoard) {
        this.firefighterBoard = firefighterBoard;
        this.fireFreezeCounter = new HashMap<>();
    }

    @Override
    public void impact() {
        for (List<Position> neighbors : firefighterBoard.getNeighbors().values()) {
            for (Position neighbor : neighbors) {
                if (getRockeryPositions().contains(neighbor)) {
                    List<BoardElement> elements = firefighterBoard.getState(neighbor);
                    for (BoardElement element : elements) {
                        if (element instanceof Fire) {
                            fireFreeze((Fire) element, neighbor);
                        }
                    }
                }
            }
        }
    }

    private void fireFreeze(Fire fire, Position position) {
        fireFreezeCounter.putIfAbsent(position, 0);
        int freezeCount = fireFreezeCounter.get(position);

        if (freezeCount < 4) {
            fireFreezeCounter.put(position, freezeCount + 1);
        } else {
            propagateFire(position);
            fireFreezeCounter.remove(position);
        }
    }

    private void propagateFire(Position position) {
        List<Position> neighbors = firefighterBoard.getNeighbors().get(position);
        for (Position neighbor : neighbors) {
            if (!getRockeryPositions().contains(neighbor)) {
                getFirePositions().add(neighbor);
            }
        }
    }

    private List<Position> getRockeryPositions(){
        for (BoardElement element:firefighterBoard.getElements()){
            if (element instanceof Rockery){return element.getPosition();}
        }
        return new ArrayList<>();
    }

    private List<Position> getFirePositions() {
        for (BoardElement element : firefighterBoard.getElements()) {
            if (element instanceof Fire) {
                return element.getPosition();
            }
        }
        return new ArrayList<>();
    }

}
