package module.chess;

import module.boardgame.Board;
import module.boardgame.Piece;
import module.boardgame.Position;
import module.chess.chess_pieces.King;
import module.chess.chess_pieces.Rook;

public class ChessMatch {
    private Board board;
    
    public ChessMatch () {
        board = new Board(8, 8);
        initialSetup();
    }
    
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    public ChessPiece performeChessMove (ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSource(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove (Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece =board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSource(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){
        placeNewPiece('b', 6,new Rook(board, Color.WHITE));
        placeNewPiece('e', 8,new King(board, Color.BLACK));
        placeNewPiece('e', 1,new King(board, Color.WHITE));
    }
}
