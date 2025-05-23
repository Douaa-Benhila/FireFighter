package model;

import Motionless.*;
import Movable.*;
import util.Position;

import java.util.*;


public class FirefighterBoard implements BoardState,BoardUpdate,BoardInitialisation,BoardDimesions {
  private final int columnCount;
  private final int rowCount;
  private List<BoardElement> elements=new ArrayList<>();
  private List<BoardElementFactory> elementFactories=new ArrayList<>();
  private util.Position[][] positions;
  private Map<Position, List<Position>> neighbors = new HashMap();
  private int step = 0;
  private final Random randomGenerator = new Random();

  public FirefighterBoard(int columnCount, int rowCount, int initialFireCount, int initialFirefighterCount, int initialMotorizedFirefighterCount, int initialMountainCount, int initialRockeryCount ,int initialCloudCount , int initialRoadCount) {
    this.columnCount = columnCount;
    this.rowCount = rowCount;
    this.positions = new util.Position[rowCount][columnCount];
    for (int column = 0; column < columnCount; column++)
      for (int row = 0; row < rowCount; row++)
        positions[row][column] = new Position(row, column);
    for (int column = 0; column < columnCount; column++)
      for (int row = 0; row < rowCount; row++) {
        List<Position> list = new ArrayList<>();
        if (row > 0) list.add(positions[row - 1][column]);
        if (column > 0) list.add(positions[row][column - 1]);
        if (row < rowCount - 1) list.add(positions[row + 1][column]);
        if (column < columnCount - 1) list.add(positions[row][column + 1]);
        neighbors.put(positions[row][column], list);
      }
    this.elements = new ArrayList<>();
    this.elementFactories = new ArrayList<>();


    //  IMPORTANT : MountainFactory needs to be the first element to be added in the list "elementFactories"
    elementFactories.add(new MountainFactory(initialMountainCount, new MountainImpact(this), this));

    //  Motionless elements needs to be added after MountainFactory
    elementFactories.add(new RockeryFactory(initialRockeryCount, new RockeryImpact(this), this));
    elementFactories.add(new RoadFactory(initialRoadCount, new RoadImpact(this), this));

    elementFactories.add(new FireFactory(initialFireCount, new FireUpdate(this), this));
    elementFactories.add(new FirefighterFactory(initialFirefighterCount, new FirefighterUpdate(), this));
    elementFactories.add(new MotorizedFirefighterFactory(initialMotorizedFirefighterCount, new MotorizedFirefighterUpdate(this),this));
    elementFactories.add(new CloudFactory(initialCloudCount, new CloudUpdate(this), this));


    initializeElements();
  }


  @Override
  public void initializeElements() {
    for(BoardElementFactory factory : elementFactories){
      this.elements.add(factory.createElements());
    }
  }

  public Position randomPosition() {
    return new Position(randomGenerator.nextInt(rowCount), randomGenerator.nextInt(columnCount));
  }

  public int getStep(){return this.step;}
  public List<BoardElement> getElements(){return this.elements;}

  @Override
  public int rowCount() {
    return rowCount;
  }

  @Override
  public int columnCount() {
    return columnCount;
  }

  @Override
  public List<util.Position> updateToNextGeneration() {
    if (isGameOver()) return new ArrayList<>();
    List<util.Position> result = new ArrayList<>();

    elements.stream()
            .filter(element -> element instanceof Mountain)
            .forEach(BoardElement::update);


    elements.stream()
            .filter(element -> element instanceof Firefighter)
            .forEach(BoardElement::update);

    elements.stream()
            .filter(element -> element instanceof Cloud)
            .forEach(BoardElement::update);

    elements.stream()
            .filter(element -> element instanceof MotorizedFirefighter)
            .forEach(BoardElement::update);

    elements.stream()
            .filter(element -> element instanceof Fire)
            .forEach(BoardElement::update);

    elements.stream()
            .filter(element -> element instanceof Rockery)
            .forEach(BoardElement::update);

    // Road needs to be the last element added to the list
    elements.stream()
            .filter(element -> element instanceof Road)
            .forEach(BoardElement::update);

    for (BoardElement element:elements){
      result.addAll(element.getPosition());

    }
    step++;
    return result;
  }

  private boolean isGameOver(){
    for (BoardElement element : elements){
      if(element instanceof Fire){
        if (element.getPosition().isEmpty()) return true;
      }
    }
    return false;
  }

  @Override
  public int stepNumber() {
    return step;
  }

  public Position[][] getPositions(){return positions;}


  @Override
  public void reset() {
    step = 0;
    elements.clear();
    initializeElements();
  }

  public Map<Position, List<Position>> getNeighbors(){return neighbors;}


  @Override
  public List<BoardElement> getState(util.Position position) {
    List<BoardElement> result = new ArrayList<>();
    for (BoardElement element : elements) {
      for(util.Position p:element.getPosition()){
        if (p.equals(position)) result.add(element);
      }

    }
    return result;
  }

  @Override
  public void setState(List<BoardElement> state, Position position) {
    for (BoardElement element : elements) {
      element.getPosition().clear();
      for(BoardElement s : state){
        if (element.getClass().equals(s.getClass())){
          element.getPosition().add(position);
        }

      }

    }
  }


}