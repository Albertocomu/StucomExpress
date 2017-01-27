package persistance;

import model.*;
import model.Package;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportJDBC {
    private Connection conexion;

    public void insertCamionero(Truckdriver d) throws SQLException {
        String insert = "insert into truckdriver values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, d.getDni());
        ps.setString(2, d.getName());
        ps.setString(3, d.getPhone());
        ps.setDouble(4, d.getSalary());
        ps.executeUpdate();
        ps.close();
    }

    public void insertCamion(Truck t) throws SQLException {
        String insert = "insert into truck values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, t.getIdtruck());
        ps.setString(2, t.getModel());
        ps.setInt(3, t.getCapacity());
        ps.setString(4, t.getDriver().getDni());
        ps.executeUpdate();
        ps.close();
    }

    public void insertPaquete(Package p) throws SQLException {
        String insert = "insert into package values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setInt(1, p.getIdpackage());
        ps.setString(2, p.getCustomer());
        ps.setString(3, p.getDriver().getDni());
        ps.setString(4, p.getCity().getPostalcode());
        ps.executeUpdate();
        ps.close();
    }

    public void insertCity(City c) throws SQLException {
        String insert = "insert into city values (?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, c.getPostalcode());
        ps.setString(2, c.getName());
        ps.executeUpdate();
        ps.close();
    }

    public void modificarSueldoCamionero(Truckdriver d) throws SQLException {
        String update = "update truckdriver set salary=? where dni=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setDouble(1, d.getSalary());
        ps.setString(2, d.getDni());
        ps.executeUpdate();
        ps.close();
    }

    public List<Truck> listaCamionesByDriver(String dni) throws SQLException {
        List<Truck> camiones;
        String query = "select * from truck where driver LIKE '%" + dni + "%';";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        camiones = rellenoLista(rs);
        rs.close();
        st.close();
        return camiones;
    }

    public List<Package> listaPaquetesByCity(String cp) throws SQLException {
        List<Package> paquetes = new ArrayList<>();
        String query = "select * from package where city='" + cp + "';";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Package j = new Package();
            j.setIdpackage(rs.getInt("idpackage"));
            j.setCustomer(rs.getString("customer"));
            j.setDriver(new Truckdriver(rs.getString("driver")));
            j.setCity(new City(rs.getString("city")));
            paquetes.add(j);
        }
        rs.close();
        st.close();
        return paquetes;
    }

    public List<ListaEnvios> getListaEnvios() throws SQLException {
        String query = "select name, count(*) as envios from city c, package p where c.postalcode = p.city";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<ListaEnvios> lista = new ArrayList<>();
        while (rs.next()) {
            ListaEnvios r = new ListaEnvios();
            r.setEnvios(rs.getInt("envios"));
            r.setNombre(rs.getString("name"));
            lista.add(r);
        }
        rs.close();
        return lista;
    }


    // Función que conecta con la bbdd
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/transport";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }

    // Función que desconecta de la bbdd
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public ArrayList<Truck> rellenoLista(ResultSet rs) throws SQLException {
        ArrayList<Truck> camiones = new ArrayList<>();
        while (rs.next()) {
            Truck j = new Truck();
            j.setIdtruck(rs.getString("idtruck"));
            j.setModel(rs.getString("model"));
            j.setCapacity(rs.getInt("capacity"));
            j.setDriver(new Truckdriver(rs.getString("driver")));
            camiones.add(j);
        }
        return camiones;
    }
}
