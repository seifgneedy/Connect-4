package application;

import Util.*;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class GameController {
    @FXML
    private Circle turnColor;
    @FXML
    private Text turnName;
    @FXML
    private HBox boardBox;
    private int width,height;
    private boolean playerTurn = true;
    private char[][] board;
    private Color pColor = Color.rgb(230, 255, 7),
                aColor = Color.rgb(198, 10, 10);
    private String pName = "Player",
                aName = "AI";
    public void initialize(){
        width = boardBox.getChildren().size();
        height = ((VBox)boardBox.getChildren().get(0)).getChildren().size();
        board = new char[height][width];
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                board[i][j] = '_';
        turnColor.setFill(pColor);
        turnName.setText(pName);
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
        turnColor.setFill(aColor);
        turnName.setText(aName);
        aiTurn();

        playerTurn = true;
        turnColor.setFill(pColor);
        turnName.setText(pName);
        if(Util.isTerminal(board)){
            endOfGame();
        }
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
    private void endOfGame(){
        /////////////////////////
        ///////////////////////
        /////////////////////////
        //////////////////////////
        ////////////////////////
        //////////////////////////
        ///////////////
    }
    @FXML
    private void backToMainMenu(){
        for(int j=0; j<board[0].length; j++){
            VBox column = (VBox)boardBox.getChildren().get(j);
            for(int i=0; i<board.length; i++){
                board[i][j] = '_';
                ((Circle)column.getChildren().get(i)).setFill(Color.WHITE);
            }
        }
        playerTurn = true;// just to be safe
        Main.stage.setScene(Main.loadedScenes[0]);
    }
}