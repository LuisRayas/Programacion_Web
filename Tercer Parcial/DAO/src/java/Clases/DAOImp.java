/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maxim
 */
public class DAOImp implements DAO<Departamento>{
   
    private Connection conn;

    public DAOImp() {
        try {
            this.conn = Conexion.getConnection();
        } catch (SQLException e) {
        }
    }
    @Override
    public void insert(Departamento dep) throws SQLException {
        conn = Conexion.getConnection();
        String insertQuery = "INSERT INTO Departamento (nombre) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(insertQuery);
       
        ps.setString(1, dep.getNombre());
        
        ps.executeUpdate();
        
        conn.close();
    }

    @Override
    public void update(Departamento entidad) throws SQLException {
        String updateQuery = "UPDATE Departamento SET nombre = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
        ps.setString(1, entidad.getNombre());
        ps.setInt(2, entidad.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
              String deleteQuery = "DELETE FROM Departamento WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(deleteQuery);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Departamento read(int id) throws SQLException {
       String readQuery = "SELECT * FROM Departamento WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(readQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Departamento(rs.getInt("id"), rs.getString("nombre"));
        }
        return null;
    }

    @Override
    public List<Departamento> readAll() throws SQLException {
        String readAllQuery = "SELECT * FROM departamento";
        PreparedStatement ps = conn.prepareStatement(readAllQuery);
        ResultSet rs = ps.executeQuery();
        List<Departamento> deps = new ArrayList<>();
        while (rs.next()) {
            deps.add(new Departamento(rs.getInt("id"), rs.getString("nombre")));
        }
        return deps;
    }
}
