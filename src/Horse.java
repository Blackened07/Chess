public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine == line + 1 && toColumn == column + 2 && (checkPos(toLine) && checkPos(toColumn)) ||
                toColumn == column - 2 && (checkPos(toLine) && checkPos(toColumn))) return true;
         else if (toLine == line - 1 && toColumn == column + 2 && (checkPos(toLine) && checkPos(toColumn)) ||
                toColumn == column - 2 && (checkPos(toLine) && checkPos(toColumn))) return true;
         else if (toLine == line + 2 && toColumn == column + 1 && (checkPos(toLine) && checkPos(toColumn))||
                toColumn == column - 1 && (checkPos(toLine) && checkPos(toColumn))) return true;
         else if (toLine == line - 2 && toColumn == column + 1 && (checkPos(toLine) && checkPos(toColumn)) ||
                toColumn == column - 1 && (checkPos(toLine) && checkPos(toColumn))) return true;
         else return false;
    }

}
