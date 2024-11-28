package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Position {
    private int columnCount;
    private int rowCount;
    private Random randomGenerator;
    private Map<Position, List<Position>> neighbors;
    private Position[][] positions;

    public Position(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.positions = new Position[rowCount][columnCount];
        for (int column = 0; column < columnCount; column++)
            for (int row = 0; row < rowCount; row++)
                positions[row][column] = new Position(row, column);
    }

    public void initializeNeighbors(){
        for (int column = 0; column < columnCount; column++)
            for (int row = 0; row < rowCount; row++) {
                List<Position> list = new ArrayList<>();
                if (row > 0) list.add(positions[row - 1][column]);
                if (column > 0) list.add(positions[row][column - 1]);
                if (row < rowCount - 1) list.add(positions[row + 1][column]);
                if (column < columnCount - 1) list.add(positions[row][column + 1]);
                neighbors.put(positions[row][column], list);
            }
    }

    public Position randomPosition() {
        return new Position(randomGenerator.nextInt(rowCount), randomGenerator.nextInt(columnCount));
    }

    public Map<Position, List<Position>> getNeighbors() {return neighbors;}

}
