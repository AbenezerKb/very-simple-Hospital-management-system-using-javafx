package sample;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RoomProfile {




    Font font = Font.font("Century Gothic", FontWeight.BOLD, 30);

    javafx.scene.control.Label searchlbl = new Label("Search");

    javafx.scene.control.TextField searchfield = new TextField();

    TableView tableview = new TableView();



    TableColumn<Patient, String> c1 = new TableColumn<>("Room Number");
    TableColumn<Patient, String> c2 = new TableColumn<>("Department");
    TableColumn<Patient, String> c3 = new TableColumn<>("Available");


    GridPane rightgp;
    GridPane search;
    Button editbtn;
    Button deletebtn;
    VBox choose;


    RoomProfile(){

        c1.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        c1.setMaxWidth(150);
        c1.setMinWidth(150);

        c2.setCellValueFactory(new PropertyValueFactory<>("Department"));
        c2.setMaxWidth(150);
        c2.setMinWidth(150);
        c3.setCellValueFactory(new PropertyValueFactory<>("Available"));
        c3.setMaxWidth(180);
        c3.setMinWidth(180);


        tableview.getColumns().add(c1);
        tableview.getColumns().add(c2);
        tableview.getColumns().add(c3);


        search =new GridPane();
        search.getChildren().

                addAll(searchlbl, searchfield);
        search.setVgap(10);

        tableview.setMaxWidth(800);
        tableview.setMinWidth(800);


        searchlbl.setFont(font);

        searchfield.setMaxWidth(200);
        searchfield.setMinWidth(200);

        editbtn = new Button("Edit");
        deletebtn = new Button("Delete");
        GridPane.setConstraints(searchlbl,0,0);
        GridPane.setConstraints(searchfield,1,0);
        GridPane.setConstraints(search,0,0);
        GridPane.setConstraints(tableview,0,1);
        GridPane.setConstraints(editbtn,0,2);
        GridPane.setConstraints(deletebtn,0,3);

        rightgp =new GridPane();


        rightgp.setPadding(new Insets(80,30,80,20));

        rightgp.setVgap(35);

        rightgp.setHgap(10);

        rightgp.getChildren().addAll(search, tableview,deletebtn,editbtn);

        choose =new VBox(rightgp);

        load();

    }

    public void load(){

        try {
            RoomList roomList = (RoomList) IO.load("Room.bin");
            for (Room room : roomList.rooms  ) {
                System.out.println(room.RoomNo);
                System.out.println(room.department);

                //        System.out.println(pat.bloodgroup);


                System.out.println("catched");
                tableview.getItems().add(new Room( room.RoomNo, room.department, room.available));

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
