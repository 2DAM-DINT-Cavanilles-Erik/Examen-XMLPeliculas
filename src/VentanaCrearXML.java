import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.DOMException;

/**
 * Ventana encargada de:
 * - Recoger las películas introducidas por el usuario
 * - Validar los datos
 * - Generar el archivo peliculas.xml utilizando DOM
 */
public class VentanaCrearXML extends javax.swing.JFrame {
    

    /* 
    Listas para almacenar las películas por género
    Se usan tres listas separadas para controlar fácilmente
    el máximo de 3 películas por cada género 
    */
    private java.util.List<String> misterio = new java.util.ArrayList<>();
    private java.util.List<String> aventura = new java.util.ArrayList<>();
    private java.util.List<String> comedia = new java.util.ArrayList<>();
   
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrearXML.class.getName());
  
    
    public VentanaCrearXML() {
        initComponents();
        
        setLocationRelativeTo(null);    // Se centra la ventana en la pantalla
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTrailer = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLista = new javax.swing.JTextArea();
        btnGenerar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creación de XML");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 650));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(44, 62, 80));
        jLabel1.setText("Género");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 200, -1));

        comboGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Misterio", "Aventura", "Comedia" }));
        comboGenero.setPreferredSize(new java.awt.Dimension(30, 30));
        getContentPane().add(comboGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 115, 200, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 62, 80));
        jLabel2.setText("Título");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 200, -1));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitulo.setPreferredSize(new java.awt.Dimension(30, 40));
        getContentPane().add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 185, 420, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 62, 80));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Duración(minutos)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 120, 20));

        txtDuracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDuracion.setPreferredSize(new java.awt.Dimension(30, 40));
        getContentPane().add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 255, 120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(44, 62, 80));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("URL del Tráiler");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, 20));

        txtTrailer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTrailer.setPreferredSize(new java.awt.Dimension(30, 40));
        getContentPane().add(txtTrailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 255, 280, 30));

        btnAgregar.setBackground(new java.awt.Color(30, 153, 82));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setForeground(java.awt.Color.white);
        btnAgregar.setText("AGREGAR PELÍCULA");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 420, 40));

        txtLista.setBackground(new java.awt.Color(255, 255, 255));
        txtLista.setColumns(20);
        txtLista.setRows(5);
        txtLista.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLista.setEnabled(false);
        txtLista.setPreferredSize(new java.awt.Dimension(420, 180));
        jScrollPane1.setViewportView(txtLista);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 420, 150));

        btnGenerar.setBackground(new java.awt.Color(44, 138, 202));
        btnGenerar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerar.setForeground(java.awt.Color.white);
        btnGenerar.setText("GENERAR XML");
        btnGenerar.setEnabled(false);
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 420, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 62, 80));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Crear XML de Películas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 50));

        jSeparator1.setForeground(new java.awt.Color(44, 62, 80));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 420, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Recogida de datos del formulario
        String genero = comboGenero.getSelectedItem().toString();
        String titulo = txtTitulo.getText().trim();
        String duracionTexto = txtDuracion.getText().trim();
        String url = txtTrailer.getText().trim();

        // Validación: el título es obligatorio
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El título no puede estar vacío");
            return;
        }

        
        // Validación: debe ser un entero positivo
        int duracion;
        try {
            duracion = Integer.parseInt(duracionTexto);
            if (duracion <= 0) {
                JOptionPane.showMessageDialog(this, "La duración debe ser un número positivo");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La duración debe ser un número entero válido");
            return;
        }

        // Validación de la URL del tráiler
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            JOptionPane.showMessageDialog(this, "La URL debe de empezar por http:// o https://");
            return;
        }

        
        // Se selecciona la lista correspondiente al género elegido
        java.util.List<String> listaSeleccionada = null;

        switch (genero) {
            case "Misterio" -> listaSeleccionada = misterio;
            case "Aventura" -> listaSeleccionada = aventura;
            case "Comedia" -> listaSeleccionada = comedia;
            default -> {
            }
        }

        // Control de límite: máximo 3 películas por género
        if (listaSeleccionada.size() >= 3) {
            JOptionPane.showMessageDialog(this, "Ya existen 3 películas para el género " + genero);
            return;
        }

        
        // Se guardan los datos en textos separados por |
        String pelicula = titulo + "|" + duracion + "|" + url;
        listaSeleccionada.add(pelicula);

        // Se muestra la información en el área de texto
        txtLista.append("Género: " + genero + "\n");
        txtLista.append("Título: " + titulo + "\n");
        txtLista.append("Duración: " + duracion + " minutos\n");
        txtLista.append("URL: " + url + "\n");
        txtLista.append("-----------------------------\n");

        // Limpieza de campos para la siguiente entrada
        txtTitulo.setText("");
        txtDuracion.setText("");
        txtTrailer.setText("");

        // El botón Generar XML, que solo se activa cuando hay 3 películas por género
        if (misterio.size() == 3 && aventura.size() == 3 && comedia.size() == 3) {
            btnGenerar.setEnabled(true);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        /* Este método genera el archivo peliculas.xml usando la API DOM.
        Primero se construye el documento en memoria y después se guarda
        en la raíz del proyecto a través de un Transformer */


        // Comprobación de seguridad antes de generar el XML
        if (misterio.size() != 3 || aventura.size() != 3 || comedia.size() != 3) {
            JOptionPane.showMessageDialog(this, "Tiene que haber exactamente 3 películas por cada género");
            return;
        }
        
        try {
            // Se crea el documento XML en memoria usando DOM
            javax.xml.parsers.DocumentBuilderFactory factory =
            javax.xml.parsers.DocumentBuilderFactory.newInstance();

            javax.xml.parsers.DocumentBuilder builder =
            factory.newDocumentBuilder();

            org.w3c.dom.Document doc = builder.newDocument();
            
            // Nodo raíz <peliculas>
            org.w3c.dom.Element raiz = doc.createElement("peliculas");
            doc.appendChild(raiz);
            
            
            // PROCESO GÉNERO MISTERIO
            org.w3c.dom.Element nodoMisterio = doc.createElement("misterio");
            raiz.appendChild(nodoMisterio);
            
            for (String p : misterio) {
                String[] partes = p.split("\\|");

                org.w3c.dom.Element pelicula = doc.createElement("pelicula");

                org.w3c.dom.Element titulo = doc.createElement("titulo");
                titulo.setTextContent(partes[0]);

                org.w3c.dom.Element duracion = doc.createElement("duracion");
                duracion.setTextContent(partes[1]);

                org.w3c.dom.Element trailer = doc.createElement("trailer");
                trailer.setTextContent(partes[2]);

                pelicula.appendChild(titulo);
                pelicula.appendChild(duracion);
                pelicula.appendChild(trailer);

                nodoMisterio.appendChild(pelicula);
            }
            
            // PROCESO GÉNERO AVENTURA
            org.w3c.dom.Element nodoAventura = doc.createElement("aventura");
            raiz.appendChild(nodoAventura);

            for (String p : aventura) {
                String[] partes = p.split("\\|");

                org.w3c.dom.Element pelicula = doc.createElement("pelicula");

                org.w3c.dom.Element titulo = doc.createElement("titulo");
                titulo.setTextContent(partes[0]);

                org.w3c.dom.Element duracion = doc.createElement("duracion");
                duracion.setTextContent(partes[1]);

                org.w3c.dom.Element trailer = doc.createElement("trailer");
                trailer.setTextContent(partes[2]);

                pelicula.appendChild(titulo);
                pelicula.appendChild(duracion);
                pelicula.appendChild(trailer);

                nodoAventura.appendChild(pelicula);
            }

            
            // PROCESO GÉNERO AVENTURA
            org.w3c.dom.Element nodoComedia = doc.createElement("comedia");
            raiz.appendChild(nodoComedia);

            for (String p : comedia) {
                String[] partes = p.split("\\|");

                org.w3c.dom.Element pelicula = doc.createElement("pelicula");

                org.w3c.dom.Element titulo = doc.createElement("titulo");
                titulo.setTextContent(partes[0]);

                org.w3c.dom.Element duracion = doc.createElement("duracion");
                duracion.setTextContent(partes[1]);

                org.w3c.dom.Element trailer = doc.createElement("trailer");
                trailer.setTextContent(partes[2]);

                pelicula.appendChild(titulo);
                pelicula.appendChild(duracion);
                pelicula.appendChild(trailer);

                nodoComedia.appendChild(pelicula);
            }
            
            
            // Ahora se transforma el documento en un archivo XML real
            javax.xml.transform.TransformerFactory tf =
            javax.xml.transform.TransformerFactory.newInstance();
            // Esto hace que el XML salga con indentación bonita (saltos de línea)
            javax.xml.transform.Transformer transformer = tf.newTransformer();

            javax.xml.transform.dom.DOMSource origen =
                new javax.xml.transform.dom.DOMSource(doc);
            java.io.File archivo = new java.io.File("peliculas.xml");

            javax.xml.transform.stream.StreamResult destino =
                new javax.xml.transform.stream.StreamResult(archivo);

            transformer.transform(origen, destino);

            JOptionPane.showMessageDialog(this, "Se ha generado el archivo peliculas.xml");

            
        } catch (HeadlessException | ParserConfigurationException | TransformerException | DOMException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el XML");
    }

    }//GEN-LAST:event_btnGenerarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new VentanaCrearXML().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextArea txtLista;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTrailer;
    // End of variables declaration//GEN-END:variables
}
