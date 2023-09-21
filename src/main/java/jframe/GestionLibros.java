/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jframe.DBConnection.con;

/**
 *
 * @author NUCLIUS
 */
public class GestionLibros extends javax.swing.JFrame {

    /**
     * Creates new form GestionLibros
     */
    String titulo,autor;
    int idLibro,cantidad;
    DefaultTableModel modelo;
    
    public GestionLibros() {
        initComponents();
        setDetLibrosTabla();
    }
    
    public void setDetLibrosTabla(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nueva_biblioteca","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM det_libros");
            
            while(rs.next()){
                String idLibro1 = rs.getString("idLibro");
                String tituloLibro = rs.getString("titulo");
                String autorLibro = rs.getString("autor");
                int cantidadLibro = rs.getInt("cantidad");
                
                Object [] obj = {idLibro1, tituloLibro,autorLibro,cantidadLibro};
                modelo = (DefaultTableModel)tbLibros.getModel();
                
                modelo.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean agregarLibro(){
        idLibro = Integer.parseInt(txtIdLibro.getText());
        titulo = txtTitulo.getText();
        autor = txtAutor.getText();
        cantidad = Integer.parseInt(txtCantidad.getText());
        boolean valor = false;
        try {
            Connection con = DBConnection.getConnection();
            
            String sql = "INSERT INTO det_libros values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,idLibro);
            pst.setString(2, titulo);
            pst.setString(3, autor);
            pst.setInt(4,cantidad);
            
            int fila = pst.executeUpdate();
            
            if(fila > 0){
                valor = true;
            }else{
                valor = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
    }
    
    
    public boolean actualizarLibro(){
        idLibro = Integer.parseInt(txtIdLibro.getText());
        titulo = txtTitulo.getText();
        autor = txtAutor.getText();
        cantidad = Integer.parseInt(txtCantidad.getText());
        boolean valor = false;
        
        try {
            Connection con = DBConnection.getConnection();
            
            String sql = "UPDATE det_libros SET titulo = ?, autor = ?, cantidad = ? WHERE idLibro = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            pst.setString(2, autor);
            pst.setInt(3,cantidad);
            pst.setInt(4, idLibro);
            int fila = pst.executeUpdate();
            
            if(fila > 0){
                valor = true;
            }else{
                valor = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
        
    }
    
    public boolean eliminarLibro(){
        idLibro = Integer.parseInt(txtIdLibro.getText());
        boolean valor = false;
        
        try {
            Connection con = DBConnection.getConnection();
            
            String sql = "DELETE FROM det_libros WHERE idLibro = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idLibro);
            int fila = pst.executeUpdate();
            
            if(fila > 0){
                valor = true;
            }else{
                valor = false;
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return valor;
        
    }
    
    public void limpiarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) tbLibros.getModel();
        modelo.setRowCount(0);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblIdLibro = new javax.swing.JLabel();
        txtIdLibro = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLibros = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(67, 110, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\back.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblIdLibro.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblIdLibro.setForeground(new java.awt.Color(3, 26, 100));
        lblIdLibro.setText("idLibro");
        jPanel1.add(lblIdLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, -1));

        txtIdLibro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdLibro.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txtIdLibro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdLibroFocusLost(evt);
            }
        });
        txtIdLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdLibroActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 320, 30));

        txtTitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txtTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTituloFocusLost(evt);
            }
        });
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 320, 30));

        lblTitulo.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(3, 26, 100));
        lblTitulo.setText("Titulo");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, -1));

        lblAutor.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(3, 26, 100));
        lblAutor.setText("Autor");
        jPanel1.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, -1));

        txtAutor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAutor.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txtAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAutorFocusLost(evt);
            }
        });
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        jPanel1.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 320, 30));

        txtCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 320, 30));

        lblCantidad.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(3, 26, 100));
        lblCantidad.setText("Cantidad");
        jPanel1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, -1));

        btnEliminar.setBackground(new java.awt.Color(59, 80, 186));
        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 320, 40));

        btnAgregar.setBackground(new java.awt.Color(49, 67, 156));
        btnAgregar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 320, 40));

        btnActualizar.setBackground(new java.awt.Color(69, 93, 213));
        btnActualizar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorderPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 320, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 700));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\iconoSinFondoMango.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\exit.png")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 30, 40));

        tbLibros.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(67, 110, 255)));
        tbLibros.setForeground(new java.awt.Color(3, 26, 100));
        tbLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idLibro", "Titulo", "Autor", "Cantidad"
            }
        ));
        tbLibros.setGridColor(new java.awt.Color(69, 93, 213));
        tbLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLibros);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 740, 500));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\library.png")); // NOI18N
        jLabel4.setText("Gestion de Libros");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jPanel4.setBackground(new java.awt.Color(49, 67, 156));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 350, 3));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 830, 700));

        setSize(new java.awt.Dimension(1200, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtIdLibroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdLibroFocusLost
   //     if(duplicacionesUsuario() == true){
     //       JOptionPane.showMessageDialog(this, "Ya el usuario existe");
        //}
    }//GEN-LAST:event_txtIdLibroFocusLost

    private void txtIdLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdLibroActionPerformed

    private void txtTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloFocusLost

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtAutorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAutorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorFocusLost

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(actualizarLibro()==true){
            JOptionPane.showMessageDialog(this,"Libro actualizado");
            limpiarTabla();
            setDetLibrosTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Hubo un fallo al actualizar el libro");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(eliminarLibro()==true){
            JOptionPane.showMessageDialog(this,"Libro eliminado");
            limpiarTabla();
            setDetLibrosTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Hubo un fallo al tratar de eliminar el libro");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tbLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLibrosMouseClicked
        int NoFila = tbLibros.getSelectedRow();
        TableModel modelo = tbLibros.getModel();
        txtIdLibro.setText(modelo.getValueAt(NoFila,0).toString());
        txtTitulo.setText(modelo.getValueAt(NoFila,1).toString());
        txtAutor.setText(modelo.getValueAt(NoFila,2).toString());
        txtCantidad.setText(modelo.getValueAt(NoFila,3).toString());
    }//GEN-LAST:event_tbLibrosMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
       
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(agregarLibro()==true){
            JOptionPane.showMessageDialog(this,"Libro agregado");
            limpiarTabla();
            setDetLibrosTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Hubo un fallo al agregar el libro");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        JOptionPane.showMessageDialog(this, "Este es mi logo, en todos mis proyectos lo coloco, mi nombre es gustavo inciarte");
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(GestionLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblIdLibro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdLibro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
