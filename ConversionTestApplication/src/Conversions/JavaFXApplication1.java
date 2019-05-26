
package Conversions;

import ConversionTable.ConversionTable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setResizable(false);
        primaryStage.setTitle("Conversion Table");
        //Set Icon 
        primaryStage.getIcons().add(new Image(JavaFXApplication1.class.getResourceAsStream("images.png")));
        //Load Premade Scene
        primaryStage.setScene(ConversionTable.getTable(primaryStage));

    }


    public static void main(String[] args) {
        launch(args);
    }

}
