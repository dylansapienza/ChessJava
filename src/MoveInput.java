import java.util.Scanner;

public class MoveInput {

    public static int[][] processMove(String[] moves){
        int[][] processedMoves = new int[2][2];
        System.out.println(moves[0] + "->" + moves[1]);

        //[1-8][A-H]
        // This gives the character 'a'

        processedMoves[0][0] = moves[0].charAt(0)-65;
        processedMoves[0][1] = moves[0].charAt(1)-49;

        processedMoves[1][0] = moves[1].charAt(0)-65;
        processedMoves[1][1] = moves[1].charAt(1)-49;

        // A1 -> B4
        // [0][0] -> [7][0]
        // [1][3] -> [4][1]
        // C2 -> F5
        // [2][1] -> [5][4]
        // [6][2] -> [3][5]
        //
        // Swap Move Digits X,Y -> Y,X
        // Invert x (0 -> 7)
        //          (1 -> 6)
        //          (2 -> 5)
        //          (3 -> 4)
        //          (4 -> 3)
        //          (5 -> 2)
        //          (6 -> 1)
        //          (7 -> 0)

        return processedMoves;
    }

    public static String[] promptInput(){
        System.out.println("Enter your move: (A-H:1-8)");
        Scanner scnr = new Scanner(System.in);
        String move = scnr.nextLine();
        String[] movesplit = move.split(",");
        return movesplit;
    }

}
