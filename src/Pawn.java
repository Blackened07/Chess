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
        if (color.equals("White") && line == 1 && toLine == line + 2 && toColumn == column && chessBoard.boardArray[toLine][toColumn] == null ||
                color.equals("Black") && line == 6 && toLine == line - 2 && toColumn == column&& chessBoard.boardArray[toLine][toColumn] == null) return true;
        else if (color.equals("White") && toLine == line + 1 && toColumn == column && chessBoard.boardArray[toLine][toColumn]!= null ||
        color.equals("Black") && toLine == line - 1 && toColumn == column && chessBoard.boardArray[toLine][toColumn]!= null ) return false;
        //else if ((color.equals("White") && toLine == line + 1 && toLine == 7 && toColumn == column && chessBoard.boardArray[toLine][toColumn]== null ||
       //         color.equals("Black") && toLine == line - 1 && toLine == 0 && toColumn == column && chessBoard.boardArray[toLine][toColumn]== null ) {
        //    chessBoard.boardArray[toLine][toColumn].getSymbol()
        //}
        else if (color.equals("White") && toLine == line + 1 && Math.abs(toColumn - column) == 1 &&
                chessBoard.boardArray[toLine][toColumn] != null && !chessBoard.boardArray[toLine][toColumn].getColor().equals(color) ||
        color.equals("Black") && toLine == line - 1 && Math.abs(toColumn - column) == 1 &&
                chessBoard.boardArray[toLine][toColumn] != null && !chessBoard.boardArray[toLine][toColumn].getColor().equals(color)) return true;
        else if (color.equals("White") && toLine == line + 1 && toColumn == column && (checkPos(toLine) && checkPos(toColumn)) ||
                color.equals("Black") && toLine == line - 1 && toColumn == column && (checkPos(toLine) && checkPos(toColumn))) return true;
        else return false;
    }
}
