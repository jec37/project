/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author
 */
public class Inventory {
    
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    /*
    * Parts
    */
    
    public static void addPart(Part newPart){
        allParts.add(newPart);
    }
    
    public Part searchPart(Part partSearch) {
        return null;
    }
    
    public static void updatePart(int index, Part selectedPart){
        
    }
    
    public static void deletePart(Part deletePart){
        
    }
    
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    
    /*
    * Products
    */
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }
    
    public Part searchProducts(Part productSearch) {
        return null;
    }
    
    public static void updateProduct(int index, Part selectedProduct){
        
    }
    
    public static void deleteProduct(Part deleteProduct){
        
    }
    
    
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
    
}
