/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.ParseException;


/**
 *
 * @author NUCLIUS
 */
public class Prestamos extends javax.swing.JFrame {

    /**
     * Creates new form Prestamos
     */
    public Prestamos() {
        initComponents();
    }
    public void getDetallesLibros(){
        int idLibro = Integer.parseInt(txtIdLibro.getText());
        try {
            Connection con = DBConnection.getConnection();
            
            PreparedStatement pst = con.prepareStatement("SELECT * FROM det_libros WHERE idLibro = ?");
            pst.setInt(1,idLibro);
            ResultSet rs = pst.executeQuery();
        
            if(rs.next()){
                lblRespuestaIdLibro.setText(rs.getString("idLibro"));
                lblRespuestaTitulo.setText(rs.getString("titulo"));
                lblRespuestaAutor.setText(rs.getString("autor"));
                lblRespuestaCantidad.setText(rs.getString("cantidad"));
                lblErrorLibro.setText("");
                }else{
                    lblErrorLibro.setText("Id para el libro es invalido");
                    lblRespuestaIdLibro.setText("");
                    lblRespuestaTitulo.setText("");
                    lblRespuestaAutor.setText("");
                    lblRespuestaCantidad.setText("");
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    public void getDetallesEstudiantes(){
        int idEstudiante = Integer.parseInt(txtIdEstudiante.getText());
        try {
            Connection con = DBConnection.getConnection();
            
            PreparedStatement pst = con.prepareStatement("SELECT * FROM det_estudiantes WHERE idEstudiante = ?");
            pst.setInt(1,idEstudiante);
            ResultSet rs = pst.executeQuery();
        
            if(rs.next()){
                lblRespuestaIdEstudiante.setText(rs.getString("idEstudiante"));
                lblRespuestaNombre.setText(rs.getString("nombre"));
                lblRespuestaCarrera.setText(rs.getString("carrera"));
                lblErrorEstudiante.setText("");
                }else{
                    lblErrorEstudiante.setText("Id para el estudiante es invalido");
                lblRespuestaIdEstudiante.setText("");
                lblRespuestaNombre.setText("");
                lblRespuestaCarrera.setText("");
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    public boolean prestamoLibros() {
        
        boolean valor = false;
        int idLibro = Integer.parseInt(txtIdLibro.getText());
        int idEstudiante = Integer.parseInt(txtIdEstudiante.getText());
        String titulo = lblRespuestaTitulo.getText();
        String nombre = lblRespuestaNombre.getText();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaSql1 = null;
        java.sql.Date fechaSql2 = null;
        try {
            String fechaPrestamo = txtFechaPrestamo.getText();
            java.util.Date fechaUtil1 = formato.parse(fechaPrestamo);
            fechaSql1 = new java.sql.Date(fechaUtil1.getTime());
            String fechaVencimiento = txtFechaVencimiento.getText();
            java.util.Date fechaUtil2 = formato.parse(fechaVencimiento);
            fechaSql2 = new java.sql.Date(fechaUtil2.getTime());
        } catch (ParseException e) {
        // Manejar la excepción aquí
            e.printStackTrace();
        }

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO prestamos(idLibro, titulo, idEstudiante, nombre, fechaPrestamo, fechaVencimiento, estado)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idLibro);
            pst.setString(2, titulo);
            pst.setInt(3, idEstudiante);
            pst.setString(4, nombre);
            pst.setDate(5, fechaSql1);
            pst.setDate(6, fechaSql2);
            pst.setString(7, "En espera");

            int fila = pst.executeUpdate();
            if (fila > 0) {
                valor = true;
            } else {
                valor = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return valor;
    }
    
    public void actualizarCantidad(){
        String idLibroText = txtIdLibro.getText();
        if (idLibroText.isEmpty()) {
            
        } else {
            int idLibro = Integer.parseInt(idLibroText);
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT cantidad FROM det_libros WHERE idLibro = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, idLibro);
                ResultSet rs = pst.executeQuery();
                if(rs.next()) {
                    JOptionPane.showMessageDialog(this, "Cantidad actualizada");
                    int cantidad = rs.getInt("cantidad");
                    lblRespuestaCantidad.setText(String.valueOf(cantidad));
                }else{
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar la cantidad");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean libroEstaPrestadoYa(){
        boolean valor =false;
        int idLibro = Integer.parseInt(txtIdLibro.getText());
        int idEstudiante = Integer.parseInt(txtIdEstudiante.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM prestamos WHERE idLibro = ? AND idEstudiante = ? AND estado = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idLibro);
            pst.setInt(2, idEstudiante);
            pst.setString(3, "En espera");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                valor = true;
            } else {
                valor = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fastGaussianBlur1 = new efectos.FastGaussianBlur();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblCantidad = new javax.swing.JLabel();
        lblRespuestaIdLibro = new javax.swing.JLabel();
        lblRespuestaCantidad = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lbldLibro = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblRespuestaTitulo = new javax.swing.JLabel();
        lblRespuestaAutor = new javax.swing.JLabel();
        lblErrorLibro = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblRespuestaCarrera = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        lblIdEstudiante = new javax.swing.JLabel();
        lblRespuestaIdEstudiante = new javax.swing.JLabel();
        lblRespuestaNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblErrorEstudiante = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblIdEstudiante1 = new javax.swing.JLabel();
        txtFechaVencimiento = new javax.swing.JTextField();
        lblFechaPrestamo = new javax.swing.JLabel();
        txtIdLibro = new javax.swing.JTextField();
        lblIdLibro2 = new javax.swing.JLabel();
        lblFechaVencimiento = new javax.swing.JLabel();
        txtIdEstudiante = new javax.swing.JTextField();
        txtFechaPrestamo = new javax.swing.JTextField();
        btnPrestar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(67, 110, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\back.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\LibrosPrestamos.png")); // NOI18N
        jLabel3.setText("Libros");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 190, 60));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 240, 5));

        lblCantidad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad:");
        jPanel1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 100, 30));

        lblRespuestaIdLibro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRespuestaIdLibro.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblRespuestaIdLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 150, 30));

        lblRespuestaCantidad.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRespuestaCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblRespuestaCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 150, 30));

        lblAutor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(255, 255, 255));
        lblAutor.setText("Autor:");
        jPanel1.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 60, 30));

        lbldLibro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbldLibro.setForeground(new java.awt.Color(255, 255, 255));
        lbldLibro.setText("Id Libro:");
        jPanel1.add(lbldLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 100, 30));

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Titulo:");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 60, 30));

        lblRespuestaTitulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRespuestaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblRespuestaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 180, 30));

        lblRespuestaAutor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRespuestaAutor.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblRespuestaAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 170, 30));

        lblErrorLibro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblErrorLibro.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lblErrorLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 260, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 660));

        jPanel2.setBackground(new java.awt.Color(214, 39, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 240, 5));

        lblRespuestaCarrera.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRespuestaCarrera.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblRespuestaCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 180, 30));

        lblNombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, 30));

        lblCarrera.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblCarrera.setForeground(new java.awt.Color(255, 255, 255));
        lblCarrera.setText("Carrera:");
        jPanel2.add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 90, 30));

        lblIdEstudiante.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblIdEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        lblIdEstudiante.setText("Id Estudiante:");
        jPanel2.add(lblIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 130, 30));

        lblRespuestaIdEstudiante.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRespuestaIdEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblRespuestaIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 80, 30));

        lblRespuestaNombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRespuestaNombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblRespuestaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 180, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\estudiantePrestamos.png")); // NOI18N
        jLabel5.setText("Estudiantes");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 190, 60));

        lblErrorEstudiante.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblErrorEstudiante.setForeground(new java.awt.Color(255, 255, 0));
        jPanel2.add(lblErrorEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 260, 130));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 330, 660));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\iMango.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(67, 110, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\prestamo.png")); // NOI18N
        jLabel4.setText("Prestamo de Libros");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 280, 60));

        jPanel8.setBackground(new java.awt.Color(214, 39, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 300, 5));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\NUCLIUS\\Desktop\\Programas\\UniJosGreHer\\Programación\\miProyecto\\icono\\exit.png")); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 40, 30));

        lblIdEstudiante1.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblIdEstudiante1.setForeground(new java.awt.Color(67, 110, 255));
        lblIdEstudiante1.setText("Ingresar Id Estudiante");
        jPanel3.add(lblIdEstudiante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 210, -1));

        txtFechaVencimiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFechaVencimiento.setForeground(new java.awt.Color(204, 204, 204));
        txtFechaVencimiento.setText("Formato YYYY-MM-DD");
        txtFechaVencimiento.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 110, 255)));
        jPanel3.add(txtFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 420, 30));

        lblFechaPrestamo.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblFechaPrestamo.setForeground(new java.awt.Color(67, 110, 255));
        lblFechaPrestamo.setText("Ingresar Fecha");
        jPanel3.add(lblFechaPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 150, -1));

        txtIdLibro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdLibro.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 110, 255)));
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
        jPanel3.add(txtIdLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 420, 30));

        lblIdLibro2.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblIdLibro2.setForeground(new java.awt.Color(67, 110, 255));
        lblIdLibro2.setText("Ingresar Id Libro");
        jPanel3.add(lblIdLibro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 210, -1));

        lblFechaVencimiento.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblFechaVencimiento.setForeground(new java.awt.Color(67, 110, 255));
        lblFechaVencimiento.setText("Fecha de Vencimiento");
        jPanel3.add(lblFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 200, -1));

        txtIdEstudiante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdEstudiante.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 110, 255)));
        txtIdEstudiante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdEstudianteFocusLost(evt);
            }
        });
        jPanel3.add(txtIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 420, 30));

        txtFechaPrestamo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtFechaPrestamo.setForeground(new java.awt.Color(204, 204, 204));
        txtFechaPrestamo.setText("Formato YYYY-MM-DD");
        txtFechaPrestamo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(67, 110, 255)));
        txtFechaPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaPrestamoActionPerformed(evt);
            }
        });
        jPanel3.add(txtFechaPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 420, 30));

        btnPrestar.setBackground(new java.awt.Color(67, 110, 255));
        btnPrestar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPrestar.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestar.setText("Prestar");
        btnPrestar.setBorderPainted(false);
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 160, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 520, 660));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 20, 660));

        setSize(new java.awt.Dimension(1200, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txtIdLibroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdLibroFocusLost
        if(!txtIdLibro.getText().equals("")){
            getDetallesLibros();   
        }
    }//GEN-LAST:event_txtIdLibroFocusLost

    private void txtIdLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdLibroActionPerformed
        
    }//GEN-LAST:event_txtIdLibroActionPerformed

    private void txtIdEstudianteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdEstudianteFocusLost
        if(!txtIdEstudiante.getText().equals("")){
            getDetallesEstudiantes();   
        }
    }//GEN-LAST:event_txtIdEstudianteFocusLost

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        
        if(lblRespuestaCantidad.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "El libro no está disponible");
            }else{
            if(libroEstaPrestadoYa()==false){
                if(prestamoLibros()==true){
                    JOptionPane.showMessageDialog(this, "Prestamos satifactorio");
                    actualizarCantidad();
                }else{
                    JOptionPane.showMessageDialog(this, "fallo en el prestamo");
                }
            }else{
                JOptionPane.showMessageDialog(this, "El estudiante ya tiene este libro");
                }
        }
        
        
        
    }//GEN-LAST:event_btnPrestarActionPerformed

    private void txtFechaPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaPrestamoActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrestar;
    private efectos.FastGaussianBlur fastGaussianBlur1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblErrorEstudiante;
    private javax.swing.JLabel lblErrorLibro;
    private javax.swing.JLabel lblFechaPrestamo;
    private javax.swing.JLabel lblFechaVencimiento;
    private javax.swing.JLabel lblIdEstudiante;
    private javax.swing.JLabel lblIdEstudiante1;
    private javax.swing.JLabel lblIdLibro2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRespuestaAutor;
    private javax.swing.JLabel lblRespuestaCantidad;
    private javax.swing.JLabel lblRespuestaCarrera;
    private javax.swing.JLabel lblRespuestaIdEstudiante;
    private javax.swing.JLabel lblRespuestaIdLibro;
    private javax.swing.JLabel lblRespuestaNombre;
    private javax.swing.JLabel lblRespuestaTitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lbldLibro;
    private javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtFechaVencimiento;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtIdLibro;
    // End of variables declaration//GEN-END:variables
}
