package model;

import java.util.*;

public interface BoardElement {
    List<util.Position> getPosition();
    void update();
    Update getUpdate();
}
