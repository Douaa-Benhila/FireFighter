package model;

import java.util.List;

public interface BoardUpdate {
    int stepNumber();
    List<util.Position> updateToNextGeneration();
}
