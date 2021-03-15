package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import sample.Doctors;

import java.io.File;
import java.util.ArrayList;

public class EditDoctors {

    VBox add;
    Label namelbl;
    TextField namefield;
    Label specializationlbl;
    TextField specializationfield;
    Label addresslbl;
    TextField addressfield;
    Label phonelbl;
    TextField phonefield;
    Label searchlbl;
    TextField searchfield;
    Button addbtn;
    Button searchbtn;

    EditDoctors(){


        Font font = Font.font("Century Gothic",   30);




        searchlbl = new Label("Search");
        searchlbl.setFont(font);
        GridPane.setConstraints(searchlbl, 0,0);
        searchfield = new TextField();
        searchfield.setMinWidth(60);
        searchfield.setFont(font);
        GridPane.setConstraints(searchfield, 1,0);

        searchbtn = new Button("Search");

        searchbtn.setFont(font);
        GridPane.setConstraints(searchbtn, 1,1);


        namelbl = new Label("Name");
        namelbl.setFont(font);
        GridPane.setConstraints(namelbl, 0,3);
        namefield = new TextField();
        namefield.setMinWidth(60);
        namefield.setFont(font);
        GridPane.setConstraints(namefield, 1,3);


        specializationlbl = new Label("Specialization");
        specializationlbl.setFont(font);
        GridPane.setConstraints(specializationlbl, 0,4);
        specializationfield = new TextField();
        specializationfield.setMinWidth(60);
        specializationfield.setFont(font);
        GridPane.setConstraints(specializationfield, 1,4);

        addresslbl = new Label("Address");
        addresslbl.setFont(font);
        GridPane.setConstraints(addresslbl, 0,5);
        addressfield = new TextField();
        addressfield.setMinWidth(60);
        addressfield.setFont(font);
        GridPane.setConstraints(addressfield, 1,5);

        phonelbl = new Label("Phone");
        phonelbl.setFont(font);
        GridPane.setConstraints(phonelbl, 0,6);
        phonefield = new TextField();
        phonefield.setMinWidth(60);
        phonefield.setFont(font);
        GridPane.setConstraints(phonefield, 1,6);

        addbtn = new Button("Save");
        //phonefield.setMinWidth(60);
        addbtn.setFont(font);
        GridPane.setConstraints(addbtn, 1,7);


        GridPane gp = new GridPane();
        gp.getChildren().addAll(searchbtn,searchfield,namelbl,namefield,specializationlbl,specializationfield,
                addresslbl,addressfield,phonelbl,phonefield,addbtn);
        gp.setPadding(new Insets(80,30,80,20));
        gp.setVgap(10);
        add = new VBox(gp);


        addbtn.setOnAction(e -> {
            save();
        });

        searchbtn.setOnAction(e->{
            search();
        });
    }

    Doctors d = new Doctors();
    //DoctorsList doctorsLists;

    public void search(){

        try {
            DoctorsList doctorsLists =  (DoctorsList)IO.load("Doctor.bin");
            Doctors doc = new Doctors();
            for (int i=0; i<doctorsLists.doctors.size(); i++){
                if(doctorsLists.doctors.get(i).DoctorID.equals(searchfield.getText()))
                {

                    d.DoctorID = doctorsLists.doctors.get(i).DoctorID;
                    d.name = doctorsLists.doctors.get(i).name;
                    d.specialization = doctorsLists.doctors.get(i).specialization;
                    d.address = doctorsLists.doctors.get(i).address;
                    d.phone = doctorsLists.doctors.get(i).phone;

                    namefield.setText(doctorsLists.doctors.get(i).name);
                    specializationfield.setText(doctorsLists.doctors.get(i).specialization);
                    addressfield.setText(doctorsLists.doctors.get(i).address);
                    phonefield.setText(doctorsLists.doctors.get(i).phone);


                    System.out.println(doctorsLists.doctors.size());
                    doctorsLists.doctors.remove(i);
                    File f = new File("Doctor.bin");
                    f.delete();
                    IO.save( doctorsLists,"Doctor.bin");

                    System.out.println(doctorsLists.doctors.size());

                    break;
                }

            }
        }
        catch (Exception exception)
        {
            System.out.println(exception.fillInStackTrace());
        }

    }


    public void save(){

        try{

            DoctorsList  doctorsLists =  (DoctorsList)IO.load("Doctor.bin");
            Doctors doc = new Doctors();
            for (int i=0; i<doctorsLists.doctors.size(); i++){
                if(doctorsLists.doctors.get(i).DoctorID.equals(searchfield.getText()))
                {
                    doc.DoctorID = searchfield.getText();
                    doc.phone = phonefield.getText();
                    doc.address = addressfield.getText();
                    doc.specialization = specializationfield.getText();
                    doc.name = namefield.getText();

                    System.out.println(namefield.getText());

                    searchfield.setText("");

                    //  doctorsLists.doctors.remove(d);
                    File f = new File("Doctor.bin");
                    f.delete();
                    System.out.println("removed,: " + d.DoctorID);
//                    save the new edited data

                    doctorsLists.doctors.add(doc);

                    //      namefield.setText(doctorsLists.doctors.get(i).name);
                    //      specializationfield.setText(doctorsLists.doctors.get(i).specialization);
                    //      addressfield.setText(doctorsLists.doctors.get(i).address);
                    //      phonefield.setText(doctorsLists.doctors.get(i).phone);


                    break;
                }
            }
            IO.save( doctorsLists,"Doctor.bin");

        }
        catch (Exception exception){
            System.out.println(exception.fillInStackTrace());
        }


    }


}
