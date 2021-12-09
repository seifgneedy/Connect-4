package Algorithm;
import java.io.FileWriter;
import java.io.IOException;

import Util.*;
public class MinMax implements Algorithm {
    int maxDepth;
    Heuristic heuristic;
    boolean printTree;
    int treeSize;
    
    public MinMax(int k){
        this.maxDepth=k;
        heuristic=new Heuristic();
    }
    @Override
    public char[][] Decision(char[][] board, boolean printTree) {
        this.printTree = printTree;
        if(printTree) {
    		FileWriter output;
    		try {
    			output = new FileWriter("tree.txt");
    			output.write("");
    			output.flush();
    			output.close();
    		} catch (IOException e) {
    			System.out.println("Failed to opne the tree file.\n");		}
        }
        treeSize = 0;
		long startTime = System.nanoTime();
    	char[][] res = maximize(board, 0).getBoard();
		long endTime = System.nanoTime();
    	System.out.println("Nodes Expanded = " + treeSize + " Time taken = " +(endTime - startTime) / 1000000 + " ms");
    	return res;
    }

    State maximize(char[][] board,int k){
    	treeSize++;
        if(k==maxDepth||Util.isTerminal(board)) {
        	int eval = heuristic.eval(board);
        	if(printTree)
            	Util.print(board,k,maxDepth,eval);
            return new State(null,eval);
        }
        if(printTree)
        	Util.print(board,k,maxDepth,-1);
        State state = new State(null,Integer.MIN_VALUE);
        for(char[][] child : Util.getNeighbours(board, true)){
            State childState=minimize(child, k+1);
            if(childState.utility > state.utility)
                state=new State(child,childState.utility);
        }        
        return state;
    }

    State minimize(char[][] board,int k){
    	treeSize++;
        if(k==maxDepth||Util.isTerminal(board)) {
        	int eval = heuristic.eval(board);
        	if(printTree)
        		Util.print(board,k,maxDepth,eval);
            return new State(null,eval);
        }
        if(printTree)
        	Util.print(board,k,maxDepth,-1);
        State state = new State(null,Integer.MAX_VALUE);
        for(char[][] child : Util.getNeighbours(board, false)){
            State childState=maximize(child, k+1);
            if(childState.utility < state.utility)
                state=new State(child,childState.utility);
        }        
        return state;
    }
    
}
