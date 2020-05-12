package dao;

import java.util.List;
import model.Cliente;
import model.Sexo;
import model.TipoCliente;

public interface clienteDAO 
{
    public void insertarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
    public List<Cliente> mostrarCliente();
    public List<Sexo> mostrarSexo();
    public List<TipoCliente> mostrarTipo();
}
