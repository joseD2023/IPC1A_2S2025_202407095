/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.BatallaController;
import controlador.BatallasHistorial;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pokemones;
import modelo.Historial;
import java.io.File; 
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class GuardarCargaDatosSistemas extends javax.swing.JFrame {

  
    public GuardarCargaDatosSistemas() {
        initComponents();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        boton_guardar = new javax.swing.JButton();
        entrada_archivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area_datos = new javax.swing.JTextArea();

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos Sistema");

        jButton1.setText("Anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        boton_guardar.setText("Guardar Datos");
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Leer datos Txt");

        jButton4.setText("Leer Datos Txt");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Area_datos.setColumns(20);
        Area_datos.setRows(5);
        jScrollPane1.setViewportView(Area_datos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(entrada_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(406, 406, 406))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(220, 220, 220)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_guardar)
                        .addGap(48, 48, 48))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(entrada_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(boton_guardar)
                    .addComponent(jButton4))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //regresar al inicio 
       ArenaUsac regresar = new ArenaUsac();
       regresar.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        // Vamos a guardar los datos en un archivo txt 
        
        

        String textofecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));
        String rutaArchivo = "ArenaUsac"+textofecha;
        
        try{
            FileWriter escribir_documento = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Practica2\\"+ rutaArchivo, true);
            PrintWriter txt = new PrintWriter(escribir_documento);
            
            //vamos hacer los encabezados 
            
            String encabezados = "Nombre Pokemon"+ "|" + "Arma Pokemon"+ "|" +"Hp Pokemon"+"|" +"Ataque Pokemon"+"|" +"Velocidad ataque"+"|" +"Agilidad Pokemon"+"|" +"Defensa Pokemon";
            txt.println(encabezados);
            
            for(int i=0; i<BatallaController.indice_pokemon; i++){
                Pokemones poketxt = BatallaController.pokemon[i]; // acedo a todos mis pokemones 
                
                String linea = poketxt.getNombre_pokemon() + "        |" + " " + poketxt.getArma()+ "      |" + " " + poketxt.getHp()+ "      |" + " " + poketxt.getNivel_ataque() + "      |" + " " + poketxt.getVelocidad_ataque() + "      |" + " " +  poketxt.getAgilidad()+ "      |" + " " + poketxt.getDefensa();
                
                txt.println(linea);
            }
            
            txt.close();
            JOptionPane.showMessageDialog(null, "Archivo Creado");
            
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        
        //vamos con el historial tambien 
        
        try{
            FileWriter escribir_documento = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\IPC12S\\src\\main\\java\\IPC1_Actividades_202407095\\Practica2\\"+ rutaArchivo, true);
            PrintWriter txt = new PrintWriter(escribir_documento);
            
            //vamos hacer los encabezados 
            
            String encabezados_batallas = "Numero Batalla #" + "|" + "Fecha Batalla"+ "|" +"Participantes"+"|" +"Ganador";
            txt.println(encabezados_batallas);
            
            for(int i=0; i<BatallasHistorial.indice_batalla; i++){
                Historial histotxt = BatallasHistorial.historial_batallas[i]; // acedo a todos mis pokemones 
                
                String linea2 = histotxt.getNumero_batalla() + "          |" + " " + histotxt.getFecha()+ "          |" + " " + histotxt.getPokemon1()+ "          |" + " " + histotxt.getGanador();
                
                txt.println(linea2);
            }
            
            txt.close();
            JOptionPane.showMessageDialog(null, "Archivo Creado");
            
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        
        
        
        
        
        
        
        
       

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_boton_guardarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Vamos a leer los datos 
        
        JFileChooser seleccionar = new JFileChooser(); // creamos una instancia que nos va ayudar a buscar el documento txt
        
        //filtro para queres solo un tipo de documentos 
        
       FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
       
       seleccionar.setFileFilter(filtro); // le decimos que solo tome estos tipos de documentos en los filtros 
       
       int returnValue = seleccionar.showOpenDialog(null);
       
       if(returnValue == JFileChooser.APPROVE_OPTION){
           File archivo = seleccionar.getSelectedFile(); // seleccionamos el archivo y ahora va a tocar leerlo 
           
           try{
               BufferedReader leer = new BufferedReader(new FileReader(archivo));
               String linea; 
               
               while((linea = leer.readLine()) != null){
                   //aqui ya podmeos mostrar el archivo para mostrar el area text 
                   
                   String mensaje = linea + "\n";
                   Area_datos.append(mensaje);
                   //tenemos que crear columnas para acceder a cada componente y agregarlos a neustras instancia 
                   
                   String[] columnas = linea.trim().split("\\s+");
                   String nombre_pokemon = columnas[0];
                   String arma = columnas[1];
                   String hp = columnas[2];
                   String ataque = columnas[3];
                   String velocidad = columnas[4];
                   String agilidad = columnas[5];
                   String defensa = columnas[6];
                   
                   
                   
                   int id_nuevo = BatallaController.indice_pokemon;
                   
                   
                   
                   
                   
                   // tenemos que traer el constructor de Pokemones e historial para agregarlos nuevamente 
                   
                   Pokemones pokemon_viejo = new Pokemones(nombre_pokemon, arma, Integer.parseInt(hp),Integer.parseInt(ataque), Integer.parseInt(velocidad), Integer.parseInt(agilidad), Integer.parseInt(defensa), id_nuevo);
                  
                   
                   
               }
               
               
           }catch(IOException e){
               JOptionPane.showMessageDialog(null, e);
               
           }
          
       }
       
       
        
       
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(GuardarCargaDatosSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarCargaDatosSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarCargaDatosSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarCargaDatosSistemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuardarCargaDatosSistemas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area_datos;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JTextField entrada_archivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
