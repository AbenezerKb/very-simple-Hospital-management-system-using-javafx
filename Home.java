package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.HLineTo;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import java.io.FileInputStream;

public class Home {

    Stage ps;
    VBox right;
    VBox left;
    Button Patientbtn;
    Button Homebtn;
    Button Doctorbtn;
    Button Roombtn;
    Button Reportbtn;
    MenuItem profile;
    MenuItem add;
    ComboBox doc;
    ComboBox pat;
    ComboBox room;
    public Home(){

        show();
    }









    public void show(){
        ps = new Stage();
        SplitPane sp = new SplitPane();

        Font font = Font.font("Century Gothic",  36);

        Homebtn= new Button("Home");

        Homebtn.setFont(font);
        Homebtn.setMaxWidth(300);
        Homebtn.setMinWidth(300);

        Doctorbtn =  new Button("Doctors");

        Doctorbtn.setFont(font);
        Doctorbtn.setMaxWidth(300);
        Doctorbtn.setMinWidth(300);

        Patientbtn =  new Button("Patients");

        Patientbtn.setFont(font);
        Patientbtn.setMaxWidth(300);
        Patientbtn.setMinWidth(300);

        Reportbtn =  new Button("Report");

        Reportbtn.setFont(font);
        Reportbtn.setMaxWidth(300);
        Reportbtn.setMinWidth(300);

        Roombtn =  new Button("Room");

        Roombtn.setFont(font);
        Roombtn.setMaxWidth(300);
        Roombtn.setMinWidth(300);

        profile=new MenuItem("Profile");
        //profile.se;

        add=new MenuItem("Add");
        doc = new ComboBox();
        pat = new ComboBox();
        room = new ComboBox();


        doc.getItems().add("Doctors Profile");
        doc.getItems().add("Add Doctor");
        doc.getItems().add("Edit Profile");

        pat.getItems().add("Patients Profile");
        pat.getItems().add("Add Patient");
        pat.getItems().add("Edit Profile");

        room.getItems().add("Rooms");
        room.getItems().add("Add Room");
        room.getItems().add("Edit Room");

        doc.setMaxHeight(67);
        doc.setMinHeight(67);
        doc.setMaxWidth(300);
        doc.setMinWidth(300);

        pat.setMaxHeight(67);
        pat.setMinHeight(67);
        pat.setMaxWidth(300);
        pat.setMinWidth(300);

        room.setMaxHeight(67);
        room.setMinHeight(67);
        room.setMaxWidth(300);
        room.setMinWidth(300);
        //sp.setAlignment(Pos.CENTER_LEFT);


        GridPane.setConstraints(Homebtn, 0,0);
        GridPane.setConstraints(doc, 0,1);
        GridPane.setConstraints(pat, 0,2);
        GridPane.setConstraints(Reportbtn, 0,4);
        GridPane.setConstraints(room, 0,3);
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(50,10,10,10));
        gp.setVgap(15);
        gp.setHgap(10);
        gp.getChildren().addAll(Homebtn, doc, pat, room,Reportbtn);
        left= new VBox(gp);
        left.setMaxWidth(300);



        Label hm = new Label("Hospital Management System");
        Font font1 = Font.font("Century Gothic",FontWeight.BOLD,  56);
        hm.setFont(font1);




        Label doctorslbl = new Label("Doctors: ");
        doctorslbl.setFont(font);

        Label patientslbl = new Label("Patients: ");
        patientslbl.setFont(font);

        Label roomslbl = new Label("Rooms: ");
        roomslbl.setFont(font);



        GridPane.setConstraints(hm, 0,0);
        GridPane.setConstraints(doctorslbl, 0,1);
        GridPane.setConstraints(patientslbl, 0,2);
        GridPane.setConstraints(roomslbl, 0,3);
        GridPane rightgp = new GridPane();
        rightgp.setPadding(new Insets(80,0,50,0));
        rightgp.setVgap(35);
        //rightgp.setHgap(10);

