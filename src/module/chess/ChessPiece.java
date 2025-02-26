package module.chess;

import module.boardgame.Board;
import module.boardgame.Piece;
import module.boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    protected  boolean isThereOpponentPiece (Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    protected void increaseMoveCount () {
        moveCount++;
    }

    protected void decreaseMoveCount () {
        moveCount--;
    }


}
