import java.util.Scanner;

public class NoughtsAndCrosses {
    public static void clearBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.printf("A %c  | %c  | %c %n", board[0][0], board[0][1], board[0][2]);
        System.out.println(" ---|---|---");
        System.out.printf("B %c  | %c  | %c %n", board[1][0], board[1][1], board[1][2]);
        System.out.println(" ---|---|---");
        System.out.printf("C %c  | %c  | %c %n", board[2][0], board[2][1], board[2][2]);
        System.out.println("  1   2   3 ");
    }

    public static boolean canMakeMove(char[][] board, int xpos, int ypos) {
        return xpos <= 2 && ypos <= 2 && board[xpos][ypos] == ' ';
    }

    public static void makeMove(char[][] board, char player, int xpos, int ypos) {
        if (board[xpos][ypos] == ' ') {
            board[xpos][ypos] = player;
        }
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    public static char winner(char[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[0][0] == board[i][2]) {
                return board[i][0];
            }
            else if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return board [0][i];
            }
            else if (board[0][0] == board[1][1] && board [0][0] == board[2][2] || board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                return board[1][1];
            }
            else if (isBoardFull(board)) {
                return ' ';
            }

        }
        return ' ';
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        String move;
        int xpos;
        int ypos;
        char player = 'X';

        clearBoard(board);
        printBoard(board);

        while (!isBoardFull(board) && !quit) {
            System.out.printf("Enter move for %c: ", player);
            move = input.next();
            System.out.print(move + '\n');
            if (move.charAt(0) == 'A') {
                xpos = 0;
            }
            else if (move.charAt(0) == 'B') {
                xpos = 1;
            }
            else {
                xpos = 2;
            }
            ypos = Integer.parseInt(String.valueOf(move.charAt(1)))-1;
            if(canMakeMove(board, xpos, ypos)) {
                makeMove(board, player, xpos, ypos);
            }
            printBoard(board);
            if (winner(board) != ' ') {
                System.out.printf("The winner is %c", player);
                quit = true;
            }
            if (player == 'X') {
                player = 'O';
            }
            else {
                player = 'X';
            }
        }
        }

}
