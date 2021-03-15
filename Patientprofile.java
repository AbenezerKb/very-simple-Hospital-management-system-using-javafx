package sample;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Patientprofile {

    Font font = Font.font("Century Gothic", FontWeight.BOLD, 30);

    javafx.scene.control.Label searchlbl = new Label("Search");

    javafx.scene.control.TextField searchfield = new TextField();

    TableView tableview = new TableView();


    TableColumn<Patient, String> c1 = new TableColumn<>("ID");
    TableColumn<Patient, String> c2 = new TableColumn<>("Name");
    TableColumn<Patient, String> c3 = new TableColumn<>("Age");
    TableColumn<Patient, String> c4 = new TableColumn<>("Sex");
    TableColumn<Patient, String> c5 = new TableColumn<>("Address");
    TableColumn<Patient, String> c6 = new TableColumn<>("Phone");
    //   TableColumn<Patient, String> c7 = new TableColumn<>("Blood Group");



//    Button profile = new Button("Doctors profile");

    //Button add = new Button("Add Doctors");


    GridPane rightgp;
    GridPane search;
    Button editbtn;
    Button deletebtn;
    VBox choose;

    Patientprofile() {


        /* tableview = new TableView(); */

        c1.setCellValueFactory(new PropertyValueFactory<>("PatientID"));
        c1.setMaxWidth(150);
        c1.setMinWidth(150);

        c2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        c2.setMaxWidth(150);
        c2.setMinWidth(150);
        c3.setCellValueFactory(new PropertyValueFactory<>("Age"));
        c3.setMaxWidth(180);
        c3.setMinWidth(180);
        c4.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        c4.setMaxWidth(150);
        c4.setMinWidth(150);
        c5.setCellValueFactory(new PropertyValueFactory<>("Address"));
        c5.setMaxWidth(150);
        c5.setMinWidth(150);
        c6.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        c6.setMaxWidth(150);
        c6.setMinWidth(150);
        //    c7.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));
        //   c7.setMaxWidth(150);
        //   c7.setMinWidth(150);


//        tableview.getColumns().addAll(c1,c2);

        //tableview.

        tableview.getColumns().add(c1);
        tableview.getColumns().add(c2);
        tableview.getColumns().add(c3);
        tableview.getColumns().add(c4);
        tableview.getColumns().add(c5);
        tableview.getColumns().add(c6);
        //   tableview.getColumns().add(c7);


        search = new GridPane();
        search.getChildren().addAll(searchlbl, searchfield);
        search.setVgap(10);

        tableview.setMaxWidth(800);
        tableview.setMinWidth(800);


        searchlbl.setFont(font);

        searchfield.setMaxWidth(200);
        searchfield.setMinWidth(200);
        //   profile.setMinWidth(500);

        //  add.setFont(font);
        //  add.setMaxWidth(500);
        //  add.setMinWidth(500);

        editbtn = new Button("Edit");
        deletebtn = new Button("Delete");


        GridPane.setConstraints(searchlbl, 0, 0);
        GridPane.setConstraints(searchfield, 1, 0);
        GridPane.setConstraints(search, 0, 0);
        //  GridPane.setConstraints(searchfield, 0,0);
        GridPane.setConstraints(tableview, 0, 1);
        GridPane.setConstraints(editbtn, 0, 2);
        GridPane.setConstraints(deletebtn, 0,3);

        rightgp = new GridPane();


        rightgp.setPadding(new Insets(80, 30, 80, 20));

        rightgp.setVgap(35);

        rightgp.setHgap(10);

        rightgp.getChildren().addAll(search, tableview, editbtn, deletebtn);

        choose = new VBox(rightgp);

        load();

        editbtn.setOnAction(e->{

            Home home = new Home();
        });


    }


    public void load(){

        try {
            PatientList patList = (PatientList) IO.load("Patient.bin");
            for (Patient pat : patList.patients  ) {
                System.out.println(pat.PatientID);
                System.out.println(pat.address);
                System.out.println(pat.name);
                System.out.println(pat.phone);
                System.out.println(pat.address);
                //        System.out.println(pat.bloodgroup);


                System.out.println("catched");
                tableview.getItems().add(new Patient( pat.name, pat.age, pat.sex,  pat.phone, pat.address));

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