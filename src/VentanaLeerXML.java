import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;


/**
 * Ventana encargada de:
 * - Leer el archivo peliculas.xml
 * - Mostrar las películas en una lista
 * - Permitir abrir el tráiler en el navegador
 */
public class VentanaLeerXML extends javax.swing.JFrame {
    
    
    // Lista auxiliar donde se almacenan las URLs de los tráilers
    private final java.util.List<String> urls = new java.util.ArrayList<>();
  
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLeerXML.class.getName());


    public VentanaLeerXML() {
        initComponents();
        
        setLocationRelativeTo(null);    // Centrado de ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerTrailer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPeliculas = new javax.swing.JList<>();
        btnCargar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(236, 240, 241));
        setPreferredSize(new java.awt.Dimension(500, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVerTrailer.setBackground(new java.awt.Color(255, 87, 34));
        btnVerTrailer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVerTrailer.setForeground(java.awt.Color.white);
        btnVerTrailer.setText("VER TRÁILER");
        btnVerTrailer.setEnabled(false);
        btnVerTrailer.setFocusPainted(false);
        btnVerTrailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTrailerActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerTrailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 405, 45));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));

        listaPeliculas.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Selecciona la película", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        listaPeliculas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        listaPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaPeliculas.setPreferredSize(new java.awt.Dimension(220, 380));
        listaPeliculas.setSelectionBackground(new java.awt.Color(160, 186, 211));
        listaPeliculas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPeliculasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPeliculas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 75, 405, 200));

        btnCargar.setBackground(new java.awt.Color(33, 150, 243));
        btnCargar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCargar.setForeground(java.awt.Color.white);
        btnCargar.setText("CARGAR PELÍCULAS");
        btnCargar.setFocusPainted(false);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 405, 40));

        jScrollPane2.setEnabled(false);

        txtDetalles.setBackground(new java.awt.Color(255, 255, 255));
        txtDetalles.setColumns(20);
        txtDetalles.setRows(5);
        txtDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Detalles y Sinopsis", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        txtDetalles.setDisabledTextColor(java.awt.Color.black);
        txtDetalles.setEnabled(false);
        jScrollPane2.setViewportView(txtDetalles);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 405, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        try {
            java.io.File archivo = new java.io.File("peliculas.xml");
            
            // Se carga y parsea el archivo XML usando DOM
            javax.xml.parsers.DocumentBuilderFactory factory =
            javax.xml.parsers.DocumentBuilderFactory.newInstance();

            javax.xml.parsers.DocumentBuilder builder =
            factory.newDocumentBuilder();

            org.w3c.dom.Document doc = builder.parse(archivo);
            doc.getDocumentElement().normalize();

            org.w3c.dom.NodeList lista =
            doc.getElementsByTagName("pelicula");

            // Modelo para la JList visual
            javax.swing.DefaultListModel<String> modelo =
            new javax.swing.DefaultListModel<>();

            urls.clear();   // Limpia la lista de URLs vieja por si recargan

            
            // Recorre y extrae datos
            for (int i = 0; i < lista.getLength(); i++) {

                org.w3c.dom.Element e =
                (org.w3c.dom.Element) lista.item(i);

                // Extrae datos de los hijos
                String titulo = e.getElementsByTagName("titulo").item(0).getTextContent();
                String duracion = e.getElementsByTagName("duracion").item(0).getTextContent();
                String trailer = e.getElementsByTagName("trailer").item(0).getTextContent();

                modelo.addElement(titulo + " (" + duracion + " min)");

                urls.add(trailer);
            }
            
            // Asigna el modelo a la lista
            listaPeliculas.setModel(modelo);
            javax.swing.JOptionPane.showMessageDialog(this, "Películas perfectamente cargadas");
            
            
        } catch (HeadlessException | IOException | ParserConfigurationException | DOMException | SAXException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer el XML");
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void listaPeliculasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPeliculasValueChanged
        /* Cuando el usuario elige una película,
        se activa el botón para poder abrir el tráiler */
        int indice = listaPeliculas.getSelectedIndex();

        
        if (indice != -1) {
            btnVerTrailer.setEnabled(true);
            // Detalles de la película en el TextArea
            String datosVisuales = listaPeliculas.getSelectedValue();
            String url = urls.get(indice);
            String informacionCompleta = """
                                         FICHA TÉCNICA:
                                         --------------------------------------------
                                         """ +
                                     datosVisuales + "\n\n" +
                                     "URL DEL TRÁILER:\n" + 
                                     url;
            // Estampamos en el área de texto
            txtDetalles.setText(informacionCompleta);
            
        } else {
            btnVerTrailer.setEnabled(false);
            txtDetalles.setText(""); // Limpiamos el texto
        }
    }//GEN-LAST:event_listaPeliculasValueChanged

    private void btnVerTrailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTrailerActionPerformed
        try {
            int indice = listaPeliculas.getSelectedIndex();

            if (indice != -1) {
                String url = urls.get(indice);

                java.awt.Desktop.getDesktop().browse(
                        new java.net.URI(url));
            }

        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo abrir el tráiler");
        }
    }//GEN-LAST:event_btnVerTrailerActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaLeerXML().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnVerTrailer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaPeliculas;
    private javax.swing.JTextArea txtDetalles;
    // End of variables declaration//GEN-END:variables
}
