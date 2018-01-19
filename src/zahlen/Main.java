package zahlen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends javafx.application.Application {

	private Stage primaryStage;
	private AnchorPane pane;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		mainWindow();

	}

	public void mainWindow() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("ZahlenKonverterView.fxml"));
			pane = loader.load();
			
			ZahlenKonverterController zkc = loader.getController();

			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);

	}
}