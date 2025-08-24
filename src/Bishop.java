public class Bishop extends ChessPiece{
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) return false;
        if (checkPos(toLine) && checkPos(toColumn)) {
            if (line == toLine && column == toColumn) return false;
            int lStep = Integer.compare(toLine, line);
            int cStep = Integer.compare(toColumn, column);
            int lineStep = line + lStep, columnStep = column + cStep;

            while (lineStep != toLine && columnStep != toColumn) {
                if (chessBoard.boardArray[lineStep][columnStep] != null ) return false;
                lineStep += lStep;
                columnStep += cStep;
            }
        } else return false;
        return true;
    }

}
