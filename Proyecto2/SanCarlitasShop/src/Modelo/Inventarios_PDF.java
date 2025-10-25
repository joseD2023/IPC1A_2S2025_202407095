/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Admin
 */
public class Inventarios_PDF {
    private String nombre_producto; 
    private double  cantidad_total_vendida;
    private String categoria_productos; 
    private double ingreseos_generados; 
    
    //para la partede los mas vendidos 
    
    //produto menos vendidos 
    private int stock_actual_disponible; 
    private String recomendaciones_promocion; 
    
    
    //ahora para reporte inventarios 
    private String codigo_producto;
    private String estado_critico;
    private String fecha_actualizacion_stock; 
    private String sugerencia_reabastecimiento;
    
    //ahora para ventas de vendedor 
    private String codigo_vendedor;
    private String nombre_vendedor;
    private String cantidad_pedido_confirmados;
    private double ventas_generadas;
    private String producto_mas_vendido_vendedor;
    
    
    //reportes clientes activos 
    private String codigo_cliente;
    private String nombre_cliente;
    private String fecha_ultima_compra;
    private String producto_favoritos_del_cliente;
    
    
    //reportes financieros 
    
    
    //reportes productos 
    private String fecha_caducidad; 
    private String dias_restantes_vencimiento;
    //private String stock_actual_disponible; ya lo tengo 
    private double valor_monetario_en_riesgo;
    private String estado_prioriedad; //critico:1-3 dias urgente: 4-7 dias
    
    
    /*CONSTRUCTOR PARA PRODUCTOS MAS VENDIDOS */

    public Inventarios_PDF(String nombre_producto, double cantidad_total_vendida, String categoria_productos, double ingreseos_generados) {
        this.nombre_producto = nombre_producto;
        this.cantidad_total_vendida = cantidad_total_vendida;
        this.categoria_productos = categoria_productos;
        this.ingreseos_generados = ingreseos_generados;
    }
    
    
    /*CONSTRUCTOR PARA PRODUCTOS MENOS VENDIDOS */

    public Inventarios_PDF(String nombre_producto, double cantidad_total_vendida, int stock_actual_disponible, String recomendaciones_promocion) {
        this.nombre_producto = nombre_producto;
        this.cantidad_total_vendida = cantidad_total_vendida;
        this.stock_actual_disponible = stock_actual_disponible;
        this.recomendaciones_promocion = recomendaciones_promocion;
    }
    
    
    
    /*CONSTRUCTOR PARA INVENTARIOS GENERALES */

    public Inventarios_PDF(String nombre_producto, String categoria_productos, int stock_actual_disponible, String codigo_producto, String estado_critico, String fecha_actualizacion_stock, String sugerencia_reabastecimiento) {
        this.nombre_producto = nombre_producto;
        this.categoria_productos = categoria_productos;
        this.stock_actual_disponible = stock_actual_disponible;
        this.codigo_producto = codigo_producto;
        this.estado_critico = estado_critico;
        this.fecha_actualizacion_stock = fecha_actualizacion_stock;
        this.sugerencia_reabastecimiento = sugerencia_reabastecimiento;
    }
    
    
    
    /*CONSTRUCTOR PARA REPORTES DE VENTA DE VENDEDORES */

    public Inventarios_PDF(String codigo_vendedor, String nombre_vendedor, String cantidad_pedido_confirmados, double ventas_generadas, String producto_mas_vendido_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
        this.nombre_vendedor = nombre_vendedor;
        this.cantidad_pedido_confirmados = cantidad_pedido_confirmados;
        this.ventas_generadas = ventas_generadas;
        this.producto_mas_vendido_vendedor = producto_mas_vendido_vendedor;
    }
    
    
    /*CONSTRUCTOR PARA CLIENTES ACTIVOS */

    public Inventarios_PDF(String codigo_cliente, String nombre_cliente, String fecha_ultima_compra, String producto_favoritos_del_cliente) {
        this.codigo_cliente = codigo_cliente;
        this.nombre_cliente = nombre_cliente;
        this.fecha_ultima_compra = fecha_ultima_compra;
        this.producto_favoritos_del_cliente = producto_favoritos_del_cliente;
    }
    
    
    /*CONSTRUCTOR PARA PRODUCTOS POR CADUCAR */

