package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;

public class AddDoctor {

    VBox add;
    Label namelbl;
    TextField namefield;
    Label specializationlbl;
    TextField specializationfield;
    Label addresslbl;
    TextField addressfield;
    Label phonelbl;
    TextField phonefield;

    Button addbtn;



    AddDoctor(){


        Font font = Font.font("Century Gothic",   30);





        namelbl = new Label("Name");
        namelbl.setFont(font);
        GridPane.setConstraints(namelbl, 0,0);
        namefield = new TextField();
        namefield.setMinWidth(60);
        namefield.setFont(font);
        GridPane.setConstraints(namefield, 1,0);


        specializationlbl = new Label("Specialization");
        specializationlbl.setFont(font);
        GridPane.setConstraints(specializationlbl, 0,1);
        specializationfield = new TextField();
        specializationfield.setMinWidth(60);
        specializationfield.setFont(font);
        GridPane.setConstraints(specializationfield, 1,1);

        addresslbl = new Label("Address");
        addresslbl.setFont(font);
        GridPane.setConstraints(addresslbl, 0,2);
        addressfield = new TextField();
        addressfield.setMinWidth(60);
        addressfield.setFont(font);
        GridPane.setConstraints(addressfield, 1,2);

        phonelbl = new Label("Phone");
        phonelbl.setFont(font);
        GridPane.setConstraints(phonelbl, 0,3);
        phonefield = new TextField();
        phonefield.setMinWidth(60);
        phonefield.setFont(font);
        GridPane.setConstraints(phonefield, 1,3);

        addbtn = new Button("Save");
        //phonefield.setMinWidth(60);
        addbtn.setFont(font);
        GridPane.setConstraints(addbtn, 1,4);


        GridPane gp = new GridPane();
        gp.getChildren().addAll(namelbl,namefield,specializationlbl,specializationfield,
                addresslbl,addressfield,phonelbl,phonefield,addbtn);
        gp.setPadding(new Insets(80,30,80,20));
        gp.setVgap(10);
        add = new VBox(gp);


        addbtn.setOnAction(e -> {
            save();
        });
    }



    public void save(){

        try{

            File file = new File("Doctor.bin");

            if(file.exists() && file.length() != 0) {
                System.out.println("founded");

                Doctors doc = new Doctors(namefield.getText(), specializationfield.getText(), addressfield.getText(), phonefield.getText());
                DoctorsList docList = (DoctorsList) IO.load("Doctor.bin");
                System.out.println("done");
                System.out.println("doc.DoctorID: " + doc.DoctorID);
                docList.doctors.add(doc);
                IO.save(docList,"Doctor.bin");
            }

            else if(file.exists() && file.length() == 0)
            {
                file.delete();
                file.createNewFile();
                Doctors doc = new Doctors(namefield.getText(), specializationfield.getText(), addressfield.getText(), phonefield.getText());
                DoctorsList docList = new DoctorsList();
                System.out.println("done");
                System.out.println("doc.DoctorID: " + doc.DoctorID);
                docList.doctors.add(doc);
                IO.save(docList,"Doctor.bin");
            }
            else{
                System.out.println( "not found");
                file.createNewFile();
                Doctors doc = new Doctors(namefield.getText(), specializationfield.getText(), addressfield.getText(), phonefield.getText());
                DoctorsList docList = new DoctorsList();
                System.out.println(doc.DoctorID);
                System.out.println("done");
                System.out.println("doc.DoctorID: " + doc.DoctorID);
                docList.doctors.add(doc);
                IO.save(docList,"Doctor.bin");
            }



        }
        catch (Exception exception){
            System.out.println(exception.fillInStackTrace());
        }


    }



}
