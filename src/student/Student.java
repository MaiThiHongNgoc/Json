package student;

public class Student {
    private int ID;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String DOB;

    public Student() {
    }

    public Student(int ID, String name, String address, String email, String phone, String DOB) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.DOB = DOB;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "ID: "+ID+'\n'+ "Name: "+name+'\n'+"Address: "+address+'\n'+"Email: "+email+'\n'+"Phone: "+phone+'\n'+"DOB: "+DOB;
    }
}
