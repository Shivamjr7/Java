package lowleveldesign.chess;

public class Pawn extends  Piece{

    Pawn(PieceColor color)
    {
        super(color);
    }
    @Override
    boolean move(Board board, Box start, Box end) {
        return false;
    }
}
