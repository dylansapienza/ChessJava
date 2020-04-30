import java.util.ArrayList;

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
            return false;
        }

        return true;

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

        //You cannot move a piece to its own position

        if(move[0][0] == move[0][1] && move[1][0] == move[1][1]){
            System.out.println("You can't keep your piece in the same position!");
            return false;
        }

        //You can't make a move into your own piece
        //UNLESS its the rook king side stuff
        if(dest.charAt(0) == 'W' && game.turn == 1){
            return false;
        }

        if(dest.charAt(0) == 'B' && game.turn == 0){
            return false;
        }


        //origin.charAt 1 will give us the piece type
        //from our origin location, locate all the possible destinations
        //if dest != possible destination invalid!
        //Consider abstracting away all the move checks into functions!
        switch (origin.charAt(1)){
            //Pawn
            case 'P':
                //1. Can move forward one square
                //Check to make sure the pawn isnt going straight into an enemy
                if(dest.charAt(0) != 'B' && game.turn == 1){

                     if(move[1][0] == move[0][0] -1 && move[1][1] == move[0][1]){
                         return true;
                     }

                }

                if(dest.charAt(0) != 'W' && game.turn == 0){
                    if(move[1][0] == move[0][0] +1 && move[1][1] == move[0][1]){
                        return true;
                    }
                }

                //If there is a diag opponent, allow attack dest

                if(dest.charAt(0) == 'W' && game.turn == 0) {
                    if (game.turn == 0) {

                        if (move[1][0] == move[0][0] + 1 && move[1][1] == move[0][1] + 1) {
                            return true;
                        }

                        if (move[1][0] == move[0][0] + 1 && move[1][1] == move[0][1] - 1) {
                            return true;
                        }
                    }

                }

                if(dest.charAt(0) == 'B' && game.turn == 1){
                    if(game.turn == 1){

                        if(move[1][0] == move[0][0] -1 && move[1][1] == move[0][1] - 1){
                            return true;
                        }

                        if(move[1][0] == move[0][0] -1 && move[1][1] == move[0][1] + 1){
                            return true;
                        }

                    }
                }


                break;
            //Knight

            case 'K':

                if(move[1][0] == move[0][0] -2 && move[1][1] == move[0][1] + 1){
                    return true;
                }


                if(move[1][0] == move[0][0] -2 && move[1][1] == move[0][1] - 1){
                    return true;
                }


                if(move[1][0] == move[0][0] -1 && move[1][1] == move[0][1] + 2){
                    return true;
                }


                if(move[1][0] == move[0][0] -1 && move[1][1] == move[0][1] - 2){
                    return true;
                }

                ///

                if(move[1][0] == move[0][0] +2 && move[1][1] == move[0][1] + 1){
                    return true;
                }


                if(move[1][0] == move[0][0] +2 && move[1][1] == move[0][1] - 1){
                    return true;
                }


                if(move[1][0] == move[0][0] +1 && move[1][1] == move[0][1] + 2){
                    return true;
                }


                if(move[1][0] == move[0][0] +1 && move[1][1] == move[0][1] - 2){
                    return true;
                }

                break;
            //Rook
            case 'R':

                String piece;
                int direction = 0;
                int distance = 0;

                if(move[0][0] == move[1][0]){

                    distance = move[0][1] - move[1][1];
                    if(distance < 0){
                        direction = -1;
                        distance *= -1;
                    }
                    for(int i = 0; i<distance; i++) {

                        if(direction == -1) {
                            piece = game.board.board[move[0][0]][move[0][1] + i];

                        }else{
                            piece = game.board.board[move[0][0]][move[0][1] - i];
                        }

                        if(piece.charAt(0) != '_'){
                            //Break loop and change destination move. Move is valid
                            //If the piece is an enemy then destination is updated
                            //If the piece is friendly then destination is updated - 1.
                            //possible bug where you can use rooks to not move! based on moving into a friendly position
                            //check on a way to catch this
                            //RETURN TRUE!
                            if((piece.charAt(0) == 'W' && game.turn == 0) || piece.charAt(0) == 'B' && game.turn == 1) {
                                move[1][1] = move[0][1] + i; //<- need to pass these values back to update
                                return true;
                            }
                            else{
                                move[1][1] = move[0][1] + (i-1);
                                return true;
                            }

                        }

                    }

                }

                if(move[0][1] == move[1][1]) {

                    distance = move[0][0] - move[1][0];
                    if (distance < 0) {
                        direction = -1;
                        distance *= -1;
                    }

                    for (int i = 0; i < distance; i++) {

                        if (direction == -1) {
                            piece = game.board.board[move[0][0] + i][move[0][1]];

                        } else {
                            piece = game.board.board[move[0][0] - i][move[0][1] - i];
                        }

                        if(piece.charAt(0) != '_'){
                            //Break loop and change destination move. Move is valid
                            //If the piece is an enemy then destination is updated
                            //If the piece is friendly then destination is updated - 1.
                            //possible bug where you can use rooks to not move! based on moving into a friendly position
                            //check on a way to catch this
                            //RETURN TRUE!
                            if((piece.charAt(0) == 'W' && game.turn == 0) || piece.charAt(0) == 'B' && game.turn == 1) {
                                if(direction == -1) {
                                    move[1][0] = move[0][0] + i;
                                    return true;
                                }
                                else{
                                    move[1][0] = move[0][0] - i;
                                    return true;
                                }
                            }
                            else{
                                if(direction == -1) {
                                    move[1][0] = move[0][0] + (i-1);
                                    return true;
                                }
                                else{
                                    move[1][0] = move[0][0] - (i-1);
                                    return true;
                                }

                            }

                        }


                    }
                }

                break;
            //Bishop
            case 'B':

                break;
            //Queen
            case 'Q':

                break;

            //King
            case '!':

                break;

            default:
                return false;

        }

        return false;
    }



}
