public class KingPosition implements Attackable {
    private int line;
    private int column;

    public KingPosition(int line, int column) {
        this.line = line;
        this.column = column;
    }


    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public boolean checkDesk(ChessBoard chessBoard) {
        findTheKing(chessBoard, chessBoard.nowPlayer);
        return isUnderAttack(chessBoard, getLine(), getColumn());
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
    public KingPosition findTheKing(ChessBoard chessBoard, String nowPlayer) {
        int kingLine = -1;
        int kingColumn = -1;
        for (int i = 0; i <= 7; i++) {
            for (int k = 0; k <= 7; k++) {
                if (chessBoard.boardArray[i][k] != null) {
                    if (nowPlayer.equals(chessBoard.boardArray[i][k].getColor()) && chessBoard.boardArray[i][k].getSymbol().equals("K")) {
                        kingLine = i;
                        kingColumn = k;

                        break;
                    }
                }
            }
        }

        return new KingPosition(kingLine, kingColumn);
    }
}
