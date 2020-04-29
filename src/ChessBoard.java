public class ChessBoard {

    String[][] board = new String[8][8];

    public void fill(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                this.board[i][j] = "i";
            }
        }
    }

    public void initialize(){
        String[][] newBoard = {{"BR","BK","BB","BQ","B!","BB","BK","BR"},
                                {"BP","BP","BP","BP","BP","BP","BP","BP"},
                                {"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" },
                                {"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" },
                                {"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" },
                                {"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" ,"_" },
                                {"WP","WP","WP","WP","WP","WP","WP","WP"},
                                {"WR","WK","WB","WQ","W!","WB","WK","WR"}
                                };

        this.board = newBoard;
    }

    public void print(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j <9; j++){
                if(j == 8){
                    System.out.print(8-i);
                }
                else {
                    System.out.print(this.board[i][j]);
                }

                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("A\tB\tC\tD\tE\tF\tG\tH\t");
    }

    public void move(int[][] input){
        String origin = this.board[input[0][0]][input[0][1]];
        this.board[input[0][0]][input[0][1]] = "_";
        this.board[input[1][0]][input[1][1]] = origin;

    }
    public String getPiece(int[][] move, int origindest) {
        //if origindest == 0 return origin spot
        //if origindest == 1 return destination spot
        if (origindest == 0) {
            return board[move[0][0]][move[0][1]];
        }
        if (origindest == 1) {
            return board[move[1][0]][move[1][1]];
        }
        return "";
    }


}
