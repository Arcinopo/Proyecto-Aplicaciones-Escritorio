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
public class PaginaLogin extends javax.swing.JFrame {

    /**
     * Creates new form Registrarse
     */
    public PaginaLogin() {
        initComponents();
    }
    
    public boolean validacionLogin(){
        String usuario = txtUsuario.getText();
        String clave = txtClave.getText();
        
        if(usuario.equals("")){
            JOptionPane.showMessageDialog(this, "Ingresa un usuario");
            return false;      
        }
        if(clave.equals("")){
            JOptionPane.showMessageDialog(this, "Ingresa una clave");
            return false;      
        }
        return true;
    }
    
    public void login(){
        String usuario = txtUsuario.getText();
        String clave = txtClave.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nueva_biblioteca","root","");
            
            PreparedStatement pst = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ? AND clave = ?");
            pst.setString(1, usuario);
            pst.setString(2, clave);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Bienvenido " + usuario);
                Home hm = new Home();
                hm.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Fallo en la conexion: Usuario o clave invalida");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUJGH = new javax.swing.JLabel();
        lblSistema = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblSalida = new javax.swing.JLabel();
        lblIngresaCuenta = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
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
        jPanel1.add(lblUJGH, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, 110, -1));

        lblSistema.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblSistema.setForeground(new java.awt.Color(11, 24, 215));
        lblSistema.setText("Sistema");
        jPanel1.add(lblSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 8, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\portadaBiblioteca1000libros.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 690, 600));

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

        lblIngresaCuenta.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        lblIngresaCuenta.setForeground(new java.awt.Color(3, 26, 100));
        lblIngresaCuenta.setText("Ingresa  a tu cuenta");
        jPanel2.add(lblIngresaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 170, -1));

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
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 230, 30));

        lblUsuario.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblUsuario.setText("Usuario");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 90, -1));

        txtClave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtClave.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel2.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 230, 30));

        lblClave.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblClave.setText("Clave");
        jPanel2.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, -1));

        jButton1.setBackground(new java.awt.Color(0, 14, 182));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.black, java.awt.Color.gray));
        jButton1.setBorderPainted(false);
        jButton1.setMaximumSize(new java.awt.Dimension(73, 29));
        jButton1.setMinimumSize(new java.awt.Dimension(73, 29));
        jButton1.setPreferredSize(new java.awt.Dimension(73, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 230, 40));

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
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 230, 40));

        lblLogin.setFont(new java.awt.Font("Candara", 3, 36)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(3, 26, 100));
        lblLogin.setText("LOGIN");
        jPanel2.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\contraicon.png")); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 305, 40, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\iUsuario.png")); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 225, 40, 50));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(validacionLogin()){
            login();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalidaMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblSalidaMouseClicked

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
    
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
            java.util.logging.Logger.getLogger(PaginaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaLogin().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblIngresaCuenta;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JLabel lblSistema;
    private javax.swing.JLabel lblUJGH;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
