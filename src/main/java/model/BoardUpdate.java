package model;

import util.Position;

import java.util.List;

public interface BoardUpdate {
    int stepNumber();
    List<Position> updateToNextGeneration();
}
