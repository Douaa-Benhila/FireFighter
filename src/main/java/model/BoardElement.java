package model;

import util.Position;
import java.util.*;

public interface BoardElement {
    List<Position> getPosition();
    void update();
    Update getUpdate();
}
