package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Rooms {

    VBox choose;

    GridPane rightgp;
    GridPane search;
    Font font = Font.font("Century Gothic", FontWeight.BOLD,  30);

    Label searchlbl = new Label("Search");

    TextField searchfield = new TextField();

    TableView tableview = new TableView();

    TableColumn<Doctors,String> c1 = new TableColumn<>("Room Number");
    TableColumn<Doctors,String> c2 = new TableColumn<>("Department");
    TableColumn<Doctors,String> c3 = new TableColumn<>("Availability");


    Rooms(){

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
        //  GridPane.setConstraints(searchfield, 0,0);
        GridPane.setConstraints(tableview, 0,1);

        rightgp = new GridPane();


        rightgp.setPadding(new Insets(80,30,80,0));

        rightgp.setVgap(35);

        rightgp.setHgap(10);

        rightgp.getChildren().addAll(search,tableview);

        choose = new VBox(rightgp);

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
