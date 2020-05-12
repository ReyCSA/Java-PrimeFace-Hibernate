package model;
// Generated 11/05/2018 01:49:18 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Venta generated by hbm2java
 */
public class Venta  implements java.io.Serializable {


     private Integer idVenta;
     private Auto auto;
     private Cliente cliente;
     private Vendedor vendedor;
     private Date fecha;
     private Double preciouni;
     private Byte cantidad;
     private Double iva;
     private Double descuento;
     private Double total;
     private String decripcion;

    public Venta() 
    {
        auto = new Auto();
        cliente = new Cliente();
        vendedor = new Vendedor();
    }

    public Venta(Auto auto, Cliente cliente, Vendedor vendedor, Date fecha, Double preciouni, Byte cantidad, Double iva, Double descuento, Double total, String decripcion) {
       this.auto = auto;
       this.cliente = cliente;
       this.vendedor = vendedor;
       this.fecha = fecha;
       this.preciouni = preciouni;
       this.cantidad = cantidad;
       this.iva = iva;
       this.descuento = descuento;
       this.total = total;
       this.decripcion = decripcion;
    }
   
    public Integer getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Auto getAuto() {
        return this.auto;
    }
    
    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Vendedor getVendedor() {
        return this.vendedor;
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Double getPreciouni() {
        return this.preciouni;
    }
    
    public void setPreciouni(Double preciouni) {
        this.preciouni = preciouni;
    }
    public Byte getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Byte cantidad) {
        this.cantidad = cantidad;
    }
    public Double getIva() {
        return this.iva;
    }
    
    public void setIva(Double iva) {
        this.iva = iva;
    }
    public Double getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    public String getDecripcion() {
        return this.decripcion;
    }
    
    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }




}


