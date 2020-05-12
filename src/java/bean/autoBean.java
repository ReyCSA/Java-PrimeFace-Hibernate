package bean;

import dao.autoDAO;
import dao.autoDAOImplements;
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
import model.Auto;
import model.Proveedor;
import model.TipoAuto;

@ManagedBean
@ViewScoped
public class autoBean 
{
    
    private Auto auto;
    private List<Auto> autos;
    private List<Auto> autosFiltrados;
    private List<SelectItem> listaProveedor;
    private List<SelectItem> listaTipo;
    
    public autoBean() 
    {
        auto = new Auto();
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public List<Auto> getAutos() 
    {
        autoDAO dao = new autoDAOImplements();
        autos = dao.mostrarAuto();
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public List<Auto> getAutosFiltrados() {
        return autosFiltrados;
    }

    public void setAutosFiltrados(List<Auto> autosFiltrados) {
        this.autosFiltrados = autosFiltrados;
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
        autoDAO dao = new autoDAOImplements();
        dao.insertarAuto(auto);
        auto = new Auto();
        addMessage("Agregado!!");
    }
    
    public void actualiza()
    {
        autoDAO dao = new autoDAOImplements();
        dao.modificarAuto(auto);
        auto = new Auto();
        addMessage("Actualizado!!");
    }
    
    public void elimina()
    {
        autoDAO dao = new autoDAOImplements();
        dao.eliminarAuto(auto);
        auto = new Auto();
        addMessage("Eliminado!!");
    }
}
