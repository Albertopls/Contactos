package clases;

/**
 * Created by eduardopalacios on 28/02/18.
 */

public class Item {

    String nombre,telefono;
    int imagen;


    public Item(String nombre,String telefono,int imagen)
    {
        this.nombre=nombre;
        this.telefono=telefono;
        this.imagen=imagen;
    }


    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public int getImagen(){
        return imagen;
    }
}
