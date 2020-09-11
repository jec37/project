/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invsystem_joechavez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Part;

/**
 *
 * @author 
 */
public class InvSystem_app extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        * Let's fill the main screen with some sample parts
        * and products.
        */
        
        Part part1 = new InHouse(1, "Part 1", 4.99, 25, 1, 1, 5);
        Inventory.addPart(part1);
        Part part2 = new InHouse(2, "Part 2", 24.99, 50, 1, 1, 6);
        Inventory.addPart(part2);
        
        
        launch(args);
    }
    
}
