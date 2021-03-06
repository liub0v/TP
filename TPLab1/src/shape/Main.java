package shape;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("DrawApp");
        DrawFrame root = new DrawFrame();
        Scene scene = new Scene(root, 700, 600);
        scene.getStylesheets().add((getClass().getResource("style.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
