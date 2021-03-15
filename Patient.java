package sample;

import java.io.Serializable;

public class Patient  implements Serializable {

    private static final long serialVersionID=1L;
    String PatientID;
    String name;
    int age;
    char sex;
    String address;
    //    String bloodgroup;
    String phone;

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*    public String getBloodgroup() {
            return bloodgroup;
        }

        public void setBloodgroup(String bloodgroup) {
            this.bloodgroup = bloodgroup;
        }
    */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    Patient(){

    }

    Patient(String name, int age, char sex,  String phone, String address){

        this.PatientID = phone.substring(0,3)+name.substring(0,3);
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
        //   this.bloodgroup = bloodgroup; String bloodgroup,
        this.phone = phone;

    }

}
