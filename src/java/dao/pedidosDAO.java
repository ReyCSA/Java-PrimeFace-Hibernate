package dao;

import java.util.List;
import model.Pedidos;
import model.Proveedor;
import model.TipoAuto;

public interface pedidosDAO 
{
    public void insertarPedido(Pedidos pedido);
    public void modificarPedido(Pedidos pedido);
    public void eliminarPedido(Pedidos pedido);
    public List<Pedidos> mostrarPedidos();
    public List<Proveedor> mostrarProveedor();
    public List<TipoAuto> mostrarTipo();
}
