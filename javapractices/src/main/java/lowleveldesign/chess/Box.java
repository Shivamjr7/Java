package lowleveldesign.chess;

public class Box {

    private int x ;
    private int y ;
    private Piece piece;

    Box(int x, int y , Piece piece)
    {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}
