package Util;

import java.util.*;

public class Util {
    public static char[][] cloneBoard(char[][] board){
        char[][] child=new char[board.length][];
        for(int i=0;i<board.length;i++){
            child[i]=board[i].clone();
        }
        return child;
    }
    public static List<char[][]> getNeighbours(char[][] board,boolean max){
        List<char[][]> neighbours=new ArrayList<>();
        for(int clm=0;clm<board[0].length;clm++){
            for(int row=board.length-1;row>=0;row--){
                if(board[row][clm]=='_'){
                    char[][] child= cloneBoard(board);
                    child[row][clm]=max?'a':'p';
                    neighbours.add(child);
                    break;
                }
            }
        }
        return neighbours;
    }
    public static boolean isTerminal(char[][] board){
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='_')
                    return false;
        return true;
    }
}
