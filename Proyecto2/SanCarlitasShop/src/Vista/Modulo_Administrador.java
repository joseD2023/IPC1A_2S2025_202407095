/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorPDF;
import Controlador.Controlador_Productos;
import Controlador.Controlador_Vendedor;
import Modelo.EventoBitacora;
import Modelo.Inventarios_PDF;
import Modelo.Productos;
import Modelo.Tablareader;
import Modelo.Vendedor;
import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File; 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Admin
 */
public class Modulo_Administrador extends javax.swing.JFrame {
    DefaultTableModel tabla_admi = new DefaultTableModel(); // TABLA PARA VER LOS Vendedores
    DefaultTableModel tabla_pro = new DefaultTableModel();
    static int pestaña_actual; // obtener pestañas actuales 
    public static String admi =" ";
  
   

    
    
    
    public Modulo_Administrador() {      
        initComponents();
        
        String[] Encabezados ={"Codigo", "Nombre", "Genero", "Cantidad de ventas Confirmadas"};
        String[] encabezados_producto = {"Codigo", "Nombre", "Categoria", "Acciones"};
        
        tabla_admi.setColumnIdentifiers(Encabezados);
        tabla_pro.setColumnIdentifiers(encabezados_producto); // ordenamos nuestro encabezados 
        tabbed_vendedores.setModel(tabla_admi);
        tabla_producto.setModel(tabla_pro);
        
        
        TabbedPane.setTabLayoutPolicy(TabbedPane.SCROLL_TAB_LAYOUT);
        
        

        limpiar(tabla_pro);
        limpiar(tabla_admi);
        visualizarTablaProducto();
        visualizarTablaVendedores();
        mostrarBotones();
        
        
        
       

    }
    
    
    
