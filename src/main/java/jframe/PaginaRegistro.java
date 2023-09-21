/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static jframe.DBConnection.con;

/**
 *
 * @author NUCLIUS
 */
public class PaginaRegistro extends javax.swing.JFrame {

    /**
     * Creates new form Registrarse
     */
    public PaginaRegistro() {
        initComponents();
    }
    public void insertarRegistrarseDetalles(){
        String usuario = txtUsuario.getText();
        String clave = txtClave.getText();
        String email = txtEmail.getText();
        String contacto = txtContacto.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO usuario(usuario, clave,email,contacto) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, clave);
            pst.setString(3, email);
            pst.setString(4, contacto);
            
            int updatedRowCount = pst.executeUpdate();
            
            if(updatedRowCount>0){
                JOptionPane.showMessageDialog(this, "Registro insertado satifactiamente");
                PaginaLogin pl = new PaginaLogin();
                pl.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Fallo en la insercion del registro");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean validacionRegistro(){
        String usuario = txtUsuario.getText();
        String clave = txtClave.getText();
        String email = txtEmail.getText();
        String contacto = txtContacto.getText();
        
        if(usuario.equals("")){
            JOptionPane.showMessageDialog(this, "Ingresa un nombre para usuario");
            return false;
        }
        if(clave.equals("")){
            JOptionPane.showMessageDialog(this, "Ingresa una clave valida");
            return false;
        }
        if(email.equals("")|| !email.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "Ingresa un email valido");
            return false;
        }
        if(contacto.equals("")){
            JOptionPane.showMessageDialog(this, "Ingresa un numero de telefono valido");
            return false;
        }
        
        
        return true;
    }
    
    
    public boolean duplicacionesUsuario(){
        String usuario = txtUsuario.getText();
        boolean existe = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nueva_biblioteca","root","");
            
            PreparedStatement pst = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ?");
            pst.setString(1, usuario);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                existe = true;
            }else{
                existe = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;
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
        lblUJGH = new javax.swing.JLabel();
        lblSistema = new javax.swing.JLabel();
        lblBienvenida1 = new javax.swing.JLabel();
        lblBienvenida2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblSalida = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblContacto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(7, 26, 53));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUJGH.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        lblUJGH.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\iMango.png")); // NOI18N
        lblUJGH.setText("UJGH");
        lblUJGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUJGHMouseClicked(evt);
            }
        });
        jPanel1.add(lblUJGH, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, 130, -1));

        lblSistema.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblSistema.setForeground(new java.awt.Color(67, 110, 255));
        lblSistema.setText("Sistema");
        jPanel1.add(lblSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 8, 90, 30));

        lblBienvenida1.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblBienvenida1.setForeground(new java.awt.Color(67, 110, 255));
        lblBienvenida1.setText("Bienvenido a");
        jPanel1.add(lblBienvenida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        lblBienvenida2.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        lblBienvenida2.setText("Mi Biblioteca");
        jPanel1.add(lblBienvenida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\portada.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 690, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 640));

        jPanel2.setBackground(new java.awt.Color(67, 110, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 90, -1));

        lblSalida.setFont(new java.awt.Font("Arial", 2, 25)); // NOI18N
        lblSalida.setForeground(new java.awt.Color(255, 255, 255));
        lblSalida.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\exit.png")); // NOI18N
        lblSalida.setText("X");
        lblSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalidaMouseClicked(evt);
            }
        });
        jPanel2.add(lblSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 30, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(3, 26, 100));
        jLabel8.setText("Crear nueva cuenta");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, -1));

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 230, 20));

        lblUsuario.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(3, 26, 100));
        lblUsuario.setText("Usuario");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 90, -1));

        txtClave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtClave.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel2.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 230, 20));

        lblClave.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblClave.setForeground(new java.awt.Color(3, 26, 100));
        lblClave.setText("Clave");
        jPanel2.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 110, -1));

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 230, 20));

        lblEmail.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(3, 26, 100));
        lblEmail.setText("E-mail");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 90, -1));

        txtContacto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtContacto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        jPanel2.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 230, 20));

        lblContacto.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblContacto.setForeground(new java.awt.Color(3, 26, 100));
        lblContacto.setText("Contacto");
        jPanel2.add(lblContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 90, -1));

        jButton1.setBackground(new java.awt.Color(13, 108, 7));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setBorderPainted(false);
        jButton1.setMaximumSize(new java.awt.Dimension(73, 29));
        jButton1.setMinimumSize(new java.awt.Dimension(73, 29));
        jButton1.setPreferredSize(new java.awt.Dimension(73, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 170, 40));

        jButton2.setBackground(new java.awt.Color(238, 36, 20));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sign up");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.red, java.awt.Color.red, java.awt.Color.white));
        jButton2.setBorderPainted(false);
        jButton2.setMargin(new java.awt.Insets(3, 10, 3, 110));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 170, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(3, 26, 100));
        jLabel7.setText("Registrarse");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\telf.png")); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 380, 40, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\iUsuario.png")); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 170, 40, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\contraicon.png")); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 240, 40, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\email.png")); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 310, 40, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 310, 640));

        setSize(new java.awt.Dimension(997, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(validacionRegistro() == true){
            if(duplicacionesUsuario()== false){
                insertarRegistrarseDetalles();
            }else{
                JOptionPane.showMessageDialog(this,"Ya el usuario existe");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalidaMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblSalidaMouseClicked

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if(duplicacionesUsuario() == true){
            JOptionPane.showMessageDialog(this, "Ya el usuario existe");
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void lblUJGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUJGHMouseClicked
        JOptionPane.showMessageDialog(this, "Este es mi logo, en todos mis proyectos lo coloco, mi nombre es gustavo inciarte");
    }//GEN-LAST:event_lblUJGHMouseClicked

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
            java.util.logging.Logger.getLogger(PaginaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBienvenida1;
    private javax.swing.JLabel lblBienvenida2;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JLabel lblSistema;
    private javax.swing.JLabel lblUJGH;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}