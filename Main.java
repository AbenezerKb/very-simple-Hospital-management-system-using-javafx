package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FlowPane fp =new FlowPane();

      // .. fp.getChildren().add( lbBrand);
      //  fp.getChildren().add(tfBrand);
      //  primaryStage.setTitle("Car Sell Inventory");
        primaryStage.setScene(new Scene(fp, 300, 275));
        // primaryStage.show();
        Home home = new Home();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
