/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.Date;
import model.Car;
import model.user;
import model.Car_reservation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CarService;
import service.UserService;
import service.ReservationCarService;
/**
 * FXML Controller class
 *
 * @author chihe
 */
public class Page_ac_adminController implements Initializable {

    @FXML
    private TableView<Car> table;
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
    @FXML
    private TableColumn<Car_reservation, Integer> id_res;
    @FXML
    private TableColumn<Car_reservation, Integer> id_car_res;
    @FXML
    private TableColumn<Car_reservation, Date> start_date;
    @FXML
    private TableColumn<Car_reservation, Date> end_date;
    @FXML
    private TableColumn<?, ?> price1;
    @FXML
    private TableColumn<Car_reservation, Integer> id_user;
    @FXML
    private TableColumn<Car_reservation, Double> price_res;
    @FXML
    private ChoiceBox<String> cb;
    private final String choix[]={"Update","Delete"};
    private int Car_idselected;
  
    @FXML
    private Button getchoix;
    @FXML
    private Label screen;
    @FXML
    private TableColumn<?, ?> img;
    @FXML
    private TableColumn<?, ?> color;
    private TableView<?> table11;
    @FXML
    private TableColumn<user, String> f_name;
    @FXML
    private TableColumn<user, String> l_name;
    @FXML
    private TableColumn<user, String> u_name;
    @FXML
    private TableColumn<user, String> password;
    @FXML
    private TableColumn<user, String> u_r;
    @FXML
    private TableColumn<user, Integer> id_u;
    @FXML
    private TableView<user> tabuser;
    @FXML
    private TableView<Car_reservation> tabres;

    /**
     * Initializes the controller class.
     */
    
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
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        
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
         cb.getItems().addAll(choix);
         
         UserService ps1 = new UserService();
        ArrayList<user> user_list = ps1.getAll();
       ObservableList<user> obss=FXCollections.observableArrayList(user_list);

        id_u.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        f_name.setCellValueFactory(new PropertyValueFactory<>("fisrt_name"));
        l_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        u_name.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        u_r.setCellValueFactory(new PropertyValueFactory<>("role"));
        
        tabuser.setItems(obss);
        
        
        ReservationCarService ps2 = new ReservationCarService();
        ArrayList<Car_reservation> carR = ps2.getAll();
       ObservableList<Car_reservation> obsc=FXCollections.observableArrayList(carR);

        id_res.setCellValueFactory(new PropertyValueFactory<>("Reservation_Car_id"));
        id_car_res.setCellValueFactory(new PropertyValueFactory<>("Car_id"));
       id_user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        start_date.setCellValueFactory(new PropertyValueFactory<>("Start_date"));
        end_date.setCellValueFactory(new PropertyValueFactory<>("End_date"));
        price_res.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tabres.setItems(obsc);
         
         
         
          }
 
    @FXML
    private void get_choix (ActionEvent event) throws IOException {
         table.refresh();
            String mychoix=cb.getValue();
            Car carselected = table.getSelectionModel().getSelectedItem();
            Car_idselected=carselected.getCar_id();
            CarService ps = new CarService();
           
      
         
              if (mychoix.equals ("Delete")) 
                      ps.delete(carselected);
          
           UpdateTable();
          
        }  

            
                
          
            
              
       
 

 

   

    


    }
 