package model;

import util.Position;

import java.util.List;

public interface MotionlessElement extends BoardElement {
    List<Position> getPosition();
    void impact();
}
