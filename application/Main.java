package application;
	
import Algorithm.Algorithm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
    public static Stage stage;
    public static Algorithm solver;
    public static Scene[] loadedScenes;
	@Override
	public void start(Stage primaryStage) {
        loadedScenes = new Scene[2];
        Main.stage = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
			Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            loadedScenes[0] = scene;
            primaryStage.setScene(scene);
			primaryStage.show();
            loadedScenes[1] = new Scene(FXMLLoader.load(getClass().getResource("gameScene.fxml")));
		} catch(Exception e) {
			e.printStackTrace();
		}
        
	}
	public static void main(String[] args) {
		launch(args);
	}
}
