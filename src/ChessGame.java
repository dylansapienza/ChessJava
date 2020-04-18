public class ChessGame {

    public static void main(String[] args){
        ChessBoard board = new ChessBoard();
        board.initialize();
        board.print();
        String[] input = MoveInput.promptInput();
        int[][] move = MoveInput.processMove(input);
        System.out.println(move[0][0]+""+move[0][1]);
        System.out.println(move[1][0]+""+move[1][1]);
    }

}
