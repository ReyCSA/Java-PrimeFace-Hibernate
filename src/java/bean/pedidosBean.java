package bean;

import dao.pedidosDAO;
import dao.pedidosDAOImplements;
import dao.proveedorDAO;
import dao.proveedorDAOImplements;
import dao.tipoAutoDAO;
import dao.tipoAutoDAOImplements;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Pedidos;
import model.Proveedor;
import model.TipoAuto;

@ManagedBean
@ViewScoped
public class pedidosBean 
{

    private Pedidos pedido;
    private List<Pedidos> pedidos;
    private List<Pedidos> pedidosFiltrados;
    private List<SelectItem> listaProveedor;
    private List<SelectItem> listaTipo;
    
    public pedidosBean() 
    {
        pedido = new Pedidos();
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public List<Pedidos> getPedidos() 
    {
        pedidosDAO dao = new pedidosDAOImplements();
        pedidos = dao.mostrarPedidos();
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Pedidos> getPedidosFiltrados() {
        return pedidosFiltrados;
    }

    public void setPedidosFiltrados(List<Pedidos> pedidosFiltrados) {
        this.pedidosFiltrados = pedidosFiltrados;
    }

    public List<SelectItem> getListaProveedor() 
    {
        this.listaProveedor = new ArrayList<SelectItem>();
        proveedorDAO dao = new proveedorDAOImplements();
        List<Proveedor> tc = dao.mostrarProveedor();
        listaProveedor.clear();
        for(Proveedor tipo: tc)
        {
            SelectItem proveedorItem = new SelectItem(tipo.getIdProveedor(), tipo.getIdProveedor() + " " + tipo.getNombre() + " " + tipo.getApaterno() + " " + tipo.getEmpresa());
            this.listaProveedor.add(proveedorItem);
        }
        return listaProveedor;
    }

    public void setListaProveedor(List<SelectItem> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public List<SelectItem> getListaTipo() 
    {
        this.listaTipo = new ArrayList<SelectItem>();
        tipoAutoDAO dao = new tipoAutoDAOImplements();
        List<TipoAuto> tc = dao.mostrarTipoAuto();
        listaTipo.clear();
        for(TipoAuto tipo: tc)
        {
            SelectItem proveedorItem = new SelectItem(tipo.getIdTipo());
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
        pedidosDAO dao = new pedidosDAOImplements();
        dao.insertarPedido(pedido);
        pedido = new Pedidos();
        addMessage("Agregado!!");
    }
    
    public void actualiza()
    {
        pedidosDAO dao = new pedidosDAOImplements();
        dao.modificarPedido(pedido);
        pedido = new Pedidos();
        addMessage("Actualizado!!");
    }
    
    public void elimina()
    {
        pedidosDAO dao = new pedidosDAOImplements();
        dao.eliminarPedido(pedido);
        pedido = new Pedidos();
        addMessage("Eliminado!!");
    }
    
}
