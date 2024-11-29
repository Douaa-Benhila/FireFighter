package model;

import java.util.List;

public interface BoardState {
    /**
     * Get the state of the board at a specific position.
     *
     * @param position The position on the board for which to retrieve the state.
     * @return The state at the specified position.
     */
    List<BoardElement> getState(util.Position position);

    /**
     * Set the state of a specific position on the board to the specified state.
     *
     * @param state The state to set for the given position.
     * @param position The position on the board for which to set the state.
     */
    void setState(List<BoardElement> state, util.Position position);

}
// add comment for push purpose








