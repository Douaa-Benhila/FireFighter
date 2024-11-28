package model;

import java.util.List;

public interface BoardElementFactory {
    int getInitialNumber();
    BoardElement createElements(int rowCount, int columnCount);
}