        rightgp.getChildren().addAll(hm, doctorslbl, patientslbl, roomslbl);

        right = new VBox(rightgp);

        sp.getItems().addAll(left, right);





        Button btn = new Button();


        FlowPane fp = new FlowPane();
        //fp.getChildren().add(hbox);
        Scene scene = new Scene(sp, 1200, 700);
        ps.setTitle("Inventory system");
        ps.setScene(scene);
        ps.show();


        doc.setOnAction(e ->{
            //int selectedIndex = doc.getSelectionModel().getSelectedIndex();
            String choice = doc.getSelectionModel().getSelectedItem().toString();


            sp.getItems().clear();

            if(choice.equals("Doctors Profile"))
            {

                System.out.println("yes");
                DoctorProfile d = new DoctorProfile();
                sp.getItems().addAll(left, d.choose);
            }

            if(choice.equals("Add Doctor"))
            {
                System.out.println("yes");
                AddDoctor d = new AddDoctor();
                sp.getItems().addAll(left, d.add);
            }

            if(choice.equals("Edit Profile"))
            {
                System.out.println("yes");
                EditDoctors d = new EditDoctors();
                sp.getItems().addAll(left, d.add);
            }
        });


        pat.setOnAction(e ->{
            //int selectedIndex = doc.getSelectionModel().getSelectedIndex();
            String choice = pat.getSelectionModel().getSelectedItem().toString();


            sp.getItems().clear();

            if(choice.equals("Patients Profile"))
            {

                System.out.println("yeeeeeeeeeees");
                Patientprofile d = new Patientprofile();
                sp.getItems().addAll(left, d.choose);
            }

            if(choice.equals("Add Patient"))
            {

                AddPatient d = new AddPatient();
                sp.getItems().addAll(left, d.add);
            }

            if(choice.equals("Edit Profile"))
            {
                System.out.println("yes");
                AddPatient d = new AddPatient();
                sp.getItems().addAll(left, d.add);
            }
        });



        Homebtn.setOnAction(e ->{
            sp.getItems().clear();
            sp.getItems().addAll(left, right);
        });


        room.setOnAction(e ->{
            //int selectedIndex = doc.getSelectionModel().getSelectedIndex();
            String choice = room.getSelectionModel().getSelectedItem().toString();


            sp.getItems().clear();

            if(choice.equals("Rooms"))
            {

                Rooms d = new Rooms();
                sp.getItems().addAll(left, d.choose);
            }

            if(choice.equals("Add Room"))
            {

                AddRoom d = new AddRoom();
                sp.getItems().addAll(left, d.add);
            }
        });

    }



    public void leftp(){
        Font font = Font.font("Century Gothic",  36);
        Homebtn= new Button("Home");

        Homebtn.setFont(font);
        Homebtn.setMaxWidth(300);
        Homebtn.setMinWidth(300);

        Doctorbtn =  new Button("Doctors");

        Doctorbtn.setFont(font);
        Doctorbtn.setMaxWidth(300);
        Doctorbtn.setMinWidth(300);

        Patientbtn =  new Button("Patients");

        Patientbtn.setFont(font);
        Patientbtn.setMaxWidth(300);
        Patientbtn.setMinWidth(300);

        Reportbtn =  new Button("Report");

        Reportbtn.setFont(font);
        Reportbtn.setMaxWidth(300);
        Reportbtn.setMinWidth(300);
        //sp.setAlignment(Pos.CENTER_LEFT);


        GridPane.setConstraints(Homebtn, 0,0);
        GridPane.setConstraints(Doctorbtn, 0,1);
        GridPane.setConstraints(Patientbtn, 0,2);
        GridPane.setConstraints(Reportbtn, 0,3);
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(50,10,10,10));
        gp.setVgap(15);
        gp.setHgap(10);
        gp.getChildren().addAll(Homebtn, Doctorbtn, Patientbtn, Reportbtn);
        left= new VBox(gp);
        left.setMaxWidth(300);
    }
}
