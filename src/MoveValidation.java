public class MoveValidation {

    public static boolean validate(int[][] move, GameHandler game){

        //Check that the input and output are within ranges
        if(!checkBounds(move)){
            System.out.println("Error: Move is out of range. [A-H][1-8]!");
            return false;
        }

        System.out.println("Bounds are correct");

        if(!originPiece(move, game)){
            return false;
        }

        if(!checkPieceRules(move, game)){

        }




    }

    public static boolean checkBounds(int[][] move){

        if(move[0][0] > 7 || move[0][0] < 0){
            return false;
        }

        if(move[0][1] > 7 || move[0][1] < 0){
            return false;
        }

        if(move[1][0] > 7 || move[1][0] < 0){
            return false;
        }

        if(move[1][1] > 7 || move[1][1] < 0){
            return false;
        }

        return true;
    }

    public static boolean originPiece(int[][] move, GameHandler game){
        //Check origin
        String origin = game.board.getPiece(move, 0);

        //Catch where origin piece is blank
        if(origin == "_"){
            System.out.println("You can't move a blank piece!");
            return false;
        }

        //Make sure players can only move their pieces
        if(game.turn == 1 && origin.charAt(0) == 'B'){
            System.out.println("You may only move your own pieces!");
            return false;
        }

        if(game.turn == 0 && origin.charAt(0) == 'W'){
            System.out.println("You may only move your own pieces!");
            return false;
        }

        return true;

    }

    public static boolean checkPieceRules(int[][] move, GameHandler game){

        String origin = game.board.getPiece(move, 0);
        String dest = game.board.getPiece(move, 1);

        switch (origin.charAt(1)){
            //
            case:
        }
    }



}
