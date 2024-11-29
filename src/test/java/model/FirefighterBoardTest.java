package model;

import org.junit.jupiter.api.Test;
import util.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FirefighterBoardTest {
  @Test
  void testColumnCount(){
    FirefighterBoard board = new FirefighterBoard(20, 10, 1, 3);
    assertThat(board.columnCount()).isEqualTo(20);
  }
  @Test
  void testRowCount(){
    FirefighterBoard board = new FirefighterBoard(20, 10, 1, 3);
    assertThat(board.rowCount()).isEqualTo(10);
  }
  @Test
  void testStepNumber(){
    FirefighterBoard board = new FirefighterBoard(20, 10, 1, 3);
    for(int index = 0; index < 10; index++){
      assertThat(board.stepNumber()).isEqualTo(index);
      board.updateToNextGeneration();
    }
    assertThat(board.stepNumber()).isEqualTo(10);
  }
  @Test
  void testGetState_afterSet(){
    FirefighterBoard board = new FirefighterBoard(20, 10, 0, 0);
    Position position = new Position(1,2);
    assertThat(board.getState(position)).isEmpty();
    Fire fire=new Fire(0, new FireUpdate(board), board);
    board.setState(List.of(fire), position);
    assertThat(board.getState(position)).containsExactly(fire);
  }

}
