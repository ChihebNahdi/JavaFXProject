/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import model.user;
import model.Car;
import service.CarService;
import service.UserService;
import utils.DataSource;
import service.ReservationCarService;
import model.Car_reservation;



/**
 *
 * @author wiemhjiri
 */
public class Test {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws SQLException {
         DataSource ds1=DataSource.getInstance();
      
     //CarService ps=new CarService();
    
     //UserService ps2=new UserService(); 
//    Car car1=new Car(1,"KIA","RIO","/img/kia rio.jpg",1230000,140.00,"6A7324");
//      Car car2=new Car(3,"SEAT","LEON","/img/seat leon.jpg",25500,90.99,"A7745B"); 
////      Car car3=new Car(4,"HYUNDAI","G.I10","/img/I10.jfif",30000,75.99,"F16C31");  
////       Car car4=new Car(5,"TUNIGREEN","TUNIGREEN","/img/tg.jpg",30000,145.99,"291D36");
////      user user4=new user(3,"Chiheb","NAHDI","NAHDI_Chiheb","aze1122A","User");
//      user user3=new user(2,"Mariem","HJIRI","HJIRI_MARIEM","aze1122A","Admin");
  ReservationCarService ps=new ReservationCarService();
//     Date date1=Date.valueOf("2022-06-14");
//    Date date2=Date.valueOf("2022-06-17");
//    Car_reservation cr= new Car_reservation(user3.getUser_id(),car2.getCar_id(),date1,date2,1500.00);
        //ReservationCarService ps3=new ReservationCarService();

//      ps.insertPst(car1);
//       ps.insertPst(car4);
//        ps.insertPst(car3);
////    //System.out.println(ps1.getById(1));
//ps.insert(cr);
//////ps2.insert(user3);
//////ps2.insert(user4);
//////   ps.insertPst(car2);

     System.out.println(ps.checkcar().toString());




    
    }
    
}