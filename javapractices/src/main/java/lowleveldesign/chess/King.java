package lowleveldesign.chess;

public class King extends Piece{


    King(PieceColor color)
    {
        super(color);
    }
    @Override
    boolean move(Board board, Box start , Box end) {
        // king can move in any of the 4 directions



        return false;
    }
}
