package module.chess.chess_pieces;

import module.boardgame.Board;
import module.chess.ChessPiece;
import module.chess.Color;

public class Rook extends ChessPiece{
    public Rook (Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
