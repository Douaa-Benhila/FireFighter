package model;

import java.util.List;

public interface BoardElementFactory {
    int getInitialNumber();
    List<BoardElement> createElements(int rowCount, int columnCount);
}
