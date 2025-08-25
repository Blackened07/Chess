public class ChessBoard {
    public ChessPiece[][] boardArray = new ChessPiece[8][8]; // creating a field for game

    String nowPlayer;
    KingPosition kingPos = new KingPosition(0, 0);

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {

        if (checkPos(startLine) && checkPos(startColumn)) {
            if (!nowPlayer.equals(boardArray[startLine][startColumn].getColor())) return false;
            //System.out.println(findTheKing(this, this.nowPlayer));
            if (boardArray[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {

                if (boardArray[startLine][startColumn].getSymbol().equals("K") ||
                        boardArray[startLine][startColumn].getSymbol().equals("R")) {
                    boardArray[startLine][startColumn].check = false;
                }
                boardArray[endLine][endColumn] = boardArray[startLine][startColumn];
                boardArray[startLine][startColumn] = null;

                if (nowPlayerColor().equals("White") && endLine == 7 && boardArray[endLine][endColumn].getSymbol().equals("P") ||
                        nowPlayerColor().equals("Black") && endLine == 0 && boardArray[endLine][endColumn].getSymbol().equals("P")) {
                    boardArray[endLine][endColumn] = new Queen(nowPlayerColor());

                }
                //findTheKing(this, nowPlayer);mo
               if (kingPos.checkDesk(this)) return false;
               this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }





    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            if (boardArray[0][0] == null || boardArray[0][4] == null) return false;
            if (boardArray[0][0].getSymbol().equals("R") && boardArray[0][4].getSymbol().equals("K") && // check that King and Rook
                    boardArray[0][1] == null && boardArray[0][2] == null && boardArray[0][3] == null) {              // never moved
                if (boardArray[0][0].getColor().equals("White") && boardArray[0][4].getColor().equals("White") &&
                        boardArray[0][0].check && boardArray[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 2)) { // check that position not in under attack
                    boardArray[0][4] = null;
                    boardArray[0][2] = new King("White");   // move King
                    boardArray[0][2].check = false;
                    boardArray[0][0] = null;
                    boardArray[0][3] = new Rook("White");   // move Rook
                    boardArray[0][3].check = false;
                    nowPlayer = "Black";  // next turn
                    return true;
                } else return false;
            } else return false;
        } else {
            if (boardArray[7][0] == null || boardArray[7][4] == null) return false;
            if (boardArray[7][0].getSymbol().equals("R") && boardArray[7][4].getSymbol().equals("K") && // check that King and Rook
                    boardArray[7][1] == null && boardArray[7][2] == null && boardArray[7][3] == null) {              // never moved
                if (boardArray[7][0].getColor().equals("Black") && boardArray[7][4].getColor().equals("Black") &&
                        boardArray[7][0].check && boardArray[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 2)) { // check that position not in under attack
                    boardArray[7][4] = null;
                    boardArray[7][2] = new King("Black");   // move King
                    boardArray[7][2].check = false;
                    boardArray[7][0] = null;
                    boardArray[7][3] = new Rook("Black");   // move Rook
                    boardArray[7][3].check = false;
                    nowPlayer = "White";  // next turn
                    return true;
                } else return false;
            } else return false;
        }
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            if (boardArray[0][7] == null || boardArray[0][4] == null) return false;
            System.out.println(boardArray[0][7]);
            if (boardArray[0][7].getSymbol().equals("R") && boardArray[0][4].getSymbol().equals("K") && // check that King and Rook
                    boardArray[0][6] == null && boardArray[0][5] == null) {              // never moved
                if (boardArray[0][7].getColor().equals("White") && boardArray[0][4].getColor().equals("White") &&
                        boardArray[0][7].check && boardArray[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 6)) { // check that position not in under attack
                    boardArray[0][4] = null;
                    boardArray[0][6] = new King("White");   // move King
                    boardArray[0][6].check = false;
                    boardArray[0][7] = null;
                    boardArray[0][5] = new Rook("White");   // move Rook
                    boardArray[0][5].check = false;
                    nowPlayer = "Black";  // next turn
                    return true;
                } else return false;
            } else return false;
        } else {
            if (boardArray[7][7] == null || boardArray[7][4] == null) return false;
            if (boardArray[7][7].getSymbol().equals("R") && boardArray[7][4].getSymbol().equals("K") && // check that King and Rook
                    boardArray[7][6] == null && boardArray[7][5] == null) {              // never moved
                if (boardArray[7][7].getColor().equals("Black") && boardArray[7][4].getColor().equals("Black") &&
                        boardArray[7][7].check && boardArray[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 6)) { // check that position not in under attack
                    boardArray[7][4] = null;
                    boardArray[7][6] = new King("Black");   // move King
                    boardArray[7][6].check = false;
                    boardArray[7][7] = null;
                    boardArray[7][5] = new Rook("Black");   // move Rook
                    boardArray[7][5].check = false;
                    nowPlayer = "White";  // next turn
                    return true;
                } else return false;
            } else return false;
        }
    }


    public void printBoard() {  //print boardArray in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (boardArray[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(boardArray[i][j].getSymbol() + boardArray[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }




}