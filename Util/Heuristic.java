package Util;


public class Heuristic {
	 final int LENGTH=6;
	 final int WIDTH=7;
    public int eval(char[][] board){
      int util=0;
      util+=(getAIScore(board)+NumOfConnect_4(board, true))*10000;
      util-=(getPlayerSore(board)+NumOfConnect_4(board, false))*10000;
      util+=(getAIScore(board)+NumOfConnect_3(board, true))*100;
      util-=(getPlayerSore(board)+NumOfConnect_3(board, false))*100;
      util+=(getAIScore(board)+NumOfConnect_2(board, true))*10;
      util-=(getPlayerSore(board)+NumOfConnect_2(board, false))*10;
      
        return util;
    }
    public int getAIScore(char[][] board){
   
       return NumOfConnect_4(board, true);
    }
    public  int getPlayerSore(char[][] board){
        
        return NumOfConnect_4(board, false);
    }
    
    private int NumOfConnect_4(char[][] board, boolean AI) {
    	int num=0;
    	char piece;
    	if(AI) piece='a';
    	else piece='p';
    	
    	
    	 //horizontal
        for(int i=0;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i][j+1]==piece &&board[i][j+2]==piece &&board[i][j+3]==piece ) num++;
        
        //vertical
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH;j++)
                    if(board[i][j]==piece && board[i+1][j]==piece &&board[i+2][j]==piece &&board[i+3][j]==piece ) num++;
        
        //negative diagonal
        for(int i=3;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i-1][j+1]==piece &&board[i-2][j+2]==piece &&board[i-3][j+3]==piece ) num++;
        
        //positive diagonal
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i+1][j+1]==piece &&board[i+2][j+2]==piece &&board[i+3][j+3]==piece ) num++;

    	
    	return num; 
    }
    
    private int NumOfConnect_3(char[][] board, boolean AI) {
    	int num=0;
    	char piece;
    	if(AI) piece='a';
    	else piece='p';
    
    	 for(int i=0;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]=='_' && board[i][j+1]==piece &&board[i][j+2]==piece&&board[i][j+3]==piece ) num++;
         
         for(int i=0;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i][j+1]=='_' &&board[i][j+2]==piece&&board[i][j+3]==piece ) num++;
         
         for(int i=0;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i][j+1]==piece &&board[i][j+2]=='_'&&board[i][j+3]==piece ) num++;
         
         for(int i=0;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i][j+1]==piece &&board[i][j+2]==piece&&board[i][j+3]=='_' ) num++;
         
         //vertical
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH;j++)
                     if(board[i][j]=='_' && board[i+1][j]==piece &&board[i+2][j]==piece &&board[i+3][j]==piece ) num++;
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH;j++)
                     if(board[i][j]==piece && board[i+1][j]=='_' &&board[i+2][j]==piece &&board[i+3][j]==piece ) num++;
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH;j++)
                     if(board[i][j]==piece && board[i+1][j]==piece &&board[i+2][j]=='_' &&board[i+3][j]==piece ) num++;
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH;j++)
                     if(board[i][j]==piece && board[i+1][j]==piece &&board[i+2][j]==piece &&board[i+3][j]=='_' ) num++;
         
         //negative diagonal
         for(int i=3;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]=='_' && board[i-1][j+1]==piece &&board[i-2][j+2]==piece &&board[i-3][j+3]==piece ) num++;
         for(int i=3;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i-1][j+1]=='_' &&board[i-2][j+2]==piece &&board[i-3][j+3]==piece ) num++;
         for(int i=3;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i-1][j+1]==piece &&board[i-2][j+2]=='_' &&board[i-3][j+3]==piece ) num++;
         for(int i=3;i<LENGTH;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i-1][j+1]==piece &&board[i-2][j+2]==piece &&board[i-3][j+3]=='_' ) num++;
         
         //positive diagonal
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]=='_' && board[i+1][j+1]==piece &&board[i+2][j+2]==piece &&board[i+3][j+3]==piece ) num++;
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i+1][j+1]=='_' &&board[i+2][j+2]==piece &&board[i+3][j+3]==piece ) num++;
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i+1][j+1]==piece &&board[i+2][j+2]=='_' &&board[i+3][j+3]==piece ) num++;
         for(int i=0;i<LENGTH-3;i++)
             for(int j=0;j<WIDTH-3;j++)
                     if(board[i][j]==piece && board[i+1][j+1]==piece &&board[i+2][j+2]==piece &&board[i+3][j+3]=='_' ) num++;

    	return num;
    }
    
    private int NumOfConnect_2(char[][] board, boolean AI) {
    	int num=0;
    	char piece;
    	if(AI) piece='a';
        else piece='p';
    
    	//horizontal
        for(int i=0;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i][j+1]=='_' &&board[i][j+2]==piece&&board[i][j+3]==piece ) num++;
        
        for(int i=0;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i][j+1]==piece &&board[i][j+2]=='_'&&board[i][j+3]==piece ) num++;
        
        for(int i=0;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i][j+1]==piece &&board[i][j+2]==piece&&board[i][j+3]=='_' ) num++;
        
        for(int i=0;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i][j+1]=='_' &&board[i][j+2]==piece&&board[i][j+3]=='_' ) num++;
        
        for(int i=0;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i][j+1]=='_' &&board[i][j+2]=='_'&&board[i][j+3]==piece ) num++;
        
        for(int i=0;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i][j+1]==piece &&board[i][j+2]=='_'&&board[i][j+3]=='_' ) num++;
        
        //vertical
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH;j++)
                    if(board[i][j]=='_' && board[i+1][j]=='_' &&board[i+2][j]==piece &&board[i+3][j]==piece ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH;j++)
                    if(board[i][j]=='_' && board[i+1][j]==piece &&board[i+2][j]=='_' &&board[i+3][j]==piece ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH;j++)
                    if(board[i][j]=='_' && board[i+1][j]==piece &&board[i+2][j]==piece &&board[i+3][j]=='_' ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH;j++)
                    if(board[i][j]==piece && board[i+1][j]=='_' &&board[i+2][j]==piece &&board[i+3][j]=='_' ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH;j++)
                    if(board[i][j]==piece && board[i+1][j]=='_' &&board[i+2][j]=='_' &&board[i+3][j]==piece ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH;j++)
                    if(board[i][j]==piece && board[i+1][j]==piece &&board[i+2][j]=='_' &&board[i+3][j]=='_' ) num++;
        
        //negative diagonal
        for(int i=3;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i-1][j+1]=='_' &&board[i-2][j+2]==piece &&board[i-3][j+3]==piece ) num++;
        for(int i=3;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i-1][j+1]==piece &&board[i-2][j+2]=='_' &&board[i-3][j+3]==piece ) num++;
        for(int i=3;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i-1][j+1]==piece &&board[i-2][j+2]==piece &&board[i-3][j+3]=='_' ) num++;
        for(int i=3;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i-1][j+1]=='_' &&board[i-2][j+2]==piece &&board[i-3][j+3]=='_' ) num++;
        for(int i=3;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i-1][j+1]=='_' &&board[i-2][j+2]=='_' &&board[i-3][j+3]==piece ) num++;
        for(int i=3;i<LENGTH;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i-1][j+1]==piece &&board[i-2][j+2]=='_' &&board[i-3][j+3]=='_' ) num++;
        
        //positive diagonal
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i+1][j+1]=='_' &&board[i+2][j+2]==piece &&board[i+3][j+3]==piece ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i+1][j+1]==piece &&board[i+2][j+2]=='_' &&board[i+3][j+3]==piece ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]=='_' && board[i+1][j+1]==piece &&board[i+2][j+2]==piece &&board[i+3][j+3]=='_' ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i+1][j+1]=='_' &&board[i+2][j+2]==piece &&board[i+3][j+3]=='_' ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i+1][j+1]=='_' &&board[i+2][j+2]=='_' &&board[i+3][j+3]==piece ) num++;
        for(int i=0;i<LENGTH-3;i++)
            for(int j=0;j<WIDTH-3;j++)
                    if(board[i][j]==piece && board[i+1][j+1]==piece &&board[i+2][j+2]=='_' &&board[i+3][j+3]=='_' ) num++;
    return num;
    }
}
