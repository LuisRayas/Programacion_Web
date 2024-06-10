/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrysi.beans;

/**
 *
 * @author OMEN
 */
public class Asignatura {
    
    private enum Tipo{ básica, obligatoria, optativa};
    
    private int id;
    private String nombre;
    private float creditos;
    private byte curso;
    private byte cuatrimestre;
    private int id_profesor;
    private int id_asignatura;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getCreditos() {
        return creditos;
    }

    public byte getCurso() {
        return curso;
    }

    public byte getCuatrimestre() {
        return cuatrimestre;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public void setCurso(byte curso) {
        this.curso = curso;
    }

    public void setCuatrimestre(byte cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }
    
}
