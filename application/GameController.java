package application;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class GameController {
    @FXML
    private Circle turnColor;
    @FXML
    private HBox boardBox;
    private int width,height;
    private boolean playerTurn = true;
    private char[][] board;
    private Color pColor = Color.rgb(230, 255, 7),
                aColor = Color.rgb(198, 10, 10);
    public void initialize(){
        width = boardBox.getChildren().size();
        height = ((VBox)boardBox.getChildren().get(0)).getChildren().size();
        board = new char[height][width];
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                board[i][j] = '_';
        turnColor.setFill(pColor);
    }
    @FXML
    private void selectColumn(Event event){
        event.consume();
        if( ! playerTurn )
            return;
        playerTurn = false;
        boolean notFound = true;
        int w = boardBox.getChildren().indexOf(event.getSource());
        int h;
        for(h=height-1; h>=0; h--){
            if(board[h][w] == '_'){
                notFound = false;
                board[h][w] = 'a';
                break;
            }
        }
        // column is full
        if(notFound)
            return;
        ((Circle)((VBox) event.getSource()).getChildren().get(h)).setFill(pColor);

        aiTurn();
        
        playerTurn = true;
        //if board is full

    }
    private void aiTurn(){
        char[][] nextBoard = Main.solver.Decision(board);
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(nextBoard[i][j] != board[i][j]){
                    // this is the AI move
                    VBox col = (VBox)boardBox.getChildren().get(j);
                    ((Circle)col.getChildren().get(i)).setFill(aColor);
                    board = nextBoard;
                    return;
                }
            }
        }
    }
}