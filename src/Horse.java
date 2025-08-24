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
        int dirLine = Math.abs(toLine - line);
        int dirColumn = Math.abs(toColumn - column);
        if (checkPos(toLine) && checkPos(toColumn)) {
            return  (dirLine == 2 && dirColumn == 1 || dirLine == 1 && dirColumn == 2);
        }
        else return false;
    }

}
