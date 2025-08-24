public class KingPosition implements Attackable {
    private int kingLine;
    private int kingColumn;

    public KingPosition(int line, int column) {
        this.kingLine = line;
        this.kingColumn = column;
    }


    public int getKingLine() {
        return kingLine;
    }

    public int getKingColumn() {
        return kingColumn;
    }

    public void setKingLine(int kingLine) {
        this.kingLine = kingLine;
    }

    public void setKingColumn(int kingColumn) {
        this.kingColumn = kingColumn;
    }

    public boolean checkDesk(ChessBoard chessBoard) {
        findTheKing(chessBoard);
        return isUnderAttack(chessBoard, getKingLine(), getKingColumn());
    }

    @Override
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
            for (int i = 0; i <= 7; i++) {
                for (int k = 0; k <= 7; k++) {
                    if (chessBoard.boardArray[i][k] != null) {
                        if (!chessBoard.boardArray[i][k].getColor().equals(chessBoard.nowPlayer) && chessBoard.boardArray[i][k].canMoveToPosition(chessBoard, i, k, line, column)) {
                            return true;
                        }
                    }
                }
            }

        return false;
    }

    @Override
    public KingPosition findTheKing(ChessBoard chessBoard) {
        for (int i = 0; i <= 7; i++) {
            for (int k = 0; k <= 7; k++) {
                if (chessBoard.boardArray[i][k] != null) {
                    if (chessBoard.boardArray[i][k].getColor().equals(chessBoard.nowPlayer) && chessBoard.boardArray[i][k].getSymbol().equals("K")) {
                        setKingLine(i);
                        setKingColumn(k);
                        break;
                    }
                }
            }
        }

        return new KingPosition(kingLine, kingColumn);
    }
}
