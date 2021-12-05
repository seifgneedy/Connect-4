package Algorithm;
import Util.*;
public class MinMax implements Algorithm {
    int maxDepth;
    Heuristic heuristic;
    public MinMax(int k){
        this.maxDepth=k;
        heuristic=new Heuristic();
    }
    @Override
    public char[][] Decision(char[][] board) {
        return maximize(board, maxDepth).getBoard();
    }

    State maximize(char[][] board,int k){
        if(k==maxDepth||Util.isTerminal(board))
            return new State(null,heuristic.eval(board));
        State state = new State(null,Integer.MIN_VALUE);
        for(char[][] child : Util.getNeighbours(board, true)){
            State childState=minimize(child, k-1);
            if(childState.utility > state.utility)
                state=new State(child,childState.utility);
        }        
        return state;
    }

    State minimize(char[][] board,int k){
        if(k==maxDepth||Util.isTerminal(board))
            return new State(null,heuristic.eval(board));
        State state = new State(null,Integer.MAX_VALUE);
        for(char[][] child : Util.getNeighbours(board, false)){
            State childState=maximize(child, k-1);
            if(childState.utility < state.utility)
                state=new State(child,childState.utility);
        }        
        return state;
    }
    
}
