package sun.al.leetcode;

public class SudokuSolver01 {


    public static void main(String[] args) {


        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };


        helper(board);

        for (int i=0 ; i<board.length ; i++){
            for(int j=0; j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static boolean helper(char[][] board){
        for (int i=0 ; i<board.length ; i++){
            for (int j=0 ; j<board[0].length ; j++){
                if (board[i][j]=='.'){
                    for (char num='1';num<='9';num++){
                        if (isValid(board,i,j,num)){
                            board[i][j]=num;
                            if (!helper(board)){
                                board[i][j]='.';
                            }else{
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board , int i , int j , char num){

        for(int row=0 ; row <9 ; row++){
            if (board[row][j] == num){
                return false;
            }
        }

        for (int col =0 ;col<9 ; col++){
            if (board[i][col]==num){
                return false;
            }
        }

        for(int row=i/3*3 ; row <i/3*3+3 ; row++){
            for (int col=j/3*3 ; col<j/3*3+3 ; col++){
                if (board[row][col]==num){
                    return false;
                }
            }
        }

        return true;
    }



}
