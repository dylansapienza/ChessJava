public class ChessGame {

    public static void main(String[] args){
//        ChessBoard board = new ChessBoard();
//
//        board.initialize();
//
//        board.print();
//
//        String[] input = MoveInput.promptInput();
//
//        int[][] move = MoveInput.processMove(input);
//
//        board.move(move);
//
//        board.print();
        GameHandler game = GameHandler.setup();

        //true should be a gamestatus checker
        while(true){
            game.gameContinue(game);

            int[][] move = MoveInput.processMove(MoveInput.promptInput());

            while(!MoveValidation.validate(move, game)){
                System.out.println("Invalid Move Try again!");
                move = MoveInput.processMove(MoveInput.promptInput());
            }

            game.board.move(move);

        }




    }

}
