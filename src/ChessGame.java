public class ChessGame {

    public static void main(String[] args){
        ChessBoard board = new ChessBoard();
        board.initialize();
        board.print();
        String[] input = MoveInput.promptInput();
        int[][] move = MoveInput.processMove(input);
        board.move(move);
        board.print();
    }

}
