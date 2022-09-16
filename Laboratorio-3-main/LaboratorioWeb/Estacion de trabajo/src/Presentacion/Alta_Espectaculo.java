package Presentacion;

import DataType.Estado;
import DataType.ListString;
import Logica.ISistema;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Alta_Espectaculo extends javax.swing.JFrame {
int longitudBytes;
    FileInputStream fis;
    File img;
    ISistema sis;
    public Alta_Espectaculo(ISistema sistema) {
        initComponents();
        setLocationRelativeTo(null);
        sis = sistema;
        listarCategorias();
    }
    
    List<String> cat = new ArrayList();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nickA = new javax.swing.JTextField();
        name_plataforma = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        name_esp = new javax.swing.JTextField();
        duracion = new javax.swing.JTextField();
        emax = new javax.swing.JTextField();
        emin = new javax.swing.JTextField();
        cost = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        categorias = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        url = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cantPremios = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        descP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alta de Espectáculo");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("Ingrese los datos");

        jLabel2.setText("Nombre de plataforma:");

        jLabel3.setText("Nickname del artista:");

        jLabel4.setText("Nombre del espectáculo:");

        jLabel5.setText("Descripción:");

        jLabel6.setText("Duración:");

        jLabel9.setText("Espectadores mínimos:");

        jLabel10.setText("Espectadores máximos:");

        jLabel12.setText("Costo:");

        duracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                duracionKeyReleased(evt);
            }
        });

        emax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emaxActionPerformed(evt);
            }
        });
        emax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emaxKeyReleased(evt);
            }
        });

        emin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eminActionPerformed(evt);
            }
        });
        emin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eminKeyReleased(evt);
            }
        });

        cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                costKeyReleased(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriasActionPerformed(evt);
            }
        });

        jLabel11.setText("Categorías");

        agregar.setText("Agregar categoría");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        url.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                urlKeyReleased(evt);
            }
        });

        jLabel13.setText("Url:");

        jLabel14.setText("Cantidad premios:");

        cantPremios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantPremiosActionPerformed(evt);
            }
        });

        jLabel15.setText("Descripcion premio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(name_plataforma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(nickA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(name_esp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(desc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(duracion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(emax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(emin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(cost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(url, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(cantPremios, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descP, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jLabel8)
                    .addContainerGap(352, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(name_plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nickA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(name_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(emin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(emax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12))
                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cantPremios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(descP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addComponent(agregar)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(13, 13, 13))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(376, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(109, 109, 109)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if ((name_esp.getText().length() != 0) && (nickA.getText().length() != 0) && (desc.getText().length() != 0) && (name_plataforma.getText().length() != 0) && (emin.getText().length() != 0)
                && (emax.getText().length() != 0) && (duracion.getText().length() != 0) && (cost.getText().length() != 0) && (cat.size() > 0)) {
            
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
          
            String plataforma, nick, nombre, descripcion, url1;
            Double costo;
            Integer min, max, dur;
            
            plataforma = name_plataforma.getText();
            nick = nickA.getText();
            url1 = url.getText();
            nombre = name_esp.getText();
            min = Integer.parseInt(emin.getText());
            max = Integer.parseInt(emax.getText());
            dur = Integer.parseInt(duracion.getText());
            costo = Double.parseDouble(cost.getText());
            descripcion = desc.getText();
            Date fecha = new Date();
            String fechaAlta  = fecha.toString();
            String descPremio = descP.getText();
            Integer cant = Integer.parseInt(cantPremios.getText());
            
           String fechaA = simpleDateFormat.format(fechaAlta);
            
            
            //System.out.println(fechaA);
            if ((sis.existePlataforma(plataforma)) && (sis.existeArtista(nick))) {
                if (sis.existeEspectaculo(nombre)) {
                    JOptionPane.showMessageDialog(null, "Ya existe un espectaculo con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    name_esp.setText("");
                }
                Estado est = Estado.aceptado;
                ListString cat1 = new ListString(cat);
                sis.confirmarEspectaculo(plataforma, nick, nombre, descripcion, url1, dur, min, max, costo, fechaA, est, cat1, "", cant, descPremio);
                JOptionPane.showMessageDialog(null, "Creado correctamente!!", "El espectaculo fue creado exitosamente", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } 
            else if (!sis.existePlataforma(plataforma)) {
                JOptionPane.showMessageDialog(null, "No existe dicha plataforma, ingrese una correcta", "Error", JOptionPane.ERROR_MESSAGE);
                name_plataforma.setText("");
            } 
            else if (!sis.existeArtista(nick)) {
                JOptionPane.showMessageDialog(null, "No existe dicho artista, ingrese uno correcto", "Error", JOptionPane.ERROR_MESSAGE);
                nickA.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No pueden quedar campos sin completar", "Error...", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void duracionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracionKeyReleased
        String[] v = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
        char c = evt.getKeyChar();
        String s = "%" + c;
        s = s.replace("%", "");
        if (s.equals(v[0]) || s.equals(v[1]) || s.equals(v[2]) || s.equals(v[3]) || s.equals(v[4]) || s.equals(v[5])) {
        } else if (s.equals(v[6]) || s.equals(v[7]) || s.equals(v[8]) || s.equals(v[9]) || s.equals(v[10])) {
        } else {
            int k = duracion.getText().length() - 1;
            String n = duracion.getText().substring(0, k);
            duracion.setText(n);
        }
    }//GEN-LAST:event_duracionKeyReleased

    private void eminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eminKeyReleased
        String[] v = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
        char c = evt.getKeyChar();
        String s = "%" + c;
        s = s.replace("%", "");
        if (s.equals(v[0]) || s.equals(v[1]) || s.equals(v[2]) || s.equals(v[3]) || s.equals(v[4]) || s.equals(v[5])) {
        } else if (s.equals(v[6]) || s.equals(v[7]) || s.equals(v[8]) || s.equals(v[9]) || s.equals(v[10])) {
        } else {
            int k = emin.getText().length() - 1;
            String n = emin.getText().substring(0, k);
            emin.setText(n);
        }
    }//GEN-LAST:event_eminKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null, "SE CANCELO LA CREACION ");
        this.dispose(); //esto luego cambia al menu principal
    }//GEN-LAST:event_jButton2ActionPerformed

    private void costKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyReleased
        String[] v = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
        char c = evt.getKeyChar();
        String s = "%" + c;
        s = s.replace("%", "");
        if (s.equals(v[0]) || s.equals(v[1]) || s.equals(v[2]) || s.equals(v[3]) || s.equals(v[4]) || s.equals(v[5])) {
        } else if (s.equals(v[6]) || s.equals(v[7]) || s.equals(v[8]) || s.equals(v[9]) || s.equals(v[10])) {
        } else {
            int k = cost.getText().length() - 1;
            String n = cost.getText().substring(0, k);
            cost.setText(n);
        }
    }//GEN-LAST:event_costKeyReleased

    private void emaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emaxKeyReleased
        String[] v = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
        char c = evt.getKeyChar();
        String s = "%" + c;
        s = s.replace("%", "");
        if (s.equals(v[0]) || s.equals(v[1]) || s.equals(v[2]) || s.equals(v[3]) || s.equals(v[4]) || s.equals(v[5])) {
        } else if (s.equals(v[6]) || s.equals(v[7]) || s.equals(v[8]) || s.equals(v[9]) || s.equals(v[10])) {
        } else {
            int k = emax.getText().length() - 1;
            String n = emax.getText().substring(0, k);
            emax.setText(n);
        }
    }//GEN-LAST:event_emaxKeyReleased

    private void emaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emaxActionPerformed

    private void eminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eminActionPerformed

    private void categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriasActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        cat.add(categorias.getSelectedItem().toString());
        categorias.removeItem(categorias.getSelectedItem());
    }//GEN-LAST:event_agregarActionPerformed

    private void urlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_urlKeyReleased

    private void cantPremiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantPremiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantPremiosActionPerformed

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
            java.util.logging.Logger.getLogger(Alta_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Alta_Espectaculo().setVisible(true);
            }
        });
    }
    
    public void listarCategorias(){
        List<String> res = sis.listarCategorias();
        for (int i = 0; i < res.size(); i++) {
            categorias.addItem(res.get(i));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField cantPremios;
    private javax.swing.JComboBox<String> categorias;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField descP;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField emax;
    private javax.swing.JTextField emin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name_esp;
    private javax.swing.JTextField name_plataforma;
    private javax.swing.JTextField nickA;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}
