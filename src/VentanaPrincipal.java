import javax.swing.JOptionPane;

/**
 * Ventana principal de la aplicación
 * Desde aquí el usuario podrá:
 * - Crear el XML de películas
 * - Leer el XML generado y visualizar los tráilers
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    
    public VentanaPrincipal() {
        initComponents();
            
        setLocationRelativeTo(null);    // Se centra la ventana en la pantalla
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCrearXML = new javax.swing.JMenuItem();
        menuLeerXML = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Películas - Erik");
        setBackground(new java.awt.Color(245, 245, 250));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(52, 152, 219));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTOR DE PELÍCULAS");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 600, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Desarrollado por Erik Vidal");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 600, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 150, 150));

        jMenu1.setText("Funcionalidades");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuCrearXML.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        menuCrearXML.setText("Crear XML de Películas");
        menuCrearXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearXMLActionPerformed(evt);
            }
        });
        jMenu1.add(menuCrearXML);

        menuLeerXML.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        menuLeerXML.setText("Leer XML y Mostrar Tráiler");
        menuLeerXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLeerXMLActionPerformed(evt);
            }
        });
        jMenu1.add(menuLeerXML);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void menuCrearXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearXMLActionPerformed
        // Abre la ventana donde se introducen las películas
        VentanaCrearXML v = new VentanaCrearXML();
        v.setVisible(true);
    }//GEN-LAST:event_menuCrearXMLActionPerformed

    private void menuLeerXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLeerXMLActionPerformed
        // Antes de abrir la ventana comprueba si existe el archivo peliculas.xml
        java.io.File archivo = new java.io.File("peliculas.xml");

        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(this, """
                                                El archivo peliculas.xml no existe 
                                                Debes de generarlo primero""");
            return;
        }

        // Si existe se abre la ventana de lectura
        VentanaLeerXML v = new VentanaLeerXML();
        v.setVisible(true);
    }//GEN-LAST:event_menuLeerXMLActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCrearXML;
    private javax.swing.JMenuItem menuLeerXML;
    // End of variables declaration//GEN-END:variables
}