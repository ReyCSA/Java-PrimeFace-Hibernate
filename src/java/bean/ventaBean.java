package bean;

import dao.autoDAO;
import dao.autoDAOImplements;
import dao.clienteDAO;
import dao.clienteDAOImplements;
import dao.vendedorDAO;
import dao.vendedorDAOImplements;
import dao.ventaDAO;
import dao.ventaDAOImplements;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Auto;
import model.Cliente;
import model.Vendedor;
import model.Venta;

@ManagedBean
@ViewScoped
public class ventaBean 
{

    private Venta venta;
    private List<Venta> ventas;
    private List<Venta> ventasFiltrados;
    private List<SelectItem> listaVendedor;
    private List<SelectItem> listaCliente;
    private List<SelectItem> listaAuto;
    
    public ventaBean() 
    {
        venta = new Venta();
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getVentas() 
    {
        ventaDAO dao = new ventaDAOImplements();
        ventas = dao.mostrarVentas();
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Venta> getVentasFiltrados() {
        return ventasFiltrados;
    }

    public void setVentasFiltrados(List<Venta> ventasFiltrados) {
        this.ventasFiltrados = ventasFiltrados;
    }

    public List<SelectItem> getListaVendedor() 
    {
        this.listaVendedor = new ArrayList<SelectItem>();
        vendedorDAO dao = new vendedorDAOImplements();
        List<Vendedor> tc = dao.mostrarVendedor();
        listaVendedor.clear();
        for(Vendedor tipo: tc)
        {
            SelectItem vendedordorItem = new SelectItem(tipo.getIdVendedor(), tipo.getIdVendedor()+ " " + tipo.getNombre() + " " + tipo.getApaterno());
            this.listaVendedor.add(vendedordorItem);
        }
        return listaVendedor;
    }

    public void setListaVendedor(List<SelectItem> listaVendedor) {
        this.listaVendedor = listaVendedor;
    }

    public List<SelectItem> getListaCliente() {
        this.listaCliente = new ArrayList<SelectItem>();
        clienteDAO dao = new clienteDAOImplements();
        List<Cliente> tc = dao.mostrarCliente();
        listaCliente.clear();
        for(Cliente tipo: tc)
        {
            SelectItem clienteItem = new SelectItem(tipo.getIdCliente(), tipo.getIdCliente()+ " " + tipo.getNombre() + " " + tipo.getApaterno());
            this.listaCliente.add(clienteItem);
        }
        return listaCliente;
    }

    public void setListaCliente(List<SelectItem> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<SelectItem> getListaAuto() 
    {
        this.listaAuto = new ArrayList<SelectItem>();
        autoDAO dao = new autoDAOImplements();
        List<Auto> tc = dao.mostrarAuto();
        listaAuto.clear();
        for(Auto tipo: tc)
        {
            SelectItem autoItem = new SelectItem(tipo.getIdAuto(), tipo.getIdAuto() + " " + tipo.getMarca()+ " " + tipo.getModelo() + " " + tipo.getColor());
            this.listaAuto.add(autoItem);
        }
        return listaAuto;
    }

    public void setListaAuto(List<SelectItem> listaAuto) {
        this.listaAuto = listaAuto;
    }
     
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar()
    {
        ventaDAO dao = new ventaDAOImplements();
        dao.insertarVenta(venta);
        venta = new Venta();
        addMessage("Agregado!!");
    }
    
    public void actualiza()
    {
        ventaDAO dao = new ventaDAOImplements();
        dao.modificarVenta(venta);
        venta = new Venta();
        addMessage("Actualizado!!");
    }
    
    public void elimina()
    {
        ventaDAO dao = new ventaDAOImplements();
        dao.eliminarVenta(venta);
        venta = new Venta();
        addMessage("Eliminado!!");
    }
    
}
