package dao;

import java.util.List;
import model.Auto;
import model.Cliente;
import model.Vendedor;
import model.Venta;

public interface ventaDAO 
{
    public void insertarVenta(Venta venta);
    public void modificarVenta(Venta venta);
    public void eliminarVenta(Venta venta);
    public List<Venta> mostrarVentas();
    public List<Vendedor> mostrarVendedor();
    public List<Cliente> mostrarCliente();
    public List<Auto> mostrarAuto();
}