    public void mostrarBotones(){
         tabla_producto.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int columna = tabla_producto.columnAtPoint(evt.getPoint());
            int fila = tabla_producto.rowAtPoint(evt.getPoint());
            if(columna == 3) {
                // tratar de crear una ventana 
                
                JDialog ventana = new JDialog(); 
                ventana.setTitle("Detalles Productos");
                ventana.setSize(400, 200);
                ventana.setLocationRelativeTo(ventana);
                ventana.setLayout(new BorderLayout());
                /*----------------------------------------*/
                
                String codigo = tabla_producto.getValueAt(fila, 0).toString();
                
                //obtendremos la informacion
                
                String informacion_productos = Controlador_Productos.mostrarDetallesProducto(codigo); 
                JLabel label1 = new JLabel(informacion_productos);
                label1.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
                ventana.add(label1, BorderLayout.CENTER);
                ventana.add(label1); 
                ventana.setVisible(true);
                
               
            }
        }
    });
    }
    
    
 
    
  
    
    public void limpiar(DefaultTableModel modelo){
        int filas = modelo.getRowCount(); 
        for(int i= filas-1; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    
    
    
    public void visualizarTablaProducto(){
       limpiar(tabla_pro);
       if(Controlador.Controlador_Productos.crear_producto != null && Controlador.Controlador_Productos.crear_producto.length > 0){
           for(Productos p: Controlador.Controlador_Productos.crear_producto){
               if(p!=null){
                   Object[] fila = {p.getCodigo_producto(), p.getNombre_producto(), p.getCategoria_producto(), "VER DETALLE"};
                   
                   tabla_pro.addRow(fila);
                   
               }
           }
       }
       
       tabla_producto.getColumnModel().getColumn(3).setCellRenderer(new Tablareader());
      
          
    }
    
    
    
    
    
    
    
    
    
    
    public void visualizarTablaVendedores(){
        limpiar(tabla_admi);
         for(int i=0; i< Controlador.Controlador_Vendedor.indice_vendedor;i++){
            Vendedor mostrar = Controlador.Controlador_Vendedor.crear_vendedor[i]; 
            if(mostrar != null){
                Object [] filas = {mostrar.getCodigo(), mostrar.getNombre(), mostrar.getGenero(), mostrar.getNumero_venta()};
                tabla_admi.addRow(filas);
            }
        }
    }
    
    
    
    
    
    public void mostrarConPestanaActual() {
      TabbedPane.setSelectedIndex(pestaña_actual); // selecciona la pestaña guardada
       this.setVisible(true); // muestra la ventana
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        boton_cargar = new javax.swing.JButton();
        boton_crear_vendedor = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabbed_vendedores = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        boton_bitacora = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        boton_crear_productos = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();
        boton_eliminar_producto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_producto = new javax.swing.JTable();
        boton_cargar_csv = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        boton_nasvendidos = new javax.swing.JButton();
        boton_menosvendidos = new javax.swing.JButton();
        boton_inventario = new javax.swing.JButton();
        boton_ventasVendedor = new javax.swing.JButton();
        boton_clientesActivos = new javax.swing.JButton();
        boton_reportesfinancieros = new javax.swing.JButton();
        boton_caducar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Administrador Usac");

        TabbedPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TabbedPane.setAlignmentX(1.0F);
        TabbedPane.setMinimumSize(new java.awt.Dimension(100, 100));
        TabbedPane.setName(""); // NOI18N

        boton_cargar.setText("Cargar");
        boton_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cargarActionPerformed(evt);
            }
        });

        boton_crear_vendedor.setText("Crear");
        boton_crear_vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crear_vendedorActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tabbed_vendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Genero", "Cantidad Ventas"
            }
        ));
        jScrollPane1.setViewportView(tabbed_vendedores);

        jButton1.setText("Cerrar Sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        boton_bitacora.setText("Bitacora");
        boton_bitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_bitacoraActionPerformed(evt);
            }
        });

        jButton5.setText("Datos Estudiantes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_bitacora)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(boton_crear_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton_crear_vendedor)
                            .addComponent(boton_cargar))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(boton_bitacora))
                    .addComponent(jButton5))
                .addContainerGap())
        );

        TabbedPane.addTab("                                Vendedores                                ", jPanel2);

        boton_crear_productos.setText("Crear");
        boton_crear_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crear_productosActionPerformed(evt);
            }
        });

        boton_actualizar.setText("Actualizar");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });

        boton_eliminar_producto.setText("Eliminar");
        boton_eliminar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminar_productoActionPerformed(evt);
            }
        });

        tabla_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Acciones"
            }
        ));
        jScrollPane2.setViewportView(tabla_producto);

        boton_cargar_csv.setText("Cargar");
        boton_cargar_csv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cargar_csvActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Detalles");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boton_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(boton_crear_productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_eliminar_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_cargar_csv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jButton2)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(boton_crear_productos)
                        .addGap(34, 34, 34)
                        .addComponent(boton_actualizar)
                        .addGap(33, 33, 33)
                        .addComponent(boton_eliminar_producto)
                        .addGap(43, 43, 43)
                        .addComponent(boton_cargar_csv))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        TabbedPane.addTab("                                Productos                                 ", jPanel3);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Los 5 Productos Mas Vendidos");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Los 5 Productos Menos Vendidos");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Reporte Inventario");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Reportes de Ventas por Vendedor");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Reportes Clientes Activos");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Reportes Financieros");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Reportes Por Caducar");

        boton_nasvendidos.setText("PDF");
        boton_nasvendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_nasvendidosActionPerformed(evt);
            }
        });

        boton_menosvendidos.setText("PDF");

        boton_inventario.setText("PDF");
        boton_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_inventarioActionPerformed(evt);
            }
        });

        boton_ventasVendedor.setText("PDF");

        boton_clientesActivos.setText("PDF");

        boton_reportesfinancieros.setText("PDF");

        boton_caducar.setText("PDF");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(boton_nasvendidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_menosvendidos)
                .addGap(196, 196, 196)
                .addComponent(boton_inventario)
                .addGap(162, 162, 162))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(boton_ventasVendedor)
                .addGap(199, 199, 199)
                .addComponent(boton_clientesActivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_reportesfinancieros)
                .addGap(155, 155, 155))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel5)))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(boton_caducar)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton_nasvendidos)
                            .addComponent(boton_menosvendidos)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(boton_inventario)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_reportesfinancieros)
                    .addComponent(boton_ventasVendedor)
                    .addComponent(boton_clientesActivos))
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addComponent(boton_caducar)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        TabbedPane.addTab("                               Reportes                              ", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_crear_vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crear_vendedorActionPerformed
        //CREAR VENDEDORES
        
        pestaña_actual = TabbedPane.getSelectedIndex();
        //aqui vamos a crear a los vendendores 
        new  Crear_vendedor(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_crear_vendedorActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Ir ventana Vendedor
        
        Actualizar_vendedor v1 = new Actualizar_vendedor();
        v1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        new Eliminar_vendendor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void boton_eliminar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminar_productoActionPerformed
        // ELIMINAR PRODUCTOS 
        
        pestaña_actual = TabbedPane.getSelectedIndex(); 
        new Eliminar_Producto(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_eliminar_productoActionPerformed

    private void boton_crear_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crear_productosActionPerformed
        // CREAR PRODUCTOS EN OTRA VENTANA 
        
        pestaña_actual = TabbedPane.getSelectedIndex();
        new Crear_producto(this).setVisible(true);
        this.setVisible(false); // ocultamos nuestra ventan principal 
        
        
      
    }//GEN-LAST:event_boton_crear_productosActionPerformed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        // Actualizar Productos 
        pestaña_actual = TabbedPane.getSelectedIndex();
        new Actualizar_producto(this).setVisible(true);
        this.setVisible(false); // ocultamos neustra ventana principal 
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Vamos a regresar al login 
        EventoBitacora.registrarEvento("Administrador", admi, "Logout", "Exitosa", "Sesion Cerrada", "Normal");
        
        new Modulo_autenticacion().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cargarActionPerformed
        // ahora vamos a cargar el csv para agregarlos a neustro metodo del controlador vendedor 
        
        JFileChooser selecionar = new JFileChooser(); 
        
        // filtro para querer solo un tipo de documento 
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Csv", "csv"); 
        selecionar.setFileFilter(filtro);
        
        //Desactivar otros tipos de archivos 
        selecionar.setAcceptAllFileFilterUsed(false);
        
        
        int retornar_valor = selecionar.showOpenDialog(null); 
        
        
        
        if(retornar_valor == JFileChooser.APPROVE_OPTION){
            File archivo = selecionar.getSelectedFile();  // seleccionamos el archivo 
            
            Controlador_Vendedor.cargarCsv(archivo);
        }
        
        
        visualizarTablaVendedores();
        
        
        
        
        
        
    }//GEN-LAST:event_boton_cargarActionPerformed

    private void boton_cargar_csvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cargar_csvActionPerformed
        // cargar CSV al sistema pero de producto ahora 
        
        JFileChooser seleccionar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV", "csv");
        seleccionar.setFileFilter(filtro);
        
        //desactivar otros tipos de archivos 
        
        seleccionar.setAcceptAllFileFilterUsed(false);
        
        int retornar = seleccionar.showOpenDialog(null); 
        
        if(retornar== JFileChooser.APPROVE_OPTION){
            File archivo = seleccionar.getSelectedFile(); 
            Controlador.Controlador_Productos.cargarCsv(archivo);
        }
        
        visualizarTablaProducto();
        
        
        
    }//GEN-LAST:event_boton_cargar_csvActionPerformed

    private void boton_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_inventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_inventarioActionPerformed

    private void boton_nasvendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nasvendidosActionPerformed
        // PRODUCTOS MAS VENDIDOS (NECITAMOS GENERAR TODOS LOS PROUDCTOS QUE ESTENE 
        // 1. Obtener productos con ventas
    Inventarios_PDF[] productos = Controlador_Productos.obtenerProductosMasVendidos();
       
        String[] encabezados = {"Nombre del producto", "Cantidad total vendida", "Categoria del producto", "Ingresos generados"};
        //Controlador_Productos.generarReportesProductosMasVendidos();
