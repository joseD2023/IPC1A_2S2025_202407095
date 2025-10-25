/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Usuario{
    //esta clase nos va ayudar a manejar datos del usuario 
    
   
    
    protected String codigo;  //debe ser protected porque si lo coloco privado los hijos no pueden acceder a ellos.
    protected String Contra; 
    protected String nombre; 

    public Usuario(String codigo, String nombre, String contra) {
        this.codigo = codigo;
        this.Contra = contra;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    
}
