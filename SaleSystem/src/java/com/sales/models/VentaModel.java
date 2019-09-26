package com.sales.models;

/**
 *
 * @author Antony
 */
public class VentaModel {
    Integer id, item, idCliente, idEmpleado,idProducto, cantidad;
    String serie, descripcion, fecha, estado;
    Double precio, subtotal, monto; 

    public VentaModel() {
    }

    public VentaModel(Integer id, Integer item, Integer idCliente, Integer idEmpleado, Integer idProducto, Integer cantidad, String serie, String descripcion, String fecha, String estado, Double precio, Double subtotal, Double monto) {
        this.id = id;
        this.item = item;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.serie = serie;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.precio = precio;
        this.subtotal = subtotal;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
}
