/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Negocio.SopaBinaria;
import Vista.LeerMatriz_Excel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 *
 * @author madar
 */
public class GuiBinaria extends javax.swing.JFrame {
 
     private String matrizExcel[][];
     
     private SopaBinaria miExcel;
     private inicio i;
    /**
     * Creates new form GuiBinaria
     */
    public GuiBinaria() {
        initComponents();
        inicio i = new inicio();
        getContentPane().setBackground(Color.white);
        this.txtImprimir.setEditable(false);
        jButton2.setIcon(setIcono("/Imagen/1.png", jButton2));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        jButton2.setSelectedIcon(seticonSelec("/Imagen/3.png", jButton2, 5, 5));
        jButton2.setPressedIcon(setIconoPress("/Imagen/3.png", jButton2, 7, 7));
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagen/6.png")).getImage());
        i.cambiarTitulo("Arial Black",jLabel1,30);
        cambiarTituloarea("Arial Black", txtImprimir, 12);
        cambiarTitulotext("Arial Black", jTextField1, 12);
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
        btnCargar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNumero = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtImprimir = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));

        btnCargar.setText("Cargar Excel Con la Sopa ");
        btnCargar.setBorderPainted(false);
        btnCargar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir Resultado en PDF");
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Limpiar.setText("Limpiar");
        Limpiar.setBorderPainted(false);
        Limpiar.setEnabled(false);
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        jButton2.setBorderPainted(false);
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCargar)
                        .addComponent(jButton1)
                        .addComponent(Limpiar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        btnNumero.setText("Buscar un número decimal");
        btnNumero.setBorderPainted(false);
        btnNumero.setEnabled(false);
        btnNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumeroActionPerformed(evt);
            }
        });

        txtImprimir.setColumns(20);
        txtImprimir.setRows(5);
        txtImprimir.setEnabled(false);
        jScrollPane1.setViewportView(txtImprimir);

        jTextField1.setForeground(new java.awt.Color(103, 102, 255));
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("SOPA BINARIA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
       
        
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        JFileChooser archivo = new JFileChooser(".");
        archivo.showOpenDialog(this);
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos excel", "xls");
        archivo.setFileFilter(filtro);
        File fileName = archivo.getSelectedFile();
        if(fileName !=null){
         try {
           Cargado();
           miExcel=new SopaBinaria(fileName.getAbsolutePath(),0);
           //this.jTextField1.setText(fileName.getAbsolutePath());
           this.txtImprimir.setText(miExcel.toString());
           this.matrizExcel=miExcel.getMatrizEnString();
          
           this.jTextField1.setEnabled(true);
           this.txtImprimir.setEnabled(true);
           
           this.btnNumero.setEnabled(true);
           
        } catch (IOException ex) {
                this.txtImprimir.setText("Ocurrió un error al cargar el archivo:"+ex.getMessage());
            }
         catch(Exception ex2){
             this.txtImprimir.setText("Ocurrió un error al cargar el archivo:"+ex2.getMessage());
         }
        }else
          
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún archivo.", "¡ERROR!", JOptionPane.ERROR_MESSAGE );
    }//GEN-LAST:event_btnCargarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.jButton2.setEnabled(true);
        
        
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumeroActionPerformed
        // TODO add your handling code here:
       if("".equals(jTextField1.getText())){
            JOptionPane.showMessageDialog(null, "No se ha digitado ningun valor.", "¡ATENCION!", JOptionPane.WARNING_MESSAGE );
         }else{
             try {
             int decimal=Integer.parseInt(jTextField1.getText());
             txtImprimir.setText(this.miExcel.buscar(decimal));
             this.Limpiar.setEnabled(true);
             this.jButton1.setEnabled(true);
             this.btnCargar.setEnabled(false);
         } catch (IOException ex) {
             Logger.getLogger(GuiBinaria.class.getName()).log(Level.SEVERE, null, ex);
       
       } 
       }     
    }//GEN-LAST:event_btnNumeroActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // TODO add your handling code here:
        
        this.txtImprimir.setText("");
        this.jTextField1.setText("");
        this.jButton1.setEnabled(false);
        this.btnCargar.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.Limpiar.setEnabled(false);
    }//GEN-LAST:event_LimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.btnCargar.setEnabled(true);
        this.txtImprimir.setText("");
        this.jTextField1.setText("");
        this.jButton1.setEnabled(false);
        this.Limpiar.setEnabled(false);
        this.btnNumero.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.jTextField1.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

 
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
            java.util.logging.Logger.getLogger(GuiBinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiBinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiBinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiBinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            
            }
        });
    }
    
    public Icon setIcono(String url,JButton boton ){
    
    ImageIcon icon = new ImageIcon(getClass().getResource(url));
    int ancho = boton.getWidth();
    int alto = boton.getHeight();
    
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho,alto,Image.SCALE_DEFAULT ));
        return icono;
    }
    
    public Icon seticonSelec(String url,JButton boton, int ancho, int altura){
      
    ImageIcon icon = new ImageIcon(getClass().getResource(url));
    int width = boton.getWidth() + ancho;
    int heigth = boton.getWidth() + altura;
    
    ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, heigth,Image.SCALE_DEFAULT));

    return icono;
    }
    
     public Icon setIconoPress(String url,JButton boton, int ancho, int altura){
      
    ImageIcon icon = new ImageIcon(getClass().getResource(url));
    int width = boton.getWidth() - ancho;
    int heigth = boton.getWidth() - altura;
    
    ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, heigth,Image.SCALE_DEFAULT));

    return icono;
    }
    
    public JTextArea cambiarTituloarea(String d,JTextArea area ,int p ){
          
        Font fuente = new Font(d, 1, p);
        area.setFont(fuente); 
        
        
        return area;
        
       }
     
    public JTextField cambiarTitulotext(String d,JTextField txt ,int p ){
          
        Font fuente = new Font(d, 1, p);
        txt.setFont(fuente); 
        
          
        return txt;
        
       }
          
        
    public Icon Cargado(){
    
    ImageIcon icon = new ImageIcon(getClass().getResource("/Imagen/8.png"));
       
       
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(180,130,Image.SCALE_DEFAULT ));
        JOptionPane.showMessageDialog(null,"El archivo se cargo correctamente.","CARGADO",JOptionPane.INFORMATION_MESSAGE,icono);
        return icono;    

    }  
   
 
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnNumero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtImprimir;
    // End of variables declaration//GEN-END:variables

   

  
}
