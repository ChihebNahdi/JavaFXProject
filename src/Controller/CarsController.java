/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Car;
import service.CarService;

/**
 * FXML Controller class
 *
 * @author chihe
 */
public class CarsController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txt_car_id;
    @FXML
    private TextField txt_car_brand;
    @FXML
    private TextField txt_car_model;
    @FXML
    private TextField txt_car_image;
    @FXML
    private TextField txt_km;
    @FXML
    private TextField txt_price;
    @FXML
    private TextField txt_color;
    @FXML
    private TableView<Car> table;
    
    @FXML
    private Button btn_ADD;
    @FXML
    private Button Reservations_Page;
    @FXML
    private Button btn_UPDATE;
    @FXML
    private Button btn_DELETE;
    @FXML
    private Button btn_REFRESH;
    @FXML
    private Button btn_RESET;
   
 
    @FXML
    private TableColumn<?, ?> img;
    @FXML
    private TableColumn<?, ?> color;
    @FXML
  
 
    
    private TableColumn<Car, Integer> id;
    @FXML
    private TableColumn<Car, String> brand;
    @FXML
    private TableColumn<Car, String> model;
    @FXML
    private TableColumn<Car, Integer> km;
    @FXML
    private TableColumn<?, ?> price;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         CarService ps = new CarService();
        ArrayList<Car> car_list = ps.getAll();
       ObservableList<Car> obs=FXCollections.observableArrayList(car_list);

        id.setCellValueFactory(new PropertyValueFactory<>("Car_id"));
        brand.setCellValueFactory(new PropertyValueFactory<>("Car_brand"));
        model.setCellValueFactory(new PropertyValueFactory<>("Car_model"));
        km.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        img.setCellValueFactory(new PropertyValueFactory<>("imgSrc"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        table.setItems(obs);
    }   
    public void UpdateTable(){
         
        CarService ps = new CarService();
        ArrayList<Car> car_list = ps.getAll();
       ObservableList<Car> obs=FXCollections.observableArrayList(car_list);

        id.setCellValueFactory(new PropertyValueFactory<>("Car_id"));
        brand.setCellValueFactory(new PropertyValueFactory<>("Car_brand"));
        model.setCellValueFactory(new PropertyValueFactory<>("Car_model"));
        km.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        img.setCellValueFactory(new PropertyValueFactory<>("imgSrc"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        table.setItems(obs);
          }
public void Reset(){
            txt_car_brand.clear();
            txt_car_id.clear();
            txt_car_image.clear();
            txt_price.clear();
            txt_km.clear();
            txt_color.clear();
             txt_car_model.clear();
         
        }
    @FXML
    private void AddVol(ActionEvent event) {
        Car c = new Car(Integer.parseInt(txt_car_id.getText()),txt_car_brand.getText(),txt_car_model.getText(),txt_car_image.getText(),Integer.parseInt(txt_km.getText()),Double.parseDouble(txt_price.getText()),txt_color.getText());
        CarService ps= new CarService();
        ps.insertPst(c);
        
        UpdateTable();
        Reset();
    }

    

    @FXML
    private void UpdateVol(ActionEvent event) {
    }

    @FXML
    private void DeleteVol(ActionEvent event) {
        Car carselected = table.getSelectionModel().getSelectedItem();
        int Car_idselected = carselected.getCar_id();
            CarService ps = new CarService();
         ps.delete(carselected);
          
          UpdateTable();
          Reset(); 
    }

   @FXML
    private void handleButtonRes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/Car_Reservations.fxml"));
        rootPane.getChildren().setAll(pane);
        
    }
    
}
