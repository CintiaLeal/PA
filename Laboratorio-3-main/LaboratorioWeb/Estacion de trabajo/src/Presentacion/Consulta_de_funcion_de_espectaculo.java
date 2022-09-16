/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import DataType.DTFunciones;
import DataType.DTPlataforma;
import Logica.ISistema;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class Consulta_de_funcion_de_espectaculo extends javax.swing.JFrame {

    /**
     * Creates new form Consulta_de_funcion_de_espectaculo
     */
    ISistema sis;

    public Consulta_de_funcion_de_espectaculo(ISistema sistema) {
        sis = sistema;
        initComponents();
        this.listarplataforma();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelar = new javax.swing.JButton();
        seleccionar = new javax.swing.JButton();
        selector = new javax.swing.JLabel();
        JFseleccionar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListar = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelar.setText("Cerrar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        seleccionar.setText("Seleccionar");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });

        selector.setText("Plataforma");

        jListar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selector)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JFseleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(seleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(seleccionar)
                    .addComponent(selector)
                    .addComponent(JFseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String p ;
    String e ;
    String f ;
    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed

        if (selector.getText() == "Plataforma") {
            if (JFseleccionar.getText().length() != 0) {
                if (sis.existePlataforma(JFseleccionar.getText())) {
                    p = JFseleccionar.getText();
                    List<String> list = sis.listarEspectaculo(JFseleccionar.getText());
                    DefaultListModel modelo = new DefaultListModel();
                    for (int i = 0; i < list.size(); i++) {
                        String pnombre = list.get(i);
                        modelo.addElement(pnombre);
                    }
                    jListar.setModel(modelo);
                    selector.setText("Espectaculo");
                    JFseleccionar.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe dicha plataforma, ingrese una correcta", "Error", JOptionPane.ERROR_MESSAGE);
                    JFseleccionar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecsione una plataforma", "Error", JOptionPane.ERROR_MESSAGE);
                JFseleccionar.setText("");
            }
        } else if (selector.getText() == "Espectaculo") {
            if (JFseleccionar.getText().length() != 0) {
                if (sis.existeEspectaculo(JFseleccionar.getText())) {
                    List<String> list = sis.listarFuncionesAsociadas(p, JFseleccionar.getText());
                    e = JFseleccionar.getText();
                    DefaultListModel modelo = new DefaultListModel();
                    for (int i = 0; i < list.size(); i++) {
                        String pnombre = list.get(i);
                        modelo.addElement(pnombre);
                    }
                    jListar.setModel(modelo);
                    selector.setText("Funcion");
                    JFseleccionar.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe dicha plataforma, ingrese una correcta", "Error", JOptionPane.ERROR_MESSAGE);
                    JFseleccionar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe dicha plataforma, ingrese una correcta", "Error", JOptionPane.ERROR_MESSAGE);
                JFseleccionar.setText("");
            }
        } else if (selector.getText() == "Funcion") {
            seleccionar.setVisible(false);
            selector.setVisible(false);
            JFseleccionar.setVisible(false);
            DTFunciones funcion = sis.seleccionarFuncion(p,e,JFseleccionar.getText());
            DefaultListModel modelo = new DefaultListModel();
            modelo.addElement(funcion.toString());
            jListar.setModel(modelo);
            
            
        
        }
    }//GEN-LAST:event_seleccionarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta_de_funcion_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_funcion_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_funcion_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_funcion_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Consulta_de_funcion_de_espectaculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JFseleccionar;
    private javax.swing.JButton cancelar;
    private javax.swing.JList<String> jListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton seleccionar;
    private javax.swing.JLabel selector;
    // End of variables declaration//GEN-END:variables

    private void listarplataforma() {
        List<DTPlataforma> list = sis.listarPlataformas();
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < list.size(); i++) {
            String pnombre = list.get(i).getNombre();
            modelo.addElement(pnombre);
        }
        jListar.setModel(modelo);
        JFseleccionar.setText("");
    }
}