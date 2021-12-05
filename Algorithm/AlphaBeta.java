package Algorithm;
import Util.*;
public class AlphaBeta implements Algorithm {
    int maxDepth;
    Heuristic heuristic;
    AlphaBeta(int k){
        this.maxDepth=k;
        heuristic = new Heuristic();
    }
    @Override
    public char[][] Decision(char[][] board) {
        return maximize(board, maxDepth, Integer.MIN_VALUE, Integer.MAX_VALUE).getBoard();
    }
    State maximize(char[][] board,int k,int alpha,int beta){
        if(k==maxDepth||Util.isTerminal(board))
            return new State(null,heuristic.eval(board));
        State state = new State(null,Integer.MIN_VALUE);

        for(char[][] child : Util.getNeighbours(board, true)){
            State childState=minimize(child, k-1,alpha,beta);
            if(childState.utility > state.utility)
                state=new State(child,childState.utility);
            if(state.utility >= beta)
                break;
            if(state.utility>alpha)
                alpha=state.utility;
        }        
        return state;
    }
    
    State minimize(char[][] board,int k,int alpha,int beta){
        if(k==maxDepth||Util.isTerminal(board))
            return new State(null,heuristic.eval(board));
        State state = new State(null,Integer.MAX_VALUE);
        for(char[][] child : Util.getNeighbours(board, false)){
            State childState=maximize(child, k-1,alpha,beta);
            if(childState.utility < state.utility)
                state=new State(child,childState.utility);
            if(state.utility<=alpha)
                break;
            if(state.utility<beta)
                beta=state.utility;
        }        
        return state;
    }
}
