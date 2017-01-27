package model;

public class Truck {

    public String idtruck;
    public String model;
    public int capacity;
    public Truckdriver driver;

    public Truck() {
    }

    public Truck(String idtruck, String model, int capacity, Truckdriver driver) {
        this.idtruck = idtruck;
        this.model = model;
        this.capacity = capacity;
        this.driver = driver;
    }

    public String getIdtruck() {
        return idtruck;
    }

    public void setIdtruck(String idtruck) {
        this.idtruck = idtruck;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Truckdriver getDriver() {
        return driver;
    }

    public void setDriver(Truckdriver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "idtruck='" + idtruck + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", driver='" + driver + '\'' +
                '}';
    }
}