    public Inventarios_PDF(String nombre_producto, int stock_actual_disponible, String codigo_producto, String fecha_caducidad, String dias_restantes_vencimiento, double valor_monetario_en_riesgo, String estado_prioriedad) {
        this.nombre_producto = nombre_producto;
        this.stock_actual_disponible = stock_actual_disponible;
        this.codigo_producto = codigo_producto;
        this.fecha_caducidad = fecha_caducidad;
        this.dias_restantes_vencimiento = dias_restantes_vencimiento;
        this.valor_monetario_en_riesgo = valor_monetario_en_riesgo;
        this.estado_prioriedad = estado_prioriedad;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getCantidad_total_vendida() {
        return cantidad_total_vendida;
    }

    public void setCantidad_total_vendida(double cantidad_total_vendida) {
        this.cantidad_total_vendida = cantidad_total_vendida;
    }

    public String getCategoria_productos() {
        return categoria_productos;
    }

    public void setCategoria_productos(String categoria_productos) {
        this.categoria_productos = categoria_productos;
    }

    public double getIngreseos_generados() {
        return ingreseos_generados;
    }

    public void setIngreseos_generados(double ingreseos_generados) {
        this.ingreseos_generados = ingreseos_generados;
    }

    public int getStock_actual_disponible() {
        return stock_actual_disponible;
    }

    public void setStock_actual_disponible(int stock_actual_disponible) {
        this.stock_actual_disponible = stock_actual_disponible;
    }

    public String getRecomendaciones_promocion() {
        return recomendaciones_promocion;
    }

    public void setRecomendaciones_promocion(String recomendaciones_promocion) {
        this.recomendaciones_promocion = recomendaciones_promocion;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getEstado_critico() {
        return estado_critico;
    }

    public void setEstado_critico(String estado_critico) {
        this.estado_critico = estado_critico;
    }

    public String getFecha_actualizacion_stock() {
        return fecha_actualizacion_stock;
    }

    public void setFecha_actualizacion_stock(String fecha_actualizacion_stock) {
        this.fecha_actualizacion_stock = fecha_actualizacion_stock;
    }

    public String getSugerencia_reabastecimiento() {
        return sugerencia_reabastecimiento;
    }

    public void setSugerencia_reabastecimiento(String sugerencia_reabastecimiento) {
        this.sugerencia_reabastecimiento = sugerencia_reabastecimiento;
    }

    public String getCodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setCodigo_vendedor(String codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getCantidad_pedido_confirmados() {
        return cantidad_pedido_confirmados;
    }

    public void setCantidad_pedido_confirmados(String cantidad_pedido_confirmados) {
        this.cantidad_pedido_confirmados = cantidad_pedido_confirmados;
    }

    public double getVentas_generadas() {
        return ventas_generadas;
    }

    public void setVentas_generadas(double ventas_generadas) {
        this.ventas_generadas = ventas_generadas;
    }

    public String getProducto_mas_vendido_vendedor() {
        return producto_mas_vendido_vendedor;
    }

    public void setProducto_mas_vendido_vendedor(String producto_mas_vendido_vendedor) {
        this.producto_mas_vendido_vendedor = producto_mas_vendido_vendedor;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getFecha_ultima_compra() {
        return fecha_ultima_compra;
    }

    public void setFecha_ultima_compra(String fecha_ultima_compra) {
        this.fecha_ultima_compra = fecha_ultima_compra;
    }

    public String getProducto_favoritos_del_cliente() {
        return producto_favoritos_del_cliente;
    }

    public void setProducto_favoritos_del_cliente(String producto_favoritos_del_cliente) {
        this.producto_favoritos_del_cliente = producto_favoritos_del_cliente;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getDias_restantes_vencimiento() {
        return dias_restantes_vencimiento;
    }

    public void setDias_restantes_vencimiento(String dias_restantes_vencimiento) {
        this.dias_restantes_vencimiento = dias_restantes_vencimiento;
    }

    public double getValor_monetario_en_riesgo() {
        return valor_monetario_en_riesgo;
    }

    public void setValor_monetario_en_riesgo(double valor_monetario_en_riesgo) {
        this.valor_monetario_en_riesgo = valor_monetario_en_riesgo;
    }

    public String getEstado_prioriedad() {
        return estado_prioriedad;
    }

    public void setEstado_prioriedad(String estado_prioriedad) {
        this.estado_prioriedad = estado_prioriedad;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
