/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Producto_Alimentos;
import Modelo.Producto_General;
import Modelo.Producto_Tecnologia;
import javax.swing.JOptionPane;




public class Crear_producto extends javax.swing.JFrame {
    
    
    Modulo_Administrador regresar; // esto me ayuda a regresar y usar metodos de el modulo admi

    

  
    public Crear_producto(Modulo_Administrador r) {
        initComponents();
       regresar = r;
    }
    
    public void limpiar(){
        entrada_codigo.setText("");
        entrada_nombre.setText("");
        entrada_atributo_unico.setText("");
        entrada_precio.setText("");
        entrada_stock.setText("");
    }
    
    
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boton_crear_producto = new javax.swing.JButton();
        entrada_codigo = new javax.swing.JTextField();
        entrada_nombre = new javax.swing.JTextField();
        entrada_atributo_unico = new javax.swing.JTextField();
        obtencion_categoria = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        entrada_precio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        entrada_stock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear Producto");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Crear Producto");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Categoria");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Atributo Unico");

        boton_crear_producto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boton_crear_producto.setText("Crear");
        boton_crear_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crear_productoActionPerformed(evt);
            }
        });

        obtencion_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnologia", "Alimento", "General" }));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Precio Producto");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Numero De Stock");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(entrada_codigo)
                            .addComponent(entrada_nombre)
                            .addComponent(obtencion_categoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(entrada_atributo_unico)
                            .addComponent(entrada_precio)
                            .addComponent(entrada_stock))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_crear_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)))
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(entrada_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(entrada_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(obtencion_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(entrada_atributo_unico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(entrada_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(entrada_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2))
                    .addComponent(boton_crear_producto))
                .addGap(17, 17, 17))
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

    private void boton_crear_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crear_productoActionPerformed
     
        
        String codigo = entrada_codigo.getText().trim();
        String nombre = entrada_nombre.getText().trim(); 
        String categoria = obtencion_categoria.getSelectedItem().toString(); 
        String atributo_unico = entrada_atributo_unico.getText().trim(); 
        String precio = entrada_precio.getText().trim(); 
        String stock = entrada_stock.getText().trim();
        
        
        // Validar campos vacíos
        if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty() || atributo_unico.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Complete todos los campos");
          return;
         }
        
        // Validar código único
        
        if(Controlador.Controlador_Productos.validacionCodigo(codigo)){
            JOptionPane.showMessageDialog(this, "El código ya existe");
        return;  
        }
        
        try {
            double precio_conversion = Double.parseDouble(precio);
            if(precio_conversion <= 0){
                JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0");
                    return; 
                
            }
        }catch(NumberFormatException e ){
            JOptionPane.showMessageDialog(null, "Precio debe ser un número válido");
        return;
            
        }
        
        if(!Controlador.Controlador_Productos.validarStock(stock)){
            JOptionPane.showMessageDialog(null, "El stock debe ser un numero valido o Mayor a 0");
            return; 
        }
        
        switch(categoria){
            case "Tecnologia":
                try{
                
                int meses = Integer.parseInt(atributo_unico); 
                if(meses <= 0){
                    JOptionPane.showMessageDialog(null, "Meses de garantía deben ser mayor a 0");
                    return; 
                }
                
                Producto_Tecnologia producto1 = new Producto_Tecnologia(codigo, nombre, categoria, atributo_unico, Double.parseDouble(precio), Integer.parseInt(stock));
                Controlador.Controlador_Productos.crearProductos(producto1);
                JOptionPane.showMessageDialog(null, "Produdcto Agrado Exitosamente");
                
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Meses de garantia debe ser Numeros");
                return; 
                
            }
                break;
            case "Alimento":
                if(!atributo_unico.matches("\\d{2}/\\d{2}/\\d{4}")){ 
            JOptionPane.showMessageDialog(null, "Formato de fecha: DD/MM/YYYY");
            return;
                
            }
                
                Producto_Alimentos producto2 = new Producto_Alimentos(codigo, nombre, categoria, atributo_unico, Double.parseDouble(precio), Integer.parseInt(stock));
                Controlador.Controlador_Productos.crearProductos(producto2);
                JOptionPane.showMessageDialog(null, "Produdcto Agrado Exitosamente");
                
                
                break; 
            case "General": 
                
                Producto_General producto3 = new Producto_General(codigo, nombre, categoria, atributo_unico, Double.parseDouble(precio), Integer.parseInt(stock));
                Controlador.Controlador_Productos.crearProductos(producto3);
                JOptionPane.showMessageDialog(null, "Produdcto Agrado Exitosamente");
                break;
            
        }
        limpiar();
        
        
        
    }//GEN-LAST:event_boton_crear_productoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // REGRESAR A LA PESTAÑA ACTUAL 
        
        
       
        regresar.mostrarConPestanaActual();
        regresar.visualizarTablaProducto();
        this.dispose();
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_crear_producto;
    private javax.swing.JTextField entrada_atributo_unico;
    private javax.swing.JTextField entrada_codigo;
    private javax.swing.JTextField entrada_nombre;
    private javax.swing.JTextField entrada_precio;
    private javax.swing.JTextField entrada_stock;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> obtencion_categoria;
    // End of variables declaration//GEN-END:variables
}
