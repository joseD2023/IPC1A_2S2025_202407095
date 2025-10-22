/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Controlador_Productos;
import static Controlador.Controlador_pedidos.pedidos_clientes;
import Modelo.Cliente;
import Modelo.Pedidos;
import Modelo.Productos;
import Modelo.Vendedor;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Modulo_Vendedor extends javax.swing.JFrame {
    
    //necesitamos llenar nuestra jtable para esta ocasion 
    
    DefaultTableModel diseño = new DefaultTableModel(); // cremoas nuestro modelo 
    DefaultTableModel diseño_clientes = new DefaultTableModel();
    DefaultTableModel diseño_pedidos = new DefaultTableModel(); 
    static int pestaña_actual;

    
    
    
    
    
    
    
    public Modulo_Vendedor() {
        initComponents(); // inicializar todo 
        
        String[] encabezados = {"Codigo", "Nombre", "Categoria", "Stock", "Acciones"};
        String[] clientes_encabezados = {"Codigo", "Nombre", "Genero", "Fecha de Cumpleaños"};
        String[] pedidos_encabezados = {"Codigo Producto", "Fecha Generacion", "Codigo Cliente", "Nombre Cliente", "Total", "Opciones"};
        
        diseño_pedidos.setColumnIdentifiers(pedidos_encabezados);
        Jtabla_pedido.setModel(diseño_pedidos);
        
        
        diseño_clientes.setColumnIdentifiers(clientes_encabezados);
        jTable2.setModel(diseño_clientes);
        
        diseño.setColumnIdentifiers(encabezados);
        jTable1.setModel(diseño);
        
        limpiar(diseño);
        limpiar(diseño_clientes);
        limpiar(diseño_pedidos);
        visualizarTablaProducto();
        visualizacionClientes();
        visualizarTablaPedidos();
        
    }
    
    public void limpiar(DefaultTableModel modelo){
        int filas = modelo.getRowCount(); 
        for(int i= filas-1; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    
    
     public void visualizarTablaProducto(){
       limpiar(diseño);
       if(Controlador.Controlador_Productos.crear_producto != null && Controlador.Controlador_Productos.crear_producto.length > 0){
           for(Productos p: Controlador.Controlador_Productos.crear_producto){
               if(p!=null){
                   Object[] fila = {p.getCodigo_producto(), p.getNombre_producto(), p.getCategoria_producto(), p.getStock_productos()};
                   diseño.addRow(fila);
                   
               }
           }
       }
          
    }
     
      // mostrar Diseño cliente a neustra tabla 
     
     public void visualizacionClientes(){
         limpiar(diseño_clientes);
         if(Controlador.Controlador_Clientes.crear_clientes != null && Controlador.Controlador_Clientes.crear_clientes.length>0){
             for(Cliente c : Controlador.Controlador_Clientes.crear_clientes){
                 if(c != null){
                     Object[] filas = {c.getCodigo(), c.getNombre(), c.getGenero(), c.getCumple()};
                     diseño_clientes.addRow(filas);
                 }
             }
             
         }
         
     }
     
     
      public void visualizarTablaPedidos(){
        
        limpiar(diseño_pedidos); //limpiamos la tabla cada vez para no encontrar repetidos 
        
        if(pedidos_clientes != null && pedidos_clientes.length >0){
            for(Pedidos p: pedidos_clientes){
                if(p != null){
                    Object[] fila = {p.getCodigo_producto(),p.getFecha_generacion(),p.getCodigo_cliente(),p.getNombre_cliente(),p.getTotal_pagar(), "Confirmar"};
                    diseño_pedidos.addRow(fila);
                    
                }
                
            }
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //vamos a crear un metodo para que pueda mostrar pestañas 
    
    public void mostrarPestanaActual(){
        Tabbed.setSelectedIndex(pestaña_actual); // selecciona la pestaña guardada
        this.setVisible(true); // muestra la ventana 
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabbed = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        boton_cargar_stock = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        boton_crear_clientes = new javax.swing.JButton();
        boton_cargar_cliente = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Jtabla_pedido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Vendedor");

        Tabbed.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tabbed.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Stock", "Acciones"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Agregar Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        boton_cargar_stock.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boton_cargar_stock.setText("Cargar");
        boton_cargar_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cargar_stockActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar Sesion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_cargar_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(63, 63, 63)
                        .addComponent(boton_cargar_stock)
                        .addGap(174, 174, 174)
                        .addComponent(jButton3)
                        .addContainerGap())))
        );

        Tabbed.addTab("                                Productos                                  ", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Genero", "Fecha Cumpleaños"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        boton_crear_clientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boton_crear_clientes.setText("Crear");
        boton_crear_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crear_clientesActionPerformed(evt);
            }
        });

        boton_cargar_cliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boton_cargar_cliente.setText("Cargar");
        boton_cargar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cargar_clienteActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setText("Actualizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_cargar_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_crear_clientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(boton_crear_clientes)
                        .addGap(46, 46, 46)
                        .addComponent(boton_cargar_cliente)
                        .addGap(43, 43, 43)
                        .addComponent(jButton5)
                        .addGap(40, 40, 40)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        Tabbed.addTab("                                   Clientes                                   ", jPanel2);

        Jtabla_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Fecha Generacion", "Codigo Cliente", "Nombre Cliente", "Total", "Opciones"
            }
        ));
        jScrollPane3.setViewportView(Jtabla_pedido);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        Tabbed.addTab("                                   Pedidos                                   ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        new Agregar_Stock().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_crear_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crear_clientesActionPerformed
        // aqui vamos a crear la logica para crear a los clientes 
        pestaña_actual = Tabbed.getSelectedIndex(); 
        new Crear_cliente(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_crear_clientesActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Necesito irme a la vetnana actualizar 
        
        pestaña_actual = Tabbed.getSelectedIndex();
        new Actualizar_cliente(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // ir a la ventana eliminar 
        
        pestaña_actual = Tabbed.getSelectedIndex();
        new Eliminar_cliente(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void boton_cargar_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cargar_stockActionPerformed
      //cargar stock para ver los datos encontrados 
      
      //vamos a cargar los precios ya que en los productos no vienen los precios 
      
        JFileChooser stock = new JFileChooser();
        
        // nuestro filtro de stock 
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Csv", "csv");
        stock.setFileFilter(filtro);
        
        //desactivar otros tipos de archihvos 
        
        stock.setAcceptAllFileFilterUsed(false);
        
        int retornar = stock.showOpenDialog(null); 
        
        if(retornar == JFileChooser.APPROVE_OPTION){
            File archivo = stock.getSelectedFile(); 
            Controlador.Controlador_Productos.cargarCsvStock(archivo);
            
        }
        
        visualizarTablaProducto();
        
      
    }//GEN-LAST:event_boton_cargar_stockActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // vamos a cerrar sesion 
        
        new Modulo_autenticacion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void boton_cargar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cargar_clienteActionPerformed
        // vamos a cargar al cliente desde un Csv 
        
        JFileChooser selecionar_cliente = new JFileChooser();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Csv", "csv");
        selecionar_cliente.setFileFilter(filtro);
        
        //los archivos que no debe de verse 
        
        selecionar_cliente.setAcceptAllFileFilterUsed(false);
        
        int retornar = selecionar_cliente.showOpenDialog(null); 
        
        if(retornar== JFileChooser.APPROVE_OPTION){
            File archivo = selecionar_cliente.getSelectedFile(); 
            Controlador.Controlador_Clientes.cargarCsvClientes(archivo);
            
        }
        
        visualizacionClientes();
        
    }//GEN-LAST:event_boton_cargar_clienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Modulo_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulo_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulo_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulo_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulo_Vendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabla_pedido;
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JButton boton_cargar_cliente;
    private javax.swing.JButton boton_cargar_stock;
    private javax.swing.JButton boton_crear_clientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
