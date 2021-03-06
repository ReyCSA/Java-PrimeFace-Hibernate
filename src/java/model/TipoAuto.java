package model;
// Generated 11/05/2018 01:49:18 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TipoAuto generated by hbm2java
 */
public class TipoAuto  implements java.io.Serializable {


     private String idTipo;
     private Set<Pedidos> pedidoses = new HashSet<Pedidos>(0);
     private Set<Auto> autos = new HashSet<Auto>(0);

    public TipoAuto() {
    }

	
    public TipoAuto(String idTipo) {
        this.idTipo = idTipo;
    }
    public TipoAuto(String idTipo, Set<Pedidos> pedidoses, Set<Auto> autos) {
       this.idTipo = idTipo;
       this.pedidoses = pedidoses;
       this.autos = autos;
    }
   
    public String getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }
    public Set<Pedidos> getPedidoses() {
        return this.pedidoses;
    }
    
    public void setPedidoses(Set<Pedidos> pedidoses) {
        this.pedidoses = pedidoses;
    }
    public Set<Auto> getAutos() {
        return this.autos;
    }
    
    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }




}


