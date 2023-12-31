package lowleveldesign.chess;

public class Queen extends  Piece {

    Queen(PieceColor color)
    {
        super(color);
    }
    @Override
    boolean move(Board board, Box start, Box end) {
        return false;
    }
}
