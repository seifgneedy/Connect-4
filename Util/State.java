package Util;
import java.util.*;

public class State {
    char[][] board;
    public int utility;
    final int LENGTH=6;
    final int WIDTH=7;
    State(){
        board=new char[LENGTH][WIDTH];
        for(int i=0;i<LENGTH;i++)
            Arrays.fill(board[i], '_');
    }
    public State(char[][] board,int utility){
        this.board=board;
        this.utility=utility;
    }
    
    public char[][] getBoard(){
        return board;
    }
    
}
