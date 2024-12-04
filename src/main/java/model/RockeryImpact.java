package model;

import util.Position;

import java.util.*;

public class RockeryImpact implements Impact{
    private FirefighterBoard firefighterBoard;
    private Map<Position, Integer> fireCounters;

    public RockeryImpact(FirefighterBoard firefighterBoard) {
        this.firefighterBoard = firefighterBoard;
        this.fireCounters = new HashMap<>();
    }

    @Override
    public void impact() {
        for (Map.Entry<Position, List<Position>> entry : firefighterBoard.getNeighbors().entrySet()) {
            for (Position neighbor : entry.getValue()) {
                if (getRockeryPositions().contains(neighbor)) {
                    List<BoardElement> elements = firefighterBoard.getState(entry.getKey());
                    for (BoardElement element : elements) {
                        if (element instanceof Fire) {
                            int currentFireStep = fireCounters.getOrDefault(neighbor, 0);

                            if (currentFireStep >= 4) {
                                getFirePositions().add(neighbor);
                                getRockeryPositions().remove(neighbor);
                            } else {
                                fireCounters.put(neighbor, currentFireStep + 1);
                            }
                        }
                    }
                }
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
