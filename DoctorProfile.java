package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.*;

public class DoctorProfile {





    Font font = Font.font("Century Gothic", FontWeight.BOLD,  30);

    javafx.scene.control.Label searchlbl = new Label("Search");

    javafx.scene.control.TextField searchfield = new TextField();

    TableView tableview = new TableView();

    TableColumn<Doctors,String> c1 = new TableColumn<>("ID");
    TableColumn<Doctors,String> c2 = new TableColumn<>("Name");
    TableColumn<Doctors,String> c3 = new TableColumn<>("Specialization");
    TableColumn<Doctors,String> c4 = new TableColumn<>("Address");
    TableColumn<Doctors,String> c5 = new TableColumn<>("Phone");


//    Button profile = new Button("Doctors profile");

    //Button add = new Button("Add Doctors");


    GridPane rightgp;
    GridPane search;
    Button editbtn;
    Button deletebtn;
    VBox choose;

    DoctorProfile(){


        /* tableview = new TableView(); */

        c1.setCellValueFactory(new PropertyValueFactory<>("DoctorID"));
        c1.setMaxWidth(150);
        c1.setMinWidth(150);

        c2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        c2.setMaxWidth(150);
        c2.setMinWidth(150);
        c3.setCellValueFactory(new PropertyValueFactory<>("Specialization"));
        c3.setMaxWidth(180);
        c3.setMinWidth(180);
        c4.setCellValueFactory(new PropertyValueFactory<>("Address"));
        c4.setMaxWidth(150);
        c4.setMinWidth(150);
        c5.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        c5.setMaxWidth(150);
        c5.setMinWidth(150);


//        tableview.getColumns().addAll(c1,c2);

        //tableview.

        tableview.getColumns().add(c1);
        tableview.getColumns().add(c2);
        tableview.getColumns().add(c3);
        tableview.getColumns().add(c4);
        tableview.getColumns().add(c5);


        search = new GridPane();
        search.getChildren().addAll(searchlbl,searchfield);
        search.setVgap(10);

        tableview.setMaxWidth(800);
        tableview.setMinWidth(800);




        searchlbl.setFont(font);

        searchfield.setMaxWidth(200);
        searchfield.setMinWidth(200);


        GridPane.setConstraints(searchlbl, 0,0);
        GridPane.setConstraints(searchfield, 1,0);
        GridPane.setConstraints(search, 0,0);


        editbtn = new Button("Edit");
        deletebtn = new Button("Delete");

        GridPane.setConstraints(tableview, 0,1);
        GridPane.setConstraints(editbtn, 0,2);
        GridPane.setConstraints(deletebtn, 0,3);

        rightgp = new GridPane();


        rightgp.setPadding(new Insets(80,30,80,20));

        rightgp.setVgap(35);

        rightgp.setHgap(10);

        rightgp.getChildren().addAll(search,tableview, editbtn, deletebtn);

        choose = new VBox(rightgp);

        load();
    }

    public void load(){

        try {
            DoctorsList docList = (DoctorsList) IO.load("Doctor.bin");
            for (Doctors doc : docList.doctors  ) {
                System.out.println(doc.DoctorID);
                System.out.println(doc.address);
                System.out.println(doc.name);
                System.out.println(doc.phone);
                System.out.println(doc.specialization);



                tableview.getItems().add(new Doctors( doc.DoctorID,doc.name, doc.specialization, doc.address, doc.phone));

            }
        }
        catch (Exception exception){
            System.out.println("catched");
            System.out.println("catched");
            System.out.println("catched");
            System.out.println("catched");


            System.out.println(exception.fillInStackTrace());
        }



    }
}
