/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.InHouse;
import model.Outsourced;
import model.Inventory;

/**
 * FXML Controller class
 *
 * @author 
 */
public class AddPartController implements Initializable {
    
    Stage stage;
    Parent scene;
    
    @FXML
    private Label partTypeLbl;
    
    @FXML
    private TextField partIdField;

    @FXML
    private TextField partNameField;

    @FXML
    private TextField invLevField;

    @FXML
    private TextField partPriceField;

    @FXML
    private TextField maxField;

    @FXML
    private TextField machIdCompNmField;

    @FXML
    private TextField minField;
    
    private RadioButton inHouseBtn;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton outsourcedBtn;
    
    private boolean inHouse;
    
    @FXML
    void inHouseBtn(ActionEvent event) {
        inHouse = false;
        partTypeLbl.setText("Machine ID");
    }

    @FXML
    void outsourcedBtn(ActionEvent event) {
        inHouse = true;
        partTypeLbl.setText("Company Name");
    }
    
    //Create an alert that notify's
    //The user they are about to cancel out
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "All values will be lost, are you sure you want to cancel?");
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.isPresent() && result.get() == ButtonType.OK){
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
 
    }
    
    //Create a new part
    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {
       
        try{
            
            int id = Integer.parseInt(partIdField.getText());
            String name = partNameField.getText();
            double price = Double.parseDouble(partPriceField.getText());
            int stock = Integer.parseInt(invLevField.getText());
            int min = Integer.parseInt(minField.getText());
            int max = Integer.parseInt(maxField.getText());            
            
            //Min must never be greater than Max
            //Check to see
            if(min > max) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error dialog");
                alert.setContentText("The min value cannot be larger than the max value!");
                alert.showAndWait();
            }else{
            
            //Check if part being added is In House
            //Or Outsourced
            if (inHouseBtn.isSelected()) {
                int machineId = Integer.parseInt(machIdCompNmField.getText());
                InHouse addPart = new InHouse(id, name, price, stock, min, max, machineId);

                Inventory.addPart(addPart);
            }
            
            if (outsourcedBtn.isSelected()) {
                String companyName = machIdCompNmField.getText();
                Outsourced addPart = new Outsourced(id, name, price, stock, min, max, companyName);
                
                Inventory.addPart(addPart);  
            } 
            
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
           } 
        //Checking for errors
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error dialog");
            alert.setContentText("Please enter a valid value for each textfield!");
            alert.showAndWait();
        }
             
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
