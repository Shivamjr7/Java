package lowleveldesign.chess;

public class Knight extends  Piece {

    Knight(PieceColor color)
    {
        super(color);
    }

    @Override
    boolean move(Board board, Box start, Box end) {
        return false;
    }
}
