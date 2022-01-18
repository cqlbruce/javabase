package sun.al.leetcode;

public class SudokuSolver {


    public static void main(String[] args) {

        //[['5','3','.','.','7','.','.','.','.'],
        // ['6','.','.','1','9','5','.','.','.'],
        // ['.','9','8','.','.','.','.','6','.'],
        // ['8','.','.','.','6','.','.','.','3'],
        // ['4','.','.','8','.','3','.','.','1'],
        // ['7','.','.','.','2','.','.','.','6'],
        // ['.','6','.','.','.','.','2','8','.'],
        // ['.','.','.','4','1','9','.','.','5'],
        // ['.','.','.','.','8','.','.','7','9']]
        
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


        solveSudoku(board);

        for (int i=0 ; i<board.length ; i++){
            for(int j=0; j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }



    public static boolean solveSudoku(char[][] board){

        for (int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                if (board[i][j]=='.'){
                    for (int k=0 ; k<9 ; k++){
                        if (checkBox(board ,k , i , j )){
                            board[i][j]=(char)k ;
                            if (solveSudoku(board)){
                               return true;
                            }else {
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



    public static boolean checkBox(char[][] board , int index , int row , int col){

        for(int i=0 ; i<board.length ; i++){
            if (board[row][i]==index){
                return false;
            }
        }

        for (int i=0; i<board[0].length;i++){
            if (board[i][col]==index){
                return false;
            }
        }


        int rowIndex = row/3 ;
        int colIndex = col/3;

        for (int i=0 ; i<3;i++){
            for (int j=0;j<3;j++){
                System.out.println(rowIndex*3+i+"------"+colIndex*3+j);
                if (board[rowIndex*3+i][colIndex*3+j]==index){
                    return false ;
                }
            }
        }
//
//        for (int i=0 ; i<(rowIndex+1)*2;i++){
//            for (int j=0;j<(colIndex+1)*2;j++){
//                System.out.println(rowIndex*3+i+"------"+colIndex*3+j);
//                if (board[rowIndex*3+i][colIndex*3+j]==index){
//                    return false ;
//                }
//            }
//        }

        return true;
    }


}
