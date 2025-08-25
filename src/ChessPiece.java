public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;
    protected String symbol;
    public ChessPiece(String color) {
        this.color = color;
    }

    public ChessPiece(String color, String symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public abstract String getColor();
    public abstract String getSymbol();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

}
