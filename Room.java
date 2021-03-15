package sample;

import java.io.Serializable;

public class Room  implements Serializable {
    private static final long serialVersionID=1L;
    String RoomNo;
    String department;
    Boolean available;

    Room(){

    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    Room(String RoomNo, String department, Boolean available){

        this.RoomNo = RoomNo;
        this.department = department;
        this.available = available;

    }
}
