package multiTicTacToe.multiTTT;

import java.util.logging.Logger;

/**
 * Board class to hold nine fields represents a multitictactoe
 */
public class Board {
    private static final Logger log = Logger.getLogger(Board.class.getName());

    /**
     * Array to hold the seperate fields
     */
    private Field[] mBoard;

    /**
     * Integer to save the next field position
     */
    private int mNextFieldPos;

    /**
     * Constructor for Board
     * @param size Size of board
     */
    public Board(int size) {
        mBoard = new Field[(size * size) + 1];
        for (int i = 1; i <= (size * size); i++) {
            mBoard[i] = new Field(size, i);
        }
        log.info("Created Board");
    }

    /**
     * Get a specific field from the board through index
     * @param pos 1-9
     * @return Field
     */
    public Field getField(int pos) {
        return mBoard[pos];
    }

    /**
     * Get next field position
     * @return int Position of next playable field
     */
    public int getNextFieldPos() {
        return mNextFieldPos;
    }

    /**
     * Set a move to the field on board
     * @param pl Player instance
     * @param fieldpos field position on the board (1-9)
     * @param pos field position on the field
     * @return boolean True wenn der Zug erfolgreich gesetzt wurde, sonst False
     */
    public boolean setMove(Player pl, int fieldpos, int pos) {
        if (mNextFieldPos == 0) {
            mNextFieldPos = fieldpos;
        }
        if (fieldpos != mNextFieldPos) {
            log.warning("Move not allowed. Move has to be in Field " + mNextFieldPos);
            return false;
        } else if (mBoard[fieldpos].setMove(pl, pos)) {
            mNextFieldPos = pos;
            return true;
        }

        return false;
    }

    /**
     * Check board for winner
     * @param pl Player instance
     */
    public boolean isWon(Player pl) {
        char sign = pl.getSign();
        if (mBoard[1].getSign() == sign && mBoard[2].getSign() == sign && mBoard[3].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }
        if (mBoard[4].getSign() == sign && mBoard[5].getSign() == sign && mBoard[6].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }
        if (mBoard[7].getSign() == sign && mBoard[8].getSign() == sign && mBoard[9].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }
        if (mBoard[1].getSign() == sign && mBoard[4].getSign() == sign && mBoard[7].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }
        if (mBoard[2].getSign() == sign && mBoard[5].getSign() == sign && mBoard[8].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }
        if (mBoard[3].getSign() == sign && mBoard[6].getSign() == sign && mBoard[9].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }
        if (mBoard[1].getSign() == sign && mBoard[5].getSign() == sign && mBoard[9].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }
        if (mBoard[3].getSign() == sign && mBoard[5].getSign() == sign && mBoard[7].getSign() == sign) {
            log.info("Game is won by Player " + sign);
            return true;
        }

        return false;
    }
}
