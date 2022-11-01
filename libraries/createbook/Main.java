package libraries.createbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static Stage rootStage;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addbook.fxml")));
        primaryStage.setTitle("ADD BOOK");
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.show();
    }
}
