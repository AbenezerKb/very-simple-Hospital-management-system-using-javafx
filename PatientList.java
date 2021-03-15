package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientList implements Serializable {

    private static final long serialVersionID=1L;

    ArrayList<Patient> patients = new ArrayList<>();
}
