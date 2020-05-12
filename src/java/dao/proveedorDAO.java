package dao;

import java.util.List;
import model.Proveedor;
import model.Sexo;

public interface proveedorDAO 
{
    public void insertarProveedor(Proveedor proveedor);
    public void modificarProveedor(Proveedor proveedor);
    public void eliminarProveedor(Proveedor proveedor);
    public List<Proveedor> mostrarProveedor();
    public List<Sexo> mostrarSexo();
}
