public interface Attackable {
    boolean isUnderAttack(ChessBoard chessBoard, int line, int column);

    KingPosition findTheKing(ChessBoard chessBoard, String nowPlayer);

    boolean checkDesk(ChessBoard chessBoard);
}
