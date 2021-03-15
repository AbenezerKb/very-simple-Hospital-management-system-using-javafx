package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable {
    private static final long serialVersionID=1L;

    ArrayList<Room> rooms = new ArrayList<>();
}
