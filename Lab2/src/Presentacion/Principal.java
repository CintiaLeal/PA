package Presentacion;

import Logica.Factory;
import Logica.ISistema;
import java.sql.SQLException;

public class Principal extends javax.swing.JFrame {
    ISistema sis;
    public Principal(){
        sis = Factory.crearSistema();
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame9 = new javax.swing.JInternalFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        crearUsuario = new javax.swing.JMenuItem();
        modificarusuario = new javax.swing.JMenuItem();
        consultarusuario = new javax.swing.JMenuItem();
        registrarafuncion = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        crearplataforma = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        crearespectaculo = new javax.swing.JMenuItem();
        agregarespectaculopaquete = new javax.swing.JMenuItem();
        consultarespectaculo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        crearpaquete = new javax.swing.JMenuItem();
        consultarpaquete = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        agregarfuncion = new javax.swing.JMenuItem();
        consultarfuncion = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame9.setVisible(false);

        javax.swing.GroupLayout jInternalFrame9Layout = new javax.swing.GroupLayout(jInternalFrame9.getContentPane());
        jInternalFrame9.getContentPane().setLayout(jInternalFrame9Layout);
        jInternalFrame9Layout.setHorizontalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame9Layout.setVerticalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu3.setText("Usuario");

        crearUsuario.setText("Crear");
        crearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(crearUsuario);

        modificarusuario.setText("Modificar");
        modificarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarusuarioActionPerformed(evt);
            }
        });
        jMenu3.add(modificarusuario);

        consultarusuario.setText("Consultar");
        consultarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarusuarioActionPerformed(evt);
            }
        });
        jMenu3.add(consultarusuario);

        registrarafuncion.setText("Registrar a Funcion");
        registrarafuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarafuncionActionPerformed(evt);
            }
        });
        jMenu3.add(registrarafuncion);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Plataforma");

        crearplataforma.setText("Crear");
        crearplataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearplataformaActionPerformed(evt);
            }
        });
        jMenu4.add(crearplataforma);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Espectaculo");

        crearespectaculo.setText("Crear");
        crearespectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearespectaculoActionPerformed(evt);
            }
        });
        jMenu5.add(crearespectaculo);

        agregarespectaculopaquete.setText("Agregar a Paquete");
        agregarespectaculopaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarespectaculopaqueteActionPerformed(evt);
            }
        });
        jMenu5.add(agregarespectaculopaquete);

        consultarespectaculo.setText("Consultar");
        consultarespectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarespectaculoActionPerformed(evt);
            }
        });
        jMenu5.add(consultarespectaculo);

        jMenuItem2.setText("Aceptar/Rechazar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("Paquete");

        crearpaquete.setText("Crear");
        crearpaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearpaqueteActionPerformed(evt);
            }
        });
        jMenu1.add(crearpaquete);

        consultarpaquete.setText("Consultar");
        consultarpaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarpaqueteActionPerformed(evt);
            }
        });
        jMenu1.add(consultarpaquete);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Funcion");

        agregarfuncion.setText("Crear");
        agregarfuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarfuncionActionPerformed(evt);
            }
        });
        jMenu2.add(agregarfuncion);

        consultarfuncion.setText("Consultar");
        consultarfuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarfuncionActionPerformed(evt);
            }
        });
        jMenu2.add(consultarfuncion);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Categoria");

        jMenuItem1.setText("Crear");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jInternalFrame9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(446, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jInternalFrame9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioActionPerformed
        Alta_U jInternalFrame1 = new Alta_U(sis);
        jInternalFrame1.setVisible(true);
    }//GEN-LAST:event_crearUsuarioActionPerformed

    private void crearplataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearplataformaActionPerformed
     
        Alta_Plataforma jInternalFramep = new Alta_Plataforma(sis);
        jInternalFramep.setVisible(true);
    }//GEN-LAST:event_crearplataformaActionPerformed

    private void modificarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarusuarioActionPerformed
        Modificar_Usuario jInternalFrame2 = new Modificar_Usuario(sis);
        jInternalFrame2.setVisible(true);
    }//GEN-LAST:event_modificarusuarioActionPerformed

    private void consultarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarusuarioActionPerformed
        Consultar_Usuario jInternalFrame3 = new Consultar_Usuario(sis);
        jInternalFrame3.setVisible(true);
    }//GEN-LAST:event_consultarusuarioActionPerformed
    
    private void registrarafuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarafuncionActionPerformed
        Registro_a_Función_de_Espectáculo registro = new Registro_a_Función_de_Espectáculo(sis);
        registro.setVisible(true);
        registro.listarp();
    }//GEN-LAST:event_registrarafuncionActionPerformed

    private void crearespectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearespectaculoActionPerformed
        Alta_Espectaculo jInternalFrame4 = new Alta_Espectaculo(sis);
        jInternalFrame4.setVisible(true);
    }//GEN-LAST:event_crearespectaculoActionPerformed

    private void agregarfuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarfuncionActionPerformed
        Alta_Funcion_Espectaculo jInternalFrame5 = new Alta_Funcion_Espectaculo(sis);

        jInternalFrame5.setVisible(true);
    }//GEN-LAST:event_agregarfuncionActionPerformed

    private void consultarespectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarespectaculoActionPerformed
        Consulta_Espectaculo jInternalFrame6 = new Consulta_Espectaculo(sis);
        
        jInternalFrame6.setVisible(true);
    }//GEN-LAST:event_consultarespectaculoActionPerformed

    private void agregarespectaculopaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarespectaculopaqueteActionPerformed
        Agregar_Espectaculo_a_Paquete jInternalFrame7 = new Agregar_Espectaculo_a_Paquete(sis);
        jInternalFrame7.setVisible(true);
    }//GEN-LAST:event_agregarespectaculopaqueteActionPerformed

    private void crearpaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearpaqueteActionPerformed
        Crear_Paquete_De_Espectaculo jInternalFrame8 = new Crear_Paquete_De_Espectaculo(sis);
        jInternalFrame8.setVisible(true);
    }//GEN-LAST:event_crearpaqueteActionPerformed

    private void consultarfuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarfuncionActionPerformed
        Consulta_de_funcion_de_espectaculo jInternalFrame9 = new Consulta_de_funcion_de_espectaculo(sis);
        jInternalFrame9.setVisible(true);
    }//GEN-LAST:event_consultarfuncionActionPerformed

    private void consultarpaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarpaqueteActionPerformed
        Consulta_Paquetes  jInternalFrame91 = new  Consulta_Paquetes(sis);
         jInternalFrame91.setVisible(true);
    }//GEN-LAST:event_consultarpaqueteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       Alta_Categoria jInternalFrame10 = new Alta_Categoria(sis);
       jInternalFrame10.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Aceptar_Rechazar_Espectaculo jInternalFrame11 = new Aceptar_Rechazar_Espectaculo(sis);
        jInternalFrame11 .setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem agregarespectaculopaquete;
    private javax.swing.JMenuItem agregarfuncion;
    private javax.swing.JMenuItem consultarespectaculo;
    private javax.swing.JMenuItem consultarfuncion;
    private javax.swing.JMenuItem consultarpaquete;
    private javax.swing.JMenuItem consultarusuario;
    private javax.swing.JMenuItem crearUsuario;
    private javax.swing.JMenuItem crearespectaculo;
    private javax.swing.JMenuItem crearpaquete;
    private javax.swing.JMenuItem crearplataforma;
    private javax.swing.JInternalFrame jInternalFrame9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem modificarusuario;
    private javax.swing.JMenuItem registrarafuncion;
    // End of variables declaration//GEN-END:variables
}
