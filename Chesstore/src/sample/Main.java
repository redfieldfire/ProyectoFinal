package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("PantallaMain.fxml"));
        primaryStage.setTitle("Chesstore");
        primaryStage.setScene(new Scene(root, 375, 595));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("./sample/img/icono.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
