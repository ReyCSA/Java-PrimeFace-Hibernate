package bean;

import dao.proveedorDAO;
import dao.proveedorDAOImplements;
import dao.sexoDAO;
import dao.sexoDAOImplements;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Proveedor;
import model.Sexo;

@ManagedBean
@ViewScoped
public class proveedorBean 
{
    private Proveedor proveedor;
    private List<Proveedor> proveedores;
    private List<Proveedor> proveedorFiltrados;
    private List<SelectItem> listaSexo;
    
    public proveedorBean() 
    {
        proveedor = new Proveedor();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getProveedores() 
    {
        proveedorDAO dao = new proveedorDAOImplements();
        proveedores = dao.mostrarProveedor();
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Proveedor> getProveedorFiltrados() {
        return proveedorFiltrados;
    }

    public void setProveedorFiltrados(List<Proveedor> proveedorFiltrados) {
        this.proveedorFiltrados = proveedorFiltrados;
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
    
    public void addMessage(String summary) 
    {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar()
    {
        proveedorDAO dao = new proveedorDAOImplements();
        dao.insertarProveedor(proveedor);
        proveedor = new Proveedor();
        addMessage("Agregado!!");
    }
    
    public void actualiza()
    {
        proveedorDAO dao = new proveedorDAOImplements();
        dao.modificarProveedor(proveedor);
        proveedor = new Proveedor();
        addMessage("Actualizado!!");
    }
    
    public void elimina()
    {
        proveedorDAO dao = new proveedorDAOImplements();
        dao.eliminarProveedor(proveedor);
        proveedor = new Proveedor();
        addMessage("Eliminado!!");
    }
}
