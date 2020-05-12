package dao;

import java.util.List;
import model.Auto;
import model.Proveedor;
import model.TipoAuto;

public interface autoDAO 
{
    public void insertarAuto(Auto auto);
    public void modificarAuto(Auto auto);
    public void eliminarAuto(Auto auto);
    public List<Auto> mostrarAuto();
    public List<Proveedor> mostrarProveedor();
    public List<TipoAuto> mostrarTipo();
}
