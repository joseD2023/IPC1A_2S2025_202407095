package IPC1_Actividades_202407095.Proyecto1;

public class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public String getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }


}
