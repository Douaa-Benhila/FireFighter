package Motionless;

import model.BoardElement;
import util.Position;

import java.util.List;

public interface MotionlessElement extends BoardElement {
    List<Position> getPosition();
    void impact();
}
