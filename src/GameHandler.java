import java.util.Scanner;

public class GameHandler {

    String w_name;
    String b_name;
    int turn = 0; // Black = 1, White = 0
    ChessBoard board;


    public GameHandler(String white, String black){
        this.w_name = white;
        this.b_name = black;
        this.board = new ChessBoard();
        board.initialize();
    }


    public static GameHandler setup(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Chess!");
        System.out.println("Created by Dylan Sapienza");
        System.out.println("White Player Name: ");
        String white = scnr.nextLine();
        System.out.println("Black Player Name: ");
        String black = scnr.nextLine();

        return new GameHandler(white, black);
    }

    public void gameContinue(GameHandler game){

        if(turn == 0){
            game.board.print();
            System.out.println("\n\n");
            System.out.println(w_name+ "'s Turn!");
            turn++; //Check turn, if 1 then its white moving, if 0 its black
            return;

        }

        if(turn == 1){
            game.board.print();
            System.out.println("\n\n");
            System.out.println(b_name+ "'s Turn!");
            turn--;
            return;

        }
    }


}
