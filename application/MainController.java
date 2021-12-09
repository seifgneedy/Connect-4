package application;
import Algorithm.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class MainController {
    @FXML
    private TextField maxDepthField;
    @FXML
    private Text onlyDigitsWarning;
    @FXML
    private RadioButton miniMaxButton;
    @FXML
    private CheckBox printTheTreeBox;
	@FXML
    private void start(){
        int maxDepth;
        try{
            maxDepth = Integer.parseInt(maxDepthField.getText());
        }catch(NumberFormatException e){
            onlyDigitsWarning.setVisible(true);
            return;
        }
        onlyDigitsWarning.setVisible(false);
        if(miniMaxButton.isSelected())
            Main.solver = new MinMax(maxDepth);
        else
            Main.solver = new AlphaBeta(maxDepth);
        maxDepthField.clear();
        Main.printTheTree = printTheTreeBox.isSelected();
        printTheTreeBox.setSelected(false);
        Main.stage.setScene(Main.loadedScenes[1]);
    }

    @FXML
    private void exit(){
        System.exit(0);
    }
}