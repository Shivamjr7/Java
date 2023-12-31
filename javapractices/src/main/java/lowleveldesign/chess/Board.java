package lowleveldesign.chess;

public class Board {


    Box boxes[][];


    void initalizeBoard(int n) {
        boxes = new Box[n][n];

        // keep white piece

        boxes[0][0] = new Box(0, 0, new Rook(PieceColor.WHITE));
        boxes[0][1] = new Box(0, 1, new Knight(PieceColor.WHITE));
        boxes[0][2] = new Box(0, 1, new Bishop(PieceColor.WHITE));
        boxes[0][3] = new Box(0, 1, new King(PieceColor.WHITE));
        boxes[0][4] = new Box(0, 1, new Queen(PieceColor.WHITE));
        boxes[0][5] = new Box(0, 1, new Bishop(PieceColor.WHITE));
        boxes[0][5] = new Box(0, 1, new Knight(PieceColor.WHITE));
        boxes[0][5] = new Box(0, 1, new Rook(PieceColor.WHITE));


        for (int i = 0; i < 7; i++) {
            boxes[1][i] = new Box(1, i, new Pawn(PieceColor.WHITE));
        }


        // keep black piece


        boxes[7][0] = new Box(0, 0, new Rook(PieceColor.BLACK));
        boxes[7][1] = new Box(0, 1, new Knight(PieceColor.BLACK));
        boxes[7][2] = new Box(0, 1, new Bishop(PieceColor.BLACK));
        boxes[7][3] = new Box(0, 1, new King(PieceColor.BLACK));
        boxes[7][4] = new Box(0, 1, new Queen(PieceColor.BLACK));
        boxes[7][5] = new Box(0, 1, new Bishop(PieceColor.BLACK));
        boxes[7][6] = new Box(0, 1, new Knight(PieceColor.BLACK));
        boxes[7][7] = new Box(0, 1, new Rook(PieceColor.BLACK));


        for (int i = 0; i < 7; i++) {
            boxes[7][i] = new Box(1, i, new Pawn(PieceColor.BLACK));
        }

    }
}
