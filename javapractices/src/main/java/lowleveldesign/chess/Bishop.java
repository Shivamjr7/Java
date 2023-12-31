package lowleveldesign.chess;

public class Bishop extends  Piece {

    Bishop(PieceColor color)
    {
        super(color);
    }
    @Override
    boolean move(Board board, Box start, Box end) {
        return false;
    }
}
