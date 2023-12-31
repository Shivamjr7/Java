package lowleveldesign.chess;

public class Rook extends  Piece {

    Rook(PieceColor color)
    {
        super(color);
    }
    @Override
    boolean move(Board board, Box start, Box end) {
        return false;
    }
}
