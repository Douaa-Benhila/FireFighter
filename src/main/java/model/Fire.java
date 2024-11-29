package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fire implements BoardElement {
    private static List<Position> positions;
    private Update update;
    private FirefighterBoard  firefighterBoard;

    public Fire(int initialFireCount, Update update , FirefighterBoard firefighterBoard) {
        positions = new ArrayList<>();
        for (int index = 0; index < initialFireCount; index++)
            positions.add(firefighterBoard.randomPosition());

        this.firefighterBoard = firefighterBoard;
        this.update = update;
    }

    @Override
    public List<Position> getPosition() {
        return positions;
    }
    public static List<Position> getFirePositions() {return positions;}
    @Override
    public void update() {
        if (firefighterBoard.getStep() % 2 == 0) {
            update.influence(this);

        }


    }

    @Override
    public Update getUpdate() {
        return update;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fire fire = (Fire) o;
        return this.getPosition().equals(fire.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPosition());
    }


}