ControladorPDF.generarReportesVentas(productos, encabezados);
        //Controlador.ControladorPDF.generarReportesVentas(Controlador_Productos.almacenamiento_mas_vendidos, encabezados);

    }//GEN-LAST:event_boton_nasvendidosActionPerformed

    private void boton_bitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_bitacoraActionPerformed
     
        new Bitacora().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_bitacoraActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        new Datos_Estudiante().setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

   
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
            java.util.logging.Logger.getLogger(Modulo_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulo_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulo_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulo_Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulo_Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_bitacora;
    private javax.swing.JButton boton_caducar;
    private javax.swing.JButton boton_cargar;
    private javax.swing.JButton boton_cargar_csv;
    private javax.swing.JButton boton_clientesActivos;
    private javax.swing.JButton boton_crear_productos;
    private javax.swing.JButton boton_crear_vendedor;
    private javax.swing.JButton boton_eliminar_producto;
    private javax.swing.JButton boton_inventario;
    private javax.swing.JButton boton_menosvendidos;
    private javax.swing.JButton boton_nasvendidos;
    private javax.swing.JButton boton_reportesfinancieros;
    private javax.swing.JButton boton_ventasVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabbed_vendedores;
    private javax.swing.JTable tabla_producto;
    // End of variables declaration//GEN-END:variables
}
