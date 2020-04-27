package com.sun.al.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {


    public static void main(String[] args) {

        ValidSudoku vs = new ValidSudoku();

//        char[][] b = new char[][]{{'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};

        char[][] b = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };


//        vs.print(b);
        System.out.println(vs.isValildSudoku(b));
//        {'5','3','.','.','7','.','.','.','.'},
//        {'6','.','.','1','9','5','.','.','.'},
//        {'.','9','8','.','.','.','.','6','.'},
//        {'8','.','.','.','6','.','.','.','3'},
//        {'4','.','.','8','.','3','.','.','1'},
//        {'7','.','.','.','2','.','.','.','6'},
//        {'.','6','.','.','.','.','2','8','.'},
//        {'.','.','.','4','1','9','.','.','5'},
//        {'.','.','.','.','8','.','.','7','9'}

    }

    public boolean isValildSudoku(char[][] board){

        //行列不能有重复
        //3x3不能有重复
        //行不重复
        for (int i=0 ; i<board.length ; i++){
            Map<Character,Character> map = new HashMap<Character,Character>();
            for (int j=0 ; j<board[i].length ; j++){
                if ('.'!=board[i][j]&&map.get(board[i][j])!=null){
                    return false;
                }
                map.put(board[i][j],board[i][j]);
            }
        }
        //列不重复
        for (int j=0 ; j<board[0].length ; j++){
            Map<Character,Character> map = new HashMap<Character,Character>();
            for (int i=0 ; i<board.length;i++){
                if ('.'!=board[i][j]&&map.get(board[i][j])!=null){
                    return false;
                }
                map.put(board[i][j],board[i][j]);
            }
        }

        for (int i=0 ; i<3; i++){
            for (int j=0 ; j<3 ; j++){
                Map<Character,Character> map = new HashMap<Character,Character>();
                for (int r=i*3 ; r<(i+1)*3 ; r++){
                    for (int l=j*3 ; l<(j+1)*3 ; l++){
                        if ('.'!=board[r][l]&&map.get(board[r][l])!=null){
                            return false;
                        }
                        map.put(board[r][l],board[r][l]);
                    }
                }
            }
        }

        return true;

    }

    public void print(char[][] b){

        for (int i=0 ; i<b.length ; i++){
            for (int j=0;j<b[i].length;j++){
                System.out.print(b[i][j]);
            }
            System.out.println();
        }

    }


}
