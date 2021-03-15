package sample;

import java.io.Serializable;

public class Medication  implements Serializable {

    private static final long serialVersionID=1L;

    String PatientID;
    String DoctorID;
    String room;
    String medicationcase;
    String startdate;
    String enddate;

    Medication(){

    }

    Medication(String PatientID, String DoctorID, String room, String medicationcase, String startdate, String enddate)
    {
        this.PatientID = PatientID;
        this.DoctorID = DoctorID;
        this.room = room;
        this.medicationcase = medicationcase;
        this.startdate = startdate;
        this.enddate = enddate;

    }
}
