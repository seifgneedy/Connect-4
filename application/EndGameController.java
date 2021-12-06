package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class EndGameController {
    @FXML
    private Text goodLuckText;
    @FXML
    private Text pScore;
    @FXML
    private Text aScore;
    @FXML
    private AnchorPane pane;
    public void initialize(){
        pScore.setText(""+ Main.scores[0]);
        aScore.setText(""+ Main.scores[1]);
        String msg;
        if(Main.scores[0] > Main.scores[1]){
            msg = "Congratulations";
            pane.setStyle("-fx-background-color: #7FFF00");
        }else if (Main.scores[0] == Main.scores[1]){
            msg = "Draw";
            pane.setStyle("-fx-background-color: #FFD700");
        }else{
            msg = "Lost";
            pane.setStyle("-fx-background-color: #FF0000");
        }
        goodLuckText.setText(msg);
    }
    @FXML
    private void ok(Event event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }
}
