package bean;

import dao.clienteDAO;
import dao.clienteDAOImplements;
import dao.sexoDAO;
import dao.sexoDAOImplements;
import dao.tipoClienteDAO;
import dao.tipoClienteDAOImplements;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Cliente;
import model.Sexo;
import model.TipoCliente;

@ManagedBean
@ViewScoped
public class clienteBean 
{
    private Cliente cliente;
    private List<Cliente> clientes;
    private List<Cliente> clientesFiltrados;
    private List<SelectItem> listaSexo;
    private List<SelectItem> listaTipo;
    
    public clienteBean() 
    {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() 
    {
        clienteDAO dao = new clienteDAOImplements();
        clientes = dao.mostrarCliente();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientesFiltrados() {
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
        this.clientesFiltrados = clientesFiltrados;
    }

    public List<SelectItem> getListaSexo() 
    {
        this.listaSexo = new ArrayList<SelectItem>();
        sexoDAO dao = new sexoDAOImplements();
        List<Sexo> sex = dao.mostrarSexo();
        listaSexo.clear();
        for(Sexo tipo: sex)
        {
            SelectItem proveedorItem = new SelectItem(tipo.getIdSexo());
            this.listaSexo.add(proveedorItem);
        }
        return listaSexo;
    }
    
    public void setListaSexo(List<SelectItem> listaSexo) {
        this.listaSexo = listaSexo;
    }
    
    public List<SelectItem> getListaTipo() 
    {
        this.listaTipo = new ArrayList<SelectItem>();
        tipoClienteDAO dao = new tipoClienteDAOImplements();
        List<TipoCliente> tc = dao.mostrarTipoCliente();
        listaTipo.clear();
        for(TipoCliente tipo: tc)
        {
            SelectItem proveedorItem = new SelectItem(tipo.getIdTipoCte());
            this.listaTipo.add(proveedorItem);
        }
        return listaTipo;
    }

    public void setListaTipo(List<SelectItem> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar()
    {
        clienteDAO dao = new clienteDAOImplements();
        dao.insertarCliente(cliente);
        cliente = new Cliente();
        addMessage("Agregado!!");
    }
    
    public void actualiza()
    {
        clienteDAO dao = new clienteDAOImplements();
        dao.modificarCliente(cliente);
        cliente = new Cliente();
        addMessage("Actualizado!!");
    }
    
    public void elimina()
    {
        clienteDAO dao = new clienteDAOImplements();
        dao.eliminarCliente(cliente);
        cliente = new Cliente();
        addMessage("Eliminado!!");
    }
}
