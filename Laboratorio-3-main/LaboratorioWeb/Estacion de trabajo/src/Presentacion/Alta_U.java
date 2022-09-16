package Presentacion;

import Logica.ISistema;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Alta_U extends javax.swing.JFrame {

    ISistema sis;
    int longitudBytes;
    FileInputStream fis;
    File img;

    public Alta_U(ISistema sistema) {
        initComponents();
        setLocationRelativeTo(null);
        altaA.setVisible(false);
        altaesp.setVisible(false);
        sis = sistema;     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        artist = new javax.swing.JRadioButton();
        esp = new javax.swing.JRadioButton();
        altaA = new javax.swing.JInternalFrame();
        aceptarartista = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nickA = new javax.swing.JTextField();
        nameA = new javax.swing.JTextField();
        apellidoA = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        birthA = new com.toedter.calendar.JDateChooser();
        emailA = new javax.swing.JTextField();
        website = new javax.swing.JTextField();
        bio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addimg = new javax.swing.JButton();
        website1 = new javax.swing.JTextField();
        altaesp = new javax.swing.JInternalFrame();
        aceptarespectador = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nickE = new javax.swing.JTextField();
        nameE = new javax.swing.JTextField();
        apellidoE = new javax.swing.JTextField();
        birthE = new com.toedter.calendar.JDateChooser();
        emailE = new javax.swing.JTextField();
        addimagen = new javax.swing.JButton();
        website2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel1.setText("Seleccione una opción");
        jLabel1.setToolTipText("");

        artist.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        artist.setText("Artista");
        artist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistActionPerformed(evt);
            }
        });

        esp.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        esp.setText("Espectador");
        esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espActionPerformed(evt);
            }
        });

        altaA.setTitle("Alta de Artista");
        altaA.setVisible(true);

        aceptarartista.setText("Aceptar");
        aceptarartista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarartistaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nickname:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Email:");

        jLabel6.setText("Fecha de nacimiento:");

        apellidoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoAActionPerformed(evt);
            }
        });

        jLabel7.setText("Descripción:");

        jLabel8.setText("Biografía:");

        jLabel9.setText("Sitio web:");

        addimg.setText("Agregar Imagen");
        addimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addimgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout altaALayout = new javax.swing.GroupLayout(altaA.getContentPane());
        altaA.getContentPane().setLayout(altaALayout);
        altaALayout.setHorizontalGroup(
            altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaALayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptarartista)
                .addGap(157, 157, 157))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addimg, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(nickA)
                    .addComponent(nameA)
                    .addComponent(apellidoA)
                    .addComponent(descripcion)
                    .addComponent(birthA, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(emailA)
                    .addComponent(website)
                    .addComponent(bio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(website1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(76, 76, 76))
        );
        altaALayout.setVerticalGroup(
            altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaALayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(altaALayout.createSequentialGroup()
                        .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nickA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nameA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(apellidoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(emailA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(birthA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(altaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(website, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(website1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(addimg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptarartista)
                .addContainerGap())
        );

        altaesp.setTitle("Alta de Espectador");
        altaesp.setToolTipText("");
        altaesp.setVisible(true);

        aceptarespectador.setText("Aceptar");
        aceptarespectador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarespectadorActionPerformed(evt);
            }
        });

        jLabel18.setText("Nickname:");

        jLabel19.setText("Nombre:");

        jLabel20.setText("Apellido:");

        jLabel21.setText("Email:");

        jLabel22.setText("Fecha de nacimiento:");

        nameE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameEActionPerformed(evt);
            }
        });

        addimagen.setText("Agregar Imagen");
        addimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addimagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout altaespLayout = new javax.swing.GroupLayout(altaesp.getContentPane());
        altaesp.getContentPane().setLayout(altaespLayout);
        altaespLayout.setHorizontalGroup(
            altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaespLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nickE)
                    .addComponent(nameE)
                    .addComponent(apellidoE)
                    .addComponent(birthE, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(emailE)
                    .addComponent(website2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(76, 76, 76))
            .addGroup(altaespLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(aceptarespectador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        altaespLayout.setVerticalGroup(
            altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaespLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(nickE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(nameE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(apellidoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(emailE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(altaespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(birthE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(website2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(addimagen)
                .addGap(18, 18, 18)
                .addComponent(aceptarespectador)
                .addContainerGap())
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(altaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(altaesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(291, 291, 291))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(artist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(esp)
                .addGap(387, 387, 387))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(esp)
                    .addComponent(artist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altaesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void artistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistActionPerformed
        // TODO add your handling code here:
        if (artist.isSelected()) {
            esp.setSelected(false);
        }
        altaA.setVisible(true);
        altaesp.setVisible(false);
    }//GEN-LAST:event_artistActionPerformed

    private void espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espActionPerformed
        // TODO add your handling code here:
        if (esp.isSelected()) {
            artist.setSelected(false);
        }
        altaA.setVisible(false);
        altaesp.setVisible(true);

    }//GEN-LAST:event_espActionPerformed

    private void aceptarartistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarartistaActionPerformed
        // TODO add your handling code here:
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String nick = nickA.getText();
        String name = nameA.getText();
        String apellido = apellidoA.getText();
        String biografia = bio.getText();
        Date cumple = (Date) birthA.getDate();
        String correo = emailA.getText();
        String link = website.getText();
        String desc = descripcion.getText();   
        String cont = website1.getText();
        
        String cumpleanios = simpleDateFormat.format(cumple);
        
        if ((nick.equals("")) || (name.equals("")) || (apellido.equals("")) || (biografia.equals("")) || (correo.equals("")) || (link.equals("")) || (desc.equals("")) || (cumple == null)) {
            JOptionPane.showMessageDialog(null, "No pueden quedar campos sin completar", "Error...", JOptionPane.ERROR_MESSAGE);
        } else {
//            sis.confirmarUsuario(nick, name, apellido, correo, cumpleanios,cont, img, desc, biografia, link);
            JOptionPane.showMessageDialog(null, "Creada correctamente!!", "El artista fue creado exitosamente", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }

    }//GEN-LAST:event_aceptarartistaActionPerformed

    private void apellidoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoAActionPerformed

    private void aceptarespectadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarespectadorActionPerformed
        // TODO add your handling code here:
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        String nick = nickE.getText();
        String name = nameE.getText();
        String apellido = apellidoE.getText();
        java.util.Date cumple = birthE.getDate();
        String correo = emailE.getText();  
        String desc = "";
        String cont = website2.getText();
        String cumpleanios = simpleDateFormat.format(cumple);
        if ((nick.equals("")) || (name.equals("")) || (apellido.equals("")) || (correo.equals("")) || (cumple == null)) {
            JOptionPane.showMessageDialog(null, "No pueden quedar campos sin completar", "Error...", JOptionPane.ERROR_MESSAGE);
        } else {

//            sis.confirmarUsuario(nick, name, apellido, correo, cumpleanios,cont, img, "", null, null);
            JOptionPane.showMessageDialog(null, "Creada correctamente!!", "El espectador fue creado exitosamente", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_aceptarespectadorActionPerformed

    private void nameEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addimagenActionPerformed
//        jLabel1.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                img = j.getSelectedFile();
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
//                try {
//                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT);
////                    jLabel1.setIcon(new ImageIcon(icono));
//                    jLabel1.updateUI();
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
//                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_addimagenActionPerformed

    private void addimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addimgActionPerformed
        //        jLabel1.setIcon(null);
        JFileChooser j1 = new JFileChooser();
        j1.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j1.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j1.getSelectedFile());
                img = j1.getSelectedFile();
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j1.getSelectedFile().length();
//                try {
//                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT);
////                    jLabel1.setIcon(new ImageIcon(icono));
//                    jLabel1.updateUI();
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
//                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_addimgActionPerformed

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
            java.util.logging.Logger.getLogger(Alta_U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_U.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Alta_U().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarartista;
    private javax.swing.JButton aceptarespectador;
    private javax.swing.JButton addimagen;
    private javax.swing.JButton addimg;
    private javax.swing.JInternalFrame altaA;
    private javax.swing.JInternalFrame altaesp;
    private javax.swing.JTextField apellidoA;
    private javax.swing.JTextField apellidoE;
    private javax.swing.JRadioButton artist;
    private javax.swing.JTextField bio;
    private com.toedter.calendar.JDateChooser birthA;
    private com.toedter.calendar.JDateChooser birthE;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField emailA;
    private javax.swing.JTextField emailE;
    private javax.swing.JRadioButton esp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nameA;
    private javax.swing.JTextField nameE;
    private javax.swing.JTextField nickA;
    private javax.swing.JTextField nickE;
    private javax.swing.JTextField website;
    private javax.swing.JTextField website1;
    private javax.swing.JTextField website2;
    // End of variables declaration//GEN-END:variables
}
