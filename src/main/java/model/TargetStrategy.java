package model;

import util.Position;

import java.util.*;

public class TargetStrategy {
    private final FirefighterBoard firefighterBoard;

    public TargetStrategy(FirefighterBoard firefighterBoard) {
        this.firefighterBoard = firefighterBoard;
    }

    /**
     * @param position current position.
     * @param targets positions that are targeted.
     * @return the position next to the current position that is on the path to the closest target.
     */
    Position neighborClosestToFire(Position position, Collection<Position> targets) {
        Set<Position> seen = new HashSet<Position>();
        HashMap<Position, Position> firstMove = new HashMap<Position, Position>();
        Queue<Position> toVisit = new LinkedList<Position>(firefighterBoard.neighbors(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (targets.contains(current))
                return firstMove.get(current);
            for (Position adjacent : firefighterBoard.neighbors(current)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
}