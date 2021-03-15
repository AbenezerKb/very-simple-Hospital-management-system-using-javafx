package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.File;

public class AddPatient {



    VBox add;
    Label namelbl;
    TextField namefield;
    Label agelbl;
    TextField agefield;
    Label bloodlbl;
    TextField bloodfield;
    Label addresslbl;
    TextField addressfield;
    Label phonelbl;
    TextField phonefield;
    Label sexlbl;
    ComboBox sex;
    Button addbtn;

    AddPatient(){


        Font font = Font.font("Century Gothic",   30);




        namelbl = new Label("Name");
        namelbl.setFont(font);
        GridPane.setConstraints(namelbl, 0,0);
        namefield = new TextField();
        namefield.setMinWidth(60);
        namefield.setFont(font);
        GridPane.setConstraints(namefield, 1,0);


        agelbl = new Label("Age");
        agelbl.setFont(font);
        GridPane.setConstraints(agelbl, 0,1);
        agefield = new TextField();
        agefield.setMinWidth(60);
        agefield.setFont(font);
        GridPane.setConstraints(agefield, 1,1);

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

        sexlbl = new Label("Sex");
        sexlbl.setFont(font);
        GridPane.setConstraints(sexlbl, 0,4);
        sex = new ComboBox();
        sex.setMinWidth(60);
        Button btn = new Button("Male");
        sex.getItems().add("Male");
        sex.getItems().add("Female");

        GridPane.setConstraints(sex, 1,4);

        bloodlbl = new Label("Blood group");
        bloodlbl.setFont(font);
        GridPane.setConstraints(bloodlbl, 0,5);
        bloodfield = new TextField();
        bloodfield.setMinWidth(60);
        bloodfield.setFont(font);
        GridPane.setConstraints(bloodfield, 1,5);

        addbtn = new Button("Save");
        //phonefield.setMinWidth(60);
        addbtn.setFont(font);
        GridPane.setConstraints(addbtn, 1,6);


        GridPane gp = new GridPane();
        gp.getChildren().addAll(namelbl,namefield,sexlbl,sex,agelbl,agefield,
                addresslbl,addressfield,bloodlbl,bloodfield,phonelbl,phonefield,addbtn);
        gp.setPadding(new Insets(80,30,80,20));
        gp.setVgap(10);
        add = new VBox(gp);

        addbtn.setOnAction(e ->{
            save();
        });
    }


    public void save(){

        try{

            File file = new File("Patient.bin");

            char s;
            if (sex.getSelectionModel().getSelectedItem().toString().equals("Male"))
                s='M';
            else
                s='F';

            int a=Integer.parseInt(agefield.getText());

            if(file.exists() && file.length() != 0) {
                System.out.println("founded");



                Patient pat = new Patient(namefield.getText(), a, s,  phonefield.getText(), addressfield.getText());
                PatientList patList = (PatientList) IO.load("Patient.bin");
                System.out.println("done");
                System.out.println("doc.PatientID: " + pat.PatientID);
                patList.patients.add(pat);
                IO.save(patList,"Patient.bin");
            }

            else if(file.exists() && file.length() == 0)
            {
                file.delete();
                file.createNewFile();
                Patient pat = new Patient(namefield.getText(), a, s,  phonefield.getText(), addressfield.getText());
                PatientList patList = new PatientList();
                System.out.println("done");
                System.out.println("doc.PatientID: " + pat.PatientID);
                patList.patients.add(pat);
                IO.save(patList,"Patient.bin");
            }
            else{
                System.out.println( "not found");
                file.createNewFile();
                Patient pat = new Patient(namefield.getText(), a, s,  phonefield.getText(), addressfield.getText());
                PatientList patList = new PatientList();
                System.out.println(pat.PatientID);
                System.out.println("done");
                System.out.println("doc.PatientID: " + pat.PatientID);
                patList.patients.add(pat);
                IO.save(patList,"Patient.bin");
            }



        }
        catch (Exception exception){
            System.out.println(exception.fillInStackTrace());
        }
    }
}
