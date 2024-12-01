package view;

import javafx.scene.paint.Color;

public enum ViewElement {
  FIREFIGHTER(Color.BLUE), MOTORIZEDFIREFIGHTER(Color.ORANGE),FIRE(Color.RED), ROCKERY(Color.GREEN),MOUNTAIN(Color.DARKGRAY),EMPTY(Color.WHITE);
  final Color color;
  ViewElement(Color color) {
    this.color = color;
  }
}
