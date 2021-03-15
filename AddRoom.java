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

public class AddRoom {



    VBox add;
    Label RoomNolbl;
    TextField RoomNofield;
    Label departmentlbl;
    TextField departmentfield;
    Label availablelbl;
    ComboBox availablefield;
    Button save;
    GridPane gp;

    AddRoom(){


        Font font = Font.font("Century Gothic",   30);

        RoomNolbl = new Label("Room Number");
        RoomNolbl.setFont(font);
        GridPane.setConstraints(RoomNolbl, 0,0);


        RoomNofield = new TextField();
        RoomNofield.setMinWidth(60);
        RoomNofield.setFont(font);
        GridPane.setConstraints(RoomNofield, 1,0);


        departmentlbl = new Label("Department");
        departmentlbl.setFont(font);
        GridPane.setConstraints(departmentlbl, 0,1);


        departmentfield = new TextField();
        departmentfield.setMinWidth(60);
        departmentfield.setFont(font);
        GridPane.setConstraints(departmentfield, 1,1);


        availablelbl = new Label("Availability");
        availablelbl.setFont(font);
        GridPane.setConstraints(availablelbl, 0,2);


        availablefield = new ComboBox();
        availablefield.setMinWidth(60);
        availablefield.getItems().addAll("Available","Occupied");
        GridPane.setConstraints(availablefield, 1,2);


        save = new Button("Save");
        save.setMinWidth(60);
        save.setFont(font);
        GridPane.setConstraints(save, 1,3);


        gp = new GridPane();

        gp.getChildren().addAll(RoomNolbl,RoomNofield,departmentlbl,departmentfield,availablelbl,availablefield,save);
        gp.setPadding(new Insets(80,30,80,20));
        gp.setVgap(10);
        add = new VBox(gp);


        save.setOnAction(e ->{
            save();
        });

    }



    public void save(){

        try{

            File file = new File("Room.bin");
            boolean s;
            if(availablefield.getSelectionModel().getSelectedItem().toString().equals("Available"))
                s=true;
            else
                s=false;


            if(file.exists() && file.length() != 0) {
                System.out.println("founded");



                Room room = new Room(RoomNofield.getText(), departmentfield.getText(), s);
                RoomList roomList = (RoomList) IO.load("Room.bin");
                System.out.println("done");
                System.out.println("doc.RoomNumber: " + room.RoomNo);
                roomList.rooms.add(room);
                IO.save(roomList,"Room.bin");
            }

            else if(file.exists() && file.length() == 0)
            {
                file.delete();
                file.createNewFile();
                Room room    = new Room(RoomNofield.getText(), departmentfield.getText(), s);
                RoomList roomList = new RoomList();
                System.out.println("done");
                System.out.println("doc.PatientID: " + room.RoomNo);
                roomList.rooms.add(room);
                IO.save(roomList,"Room.bin");
            }
            else{
                System.out.println( "not found");
                file.createNewFile();
                Room room    = new Room(RoomNofield.getText(), departmentfield.getText(), s);
                RoomList roomList = new RoomList();
                System.out.println(room.RoomNo);
                System.out.println("done");
                System.out.println("doc.PatientID: " + room.RoomNo);
                roomList.rooms.add(room);
                IO.save(roomList,"Room.bin");
            }



        }
        catch (Exception exception){
            System.out.println(exception.fillInStackTrace());
        }
    }

}
