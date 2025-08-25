public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "P";
    }


    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int LDir = getColor().equals("White") ? 1 : -1;
        if (checkPos(toLine) && checkPos(toColumn)) {
            if (toColumn == column && chessBoard.boardArray[toLine][toColumn] == null) {
                if (toLine == line + LDir) return true;

                if ((color.equals("White") && line == 1 || color.equals("Black") && line == 6) &&
                        toLine == line + LDir * 2 && chessBoard.boardArray[line + LDir][toColumn] == null && chessBoard.boardArray[toLine][toColumn] == null)
                    return true;
            }
            if (color.equals("White") && Math.abs(toColumn - column) == 1 && toLine == line + LDir && chessBoard.boardArray[toLine][toColumn] != null &&
                    !chessBoard.boardArray[toLine][toColumn].getColor().equals(color) || color.equals("Black") && Math.abs(toColumn - column) == 1 &&
                    toLine == line + LDir && chessBoard.boardArray[toLine][toColumn] != null &&
                    !chessBoard.boardArray[toLine][toColumn].getColor().equals(color))
                return true;

            if ((getColor().equals("White") && line == 6 || getColor().equals("Black") && line == 1) &&
            toLine == line + LDir && chessBoard.boardArray[toLine][toColumn] == null) return true;

            /* !!!During the "Under Attack" check, the enemy pawn is identified as friendly!!!*/

           // if ((color.equals("White") && toLine == line + 1 && toLine == 7 && toColumn == column && chessBoard.boardArray[toLine][toColumn] == null ||
           //       color.equals("Black") && toLine == line - 1 && toLine == 0 && toColumn == column && chessBoard.boardArray[toLine][toColumn] == null)) {
           //    new Queen(color);
           //}
        } else return false;
        return false;
    }
}
