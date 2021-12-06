package application;

import java.io.IOException;

import Util.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {
    @FXML
    private Circle turnColor;
    @FXML
    private Text turnName;
    @FXML
    private HBox boardBox;
    private int width,height;
    private boolean playerSuccess = false;
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
        boolean notFound = true;
        int w = boardBox.getChildren().indexOf(event.getSource());
        int h;
        for(h=height-1; h>=0; h--){
            if(board[h][w] == '_'){
                notFound = false;
                board[h][w] = 'p';
                playerSuccess = true;
                break;
            }
        }
        // column is full
        if(notFound){
            playerSuccess = false;
            return;
        }
        ((Circle)((VBox) event.getSource()).getChildren().get(h)).setFill(pColor);
        turnColor.setFill(aColor);
        turnName.setText(aName);
        event.consume();
    }
    @FXML
    private void aiTurn(){
        if( ! playerSuccess)
            return;
        char[][] nextBoard = Main.solver.Decision(board);
        boolean found = false;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(nextBoard[i][j] != board[i][j]){
                    // this is the AI move
                    VBox col = (VBox)boardBox.getChildren().get(j);
                    ((Circle)col.getChildren().get(i)).setFill(aColor);
                    board = nextBoard;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        turnColor.setFill(pColor);
        turnName.setText(pName);
        playerSuccess = false;
        if(Util.isTerminal(board)){
            endOfGame();
        }
    }
    private void endOfGame(){
        Heuristic h = new Heuristic();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
        Main.scores[0] = h.getPlayerSore(board);
        System.out.println( h.getPlayerSore(board));
        Main.scores[1] = h.getAIScore(board);
        System.out.println( h.getAIScore(board));
        try {
            Parent root = FXMLLoader.load(getClass().getResource("endGameScene.fxml"));
		    Scene scene = new Scene(root);
            Stage winningStage = new Stage();
            winningStage.setScene(scene);
            winningStage.setResizable(false);
            winningStage.show();
        } catch (IOException e) {
            System.out.println("Problem with endGameScene.fxml");
            System.out.println("Player: "+Main.scores[0]+"\nAI: "+ Main.scores[1]);
            e.printStackTrace();
        }
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
        playerSuccess = false;// just to be safe
        Main.stage.setScene(Main.loadedScenes[0]);
    }
}