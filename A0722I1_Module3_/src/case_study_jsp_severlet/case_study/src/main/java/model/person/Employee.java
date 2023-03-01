package model.person;

public class Employee extends Person{
    private double salary;
    private int position_id;
    private int education_degree_id;
    private int division_id;
    private String username;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String id_card, String phone, String email, String address) {
        super(id, name, birthday, id_card, phone, email, address);
    }

    public Employee(double salary, int position_id, int education_degree_id, int division_id, String username) {
        this.salary = salary;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
        this.username = username;
    }

    public Employee(int id, String name, String birthday, String id_card, String phone, String email, String address, double salary, int position_id, int education_degree_id, int division_id, String username) {
        super(id, name, birthday, id_card, phone, email, address);
        this.salary = salary;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
        this.username = username;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String birthday, String id_card, String phone, String email, String address, double salary) {
        super(id, name, birthday, id_card, phone, email, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
