package lowleveldesign.chess;

public  abstract class Piece {

    //color of the piece
    PieceColor color;

    Piece(PieceColor color)
    {
        this.color = color;
    }

    //move
    abstract boolean move(Board board, Box start , Box end);


    public void setColor(PieceColor color) {
        this.color = color;
    }
}
