/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

/**
 * FXML Controller class
 *
 * @author
 */
public class AddProductController implements Initializable {
    
    Stage stage;
    Parent scene;
    
    @FXML
    public TableView<Part> partsTable;
    
    @FXML
    private TableColumn<Part, Integer> partIdCol;

    @FXML
    private TableColumn<Part, Integer> partNameCol;

    @FXML
    private TableColumn<Part, Integer> invLevCol;

    @FXML
    private TableColumn<Part, Double> priceCol;
    
    @FXML
    private TableView<Part> associatedPartsTable;

    @FXML
    private TableColumn<Part, Integer> associatedPartIdCol;

    @FXML
    private TableColumn<Part, Integer> associatedPartNameCol;

    @FXML
    private TableColumn<Part, Integer> associatedInvLevCol;

    @FXML
    private TableColumn<Part, Double> associatedPriceCol;
    
    @FXML
    private TextField productNameField;

    @FXML
    private TextField productInvLevField;

    @FXML
    private TextField productMaxField;

    @FXML
    private TextField productIdField;
    
    @FXML
    private TextField productPriceField;

    @FXML
    private TextField productMinField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
