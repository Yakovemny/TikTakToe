import java.util.Scanner;

public class Main2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
/*
        System.out.println("---");
        System.out.println("---");
        System.out.println("---");

        //inserted 1,1
        System.out.println("X--");
        System.out.println("---");
        System.out.println("---");

 */
        //קלט לא תקין כאשר הוכנס צמד מס תפוס בלוח או צמד שלא קיים בלוח
        int[][] board = new int[3][3];
        int turn = 1; // x == 1 , O == 2 , 0 == '-'
        //board[1][2] = 1; // [lines] [rows]
        //drawBoard(board);
        tikTakToe(board);
    }
    public static boolean isGameOver(int[][] board){
        boolean ans = false;
        // diagnonal left to right
        // X - -
        // - X -
        // - - X
        /*
        case 2:
        diagnoanl right to left
        // - - X
        // - X -
        // X - -
        case 3:
        all the first line
        case 4:
        all the second line
        case 5:
        the third line
        case 6 + 7 + 8:
        The columns by a universal method
         */
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        if(board[2][0] == board[1][1] && board[1][1] == board[0][2])
            return true;
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2])
            return true;
        if(board[1][0] == board[1][1] && board[1][1] == board[1][2])
            return true;
        if(board[2][0] == board[2][1] && board[2][1] == board[2][2])
            return true;
        for(int i = 0 ; i < board.length; i++){
            ans = checkColumns(board , i);
        }
        return ans;
    }
    public static boolean checkColumns(int[][] board , int columns){
        boolean ans = true;
        for(int i = 0 ; i < board.length-1; i++){
            if(!(board[i][columns] == board[i+1][columns]))
                ans = false;
        }
        return ans;
    }
    public static void drawBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
           //System.out.println(board[i][0]);
            for(int j = 0 ; j < board[i].length; j++){
                //System.out.print(board[i][j]);
                if(board[i][j] == 0)
                    System.out.print('-');
                if(board[i][j] == 1)
                    System.out.print('x');
                if(board[i][j] == 2)
                    System.out.print('O');

            }
            System.out.println();
        }
    }
    public static void turns(String[] str , int[][] board , int choice){
        int lines = Integer.parseInt(str[0]);
        int columns = Integer.parseInt(str[1]);
        board[lines][columns] = choice;
    }
    public static void tikTakToe(int[][] board){
        drawBoard(board);
        int Player1 = 1; // 1 == X , 2 == O
        int Player2 = 2; // 1 == X , 2 == O
        System.out.println("Player " + Player1 + " turn");
        System.out.println("Where do you want to put your sign?");
        String ans = sc.next();
        String[] send = ans.split(",");
        turns(send, board, Player1);
        System.out.println("Player " + Player2 + " turn");
        turns(send, board, Player2);
        while(isGameOver(board)) {
            drawBoard(board);
            System.out.println("Player " + Player1 + " turn");
            System.out.println("Where do you want to put your sign?");
            ans = sc.next();
            send = ans.split(",");
            turns(send, board, Player1);
            System.out.println("Player " + Player2 + " turn");
            turns(send, board, Player2);
        }

        // 0,0
    }
}
