package sample;

import java.io.Serializable;

public class Doctors implements Serializable {

    private static final long serialVersionID=1L;

    //  public String getDoctorID() {
    //      return DoctorID;
    //  }

    //   public void setDoctorID(String doctorID) {
    //       DoctorID = phone.substring(0,3)+name.substring(0,3);

    //  }

    public String getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(String doctorID) {
        DoctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String DoctorID;
    public String name;
    public String specialization;
    public String address;
    public String phone;

    Doctors(){

    }

    Doctors( String name, String specialization, String address, String phone)
    {
        this.DoctorID = phone.substring(0,3)+name.substring(0,3);
        this.name = name;
        this.specialization = specialization;
        this.address = address;
        this.phone = phone;

    }


    Doctors( String DoctorId, String name, String specialization, String address, String phone)
    {
        this.DoctorID = DoctorId;
        this.name = name;
        this.specialization = specialization;
        this.address = address;
        this.phone = phone;

    }

}
