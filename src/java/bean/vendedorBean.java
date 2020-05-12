package bean;

import dao.sexoDAO;
import dao.sexoDAOImplements;
import dao.vendedorDAO;
import dao.vendedorDAOImplements;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import model.Sexo;
import model.Vendedor;

@ManagedBean
@ViewScoped
public class vendedorBean 
{
    
    private Vendedor vendedor;
    private List<Vendedor> vendedores;
    private List<Vendedor> vendedoresFiltrados;
    private List<SelectItem> listaSexo;
    
    public vendedorBean() 
    {
        vendedor = new Vendedor();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getVendedores() {
        vendedorDAO dao = new vendedorDAOImplements();
        vendedores = dao.mostrarVendedor();
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<Vendedor> getVendedoresFiltrados() {
        return vendedoresFiltrados;
    }

    public void setVendedoresFiltrados(List<Vendedor> vendedoresFiltrados) {
        this.vendedoresFiltrados = vendedoresFiltrados;
    }

    public List<SelectItem> getListaSexo() {
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
        vendedorDAO dao = new vendedorDAOImplements();
        dao.insertarVendedor(vendedor);
        vendedor = new Vendedor();
        addMessage("Agregado!!");
    }
    
    public void actualiza()
    {
        vendedorDAO dao = new vendedorDAOImplements();
        dao.modificarVendedor(vendedor);
        vendedor = new Vendedor();
        addMessage("Actualizado!!");
    }
    
    public void elimina()
    {
        vendedorDAO dao = new vendedorDAOImplements();
        dao.eliminarVendedor(vendedor);
        vendedor = new Vendedor();
        addMessage("Eliminado!!");
    }
}
