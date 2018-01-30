/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lydia
 */
public class Startable extends Application {
     @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckerboardFXML.fxml"));
        Parent root = loader.load();
        CheckerboardFXMLController controller = loader.getController();
        
        Scene scene = new Scene(root,500,500);
        
        stage.setScene(scene);
        stage.show();
        controller.ready(8, 8);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
