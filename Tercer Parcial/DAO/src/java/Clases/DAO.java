/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author maxim
 */
public interface DAO<T> {
    public void insert (T entidad) throws SQLException;
    public void update(T entidad) throws SQLException;
    public void delete (int id) throws SQLException;
    public Departamento read (int id) throws SQLException;
    public List <T> readAll() throws SQLException;
}
