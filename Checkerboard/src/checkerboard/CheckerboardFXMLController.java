/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Lydia
 */
public class CheckerboardFXMLController implements Initializable {
    
    @FXML
    VBox vbox = new VBox();
    
    @FXML
    MenuBar menubar = new MenuBar();
    
    @FXML
    AnchorPane anchorPane;
    
    private Checkerboard checkerboard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void ready(int rows, int cols) {
        ChangeListener<Number> listener = new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                clearBoard();
                refreshWithColors(checkerboard.getNumRows(), checkerboard.getNumCols(), checkerboard.getLightColor(), checkerboard.getDarkColor());
            } 
        };
        
        vbox.widthProperty().addListener(listener);
        vbox.heightProperty().addListener(listener);
        
        refreshDefault(rows, cols);
    }
    
    public void refresh()
    {
        checkerboard.build();
        this.anchorPane = checkerboard.getBoard();
        vbox.getChildren().add(anchorPane);
    }
    
    public void refreshDefault(int rows, int cols) {
        checkerboard = new Checkerboard(rows, cols, vbox.getWidth(), vbox.getHeight() - menubar.getHeight());
        refresh();
    }
    
    public void refreshWithColors(int rows, int cols, Color light, Color dark) {
        checkerboard = new Checkerboard(rows, cols, vbox.getWidth(), vbox.getHeight() - menubar.getHeight(), light, dark);
        refresh();
    }
    
    public void changeDimensions(int rows, int cols)
    {
        clearBoard();
        refreshWithColors(rows, cols, checkerboard.getLightColor(), checkerboard.getDarkColor());
    }
    
    @FXML
    public void sixteenButton(ActionEvent event) 
    {
        changeDimensions(16, 16);
    }
    
    @FXML
    public void tenButton(ActionEvent event) 
    {
        changeDimensions(10, 10);
    }
    
    @FXML
    public void eightButton(ActionEvent event) 
    {
        changeDimensions(8, 8);
    }
    
    @FXML
    public void threeButton(ActionEvent event) {
        changeDimensions(3, 3);
    }
    
    @FXML
    public void handleColorDefault(ActionEvent event) {
        clearBoard();
        refreshWithColors(checkerboard.getNumRows(), checkerboard.getNumCols(), Color.RED, Color.BLACK);
    }
    
    @FXML
    public void handleColorBlue(ActionEvent event) {
        clearBoard();
        refreshWithColors(checkerboard.getNumRows(), checkerboard.getNumCols(), Color.SKYBLUE, Color.DARKBLUE);
    }
    
    public void clearBoard() {
        checkerboard.getBoard().getChildren().clear();
    }

}

