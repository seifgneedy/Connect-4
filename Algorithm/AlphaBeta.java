package Algorithm;
import Util.*;
public class AlphaBeta implements Algorithm {
    int maxDepth;
    AlphaBeta(int k){
        this.maxDepth=k;
    }
    @Override
    public char[][] Decision(char[][] board) {
        return maxUtil(board, maxDepth, Integer.MIN_VALUE, Integer.MAX_VALUE).getBoard();
    }
    State maxUtil(char[][] board,int k,int alpha,int beta){
        // TODO : kassem
        return null;
    }
    State minUtil(char[][] board,int k,int alpha,int beta){
        //TODO: Fawzy
        return null;
    }
}
