package shape;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("DrawApp");
        DrawFrame root = new DrawFrame();
        Scene scene = new Scene(root, 740, 600);
        scene.getStylesheets().add((getClass().getResource("style.css")).toExternalForm());
        primaryStage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/3/3e/White_pencil.png"));
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
