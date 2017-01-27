package model;

public class Truckdriver {

    public String dni;
    public String name;
    public String phone;
    public double salary;

    public Truckdriver() {
    }

    public Truckdriver(String dni) {
        this.dni = dni;
    }

    public Truckdriver(String dni, String name, String phone, double salary) {
        this.dni = dni;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Truckdriver{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                '}';
    }
}
