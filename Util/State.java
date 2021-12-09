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
    
    public static void main(String[] args) {
        // char[][] tst=new char[6][7];
        State state =new State();
        state.board[5][0]='a';
        state.board[5][1]='p';
        state.board[5][3]='a';
        state.board[5][6]='a';
        state.board[4][6]='a';
        state.board[3][6]='a';
        state.board[2][6]='a';
        state.board[1][6]='a';
        state.board[0][6]='a';
        List<char[][]> nn=Util.getNeighbours(state.board,true);
        System.out.println(nn.size());
    }
    
}
