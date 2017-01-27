package StucomExpress;

import model.City;
import model.Package;
import model.Truck;
import model.Truckdriver;
import persistance.TransportJDBC;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TransportJDBC gestor = new TransportJDBC();
        try {
            System.out.println("Conectado a la base de datos ...");
            gestor.conectar();
            System.out.println("Conexión establecida.");
            Truckdriver d1 = new Truckdriver("44444444d", "Alberto", "888999988", 500.50);
            Truckdriver d2 = new Truckdriver("55555555r", "Sergio", "366635562", 600.33);
            Truck t1 = new Truck("c1", "r", 4, d1);
            Truck t2 = new Truck("c2", "z", 6, d2);
            City bcn = new City("08000", "Barcelona");
            City cb = new City("08755", "Castellbisbal");
            Package p1 = new Package(1, "Josep Julià", d2, bcn);
            Package p2 = new Package(2, "Pol Rodriguez", d1, cb);
            System.out.println("Testeando metodo que inserta un camión en la base de datos");
            gestor.insertCamionero(d1);
            System.out.println("Camionero Alberto insertado en la bdd.");
            gestor.insertCamionero(d2);
            System.out.println("Camionero Sergio insertado en la bdd.");
            gestor.insertCamion(t1);
            System.out.println("Camion t1 insertado en la bbdd.");
            gestor.insertCamion(t2);
            System.out.println("Camion t2 insertado en la bbdd.");
            gestor.insertCity(bcn);
            System.out.println("Insertada ciudad Barcelona");
            gestor.insertCity(cb);
            System.out.println("Insertada ciudad Castellbisbal");
            gestor.insertPaquete(p1);
            System.out.println("Insertado paquete p1");
            gestor.insertPaquete(p2);
            System.out.println("Insertado paquete p2");
            System.out.println("Modificar salario de Alberto a 5000.99€");
            d1.setSalary(5000.99);
            gestor.modificarSueldoCamionero(d1);
            System.out.println("Lista de camiones por conductor Alberto");
            List<Truck> camiones = gestor.listaCamionesByDriver("44444444d");
            for (Truck t : camiones) {
                System.out.println(t);
            }
            System.out.println("Lista de paquetes por ciudad.");
            List<Package> paquetes = gestor.listaPaquetesByCity("08000");
            for (Package p : paquetes) {
                System.out.println(p);
            }
            System.out.println("Lista de envios por ciudad");
            System.out.println(gestor.getListaEnvios());
            System.out.println("Desconectando de la base de datos ...");
            gestor.desconectar();
            System.out.println("Conexión cerrada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        }
    }
}
