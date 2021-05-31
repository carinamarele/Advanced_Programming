package move;

public interface Move {

    /**
     * Executes the move.
     *
     */
    void executeMove();

    /**
     * Undoes the move by reversing
     * its effect.
     */
    void undo();

    /**
     * @return True if the move is not a move that
     *     advances the game. False by default.
     */
    default boolean isNull()
    { return false; }
}
