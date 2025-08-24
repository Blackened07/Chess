public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(toLine) && checkPos(toColumn)) {
            if (line == toLine && column != toColumn || line != toLine && column == toColumn) {
                int cStep = Integer.compare(toColumn, column);
                int lStep = Integer.compare(toLine, line);
                int columnStep = column + cStep;
                int lineStep = line + lStep;
                while (columnStep != toColumn || lineStep != toLine) {
                    if (chessBoard.boardArray[lineStep][columnStep] != null) return false;
                    if (columnStep != toColumn) columnStep += cStep;
                    if (lineStep != toLine) lineStep += lStep;
                }
            } else return false;
        } else return false;
        return true;
    }


}
