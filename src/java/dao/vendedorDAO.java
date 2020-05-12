package dao;

import java.util.List;
import model.Sexo;
import model.Vendedor;

public interface vendedorDAO
{
    public void insertarVendedor(Vendedor vendedor);
    public void modificarVendedor(Vendedor vendedor);
    public void eliminarVendedor(Vendedor vendedor);
    public List<Vendedor> mostrarVendedor();
    public List<Sexo> mostrarSexo();
}
