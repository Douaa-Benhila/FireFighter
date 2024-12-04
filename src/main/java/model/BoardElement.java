package model;

import Movable.Update;

import java.util.*;

public interface BoardElement {
    List<util.Position> getPosition();
    void update();
    Update getUpdate();
}
