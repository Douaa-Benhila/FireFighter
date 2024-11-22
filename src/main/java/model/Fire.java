package model;

import util.Position;
import java.util.List;

public class Fire implements BoardElement ,PositionControl{
    private List<Position> positions;
    private Update  update;

   public Fire(List<Position> positions,Update  update){
       this.positions=positions;
       this.update=update;
   }

    @Override
    public List<Position> getPosition() { return null;}

    @Override
    public void update() {}

    @Override
    public Update getUpdate() {return null;}

    @Override
    public void deletePosition(Position position) {}

    @Override
    public void addPosition(Position position) {}
}
