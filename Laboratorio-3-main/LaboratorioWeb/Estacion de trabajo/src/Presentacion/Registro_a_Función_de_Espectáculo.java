package Presentacion;

import DataType.DTPlataforma;
import DataType.DTUsuario;
import Logica.ISistema;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Registro_a_Función_de_Espectáculo extends javax.swing.JFrame {

    ISistema sis;

    public Registro_a_Función_de_Espectáculo(ISistema sistema) {
        initComponents();
        setLocationRelativeTo(null);
        sis = sistema;
        this.listarp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLselector = new javax.swing.JLabel();
        Selecsionar = new javax.swing.JButton();
        Canselar = new javax.swing.JButton();
        JFseleccionar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListar = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        rejostroComun = new javax.swing.JButton();
        cambiarRegistros = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        selecsionarRegistro = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        elimminarSelecsion = new javax.swing.JButton();
        confirmarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLselector.setText("Plataforma");

        Selecsionar.setText("Selecsionar");
        Selecsionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecsionarActionPerformed(evt);
            }
        });

        Canselar.setText("Canselar");
        Canselar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanselarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLselector))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JFseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Selecsionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Canselar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLselector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Selecsionar)
                    .addComponent(Canselar)
                    .addComponent(JFseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        rejostroComun.setText("Registro común");
        rejostroComun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejostroComunActionPerformed(evt);
            }
        });

        cambiarRegistros.setText("Cambiar registros");
        cambiarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarRegistrosActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        selecsionarRegistro.setText("Seleccionar registro");
        selecsionarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecsionarRegistroActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jList2);

        elimminarSelecsion.setText("Eliminar selección");
        elimminarSelecsion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimminarSelecsionActionPerformed(evt);
            }
        });

        confirmarRegistro.setText("Confirmar");
        confirmarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(selecsionarRegistro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(elimminarSelecsion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmarRegistro)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selecsionarRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elimminarSelecsion)
                    .addComponent(confirmarRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rejostroComun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambiarRegistros)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rejostroComun)
                    .addComponent(cambiarRegistros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void CanselarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanselarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CanselarActionPerformed

    String p;
    String e;
    String f;
    String u;
    private void SelecsionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecsionarActionPerformed
        if (jLselector.getText() == "Plataforma") {
            if (JFseleccionar.getText().length() != 0) {
                if (sis.existePlataforma(JFseleccionar.getText())) {
                    p = JFseleccionar.getText();
                    List<String> list = sis.listarEspectaculo(JFseleccionar.getText());
                    DefaultListModel modelo = new DefaultListModel();
                    for (int i = 0; i < list.size(); i++) {
                        String enombre = list.get(i);
                        modelo.addElement(enombre);
                    }
                    jListar.setModel(modelo);
                    jLselector.setText("Espectaculo");
                    JFseleccionar.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe dicha plataforma, ingrese una correcta", "Error", JOptionPane.ERROR_MESSAGE);
                    JFseleccionar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecsione una plataforma", "Error", JOptionPane.ERROR_MESSAGE);
                JFseleccionar.setText("");
            }
        } else if (jLselector.getText() == "Espectaculo") {
            if (JFseleccionar.getText().length() != 0) {
                if (sis.existeEspectaculo(JFseleccionar.getText())) {
                    List<String> listF = sis.listarFuncionesAsociadas(p, JFseleccionar.getText());
                    e = JFseleccionar.getText();
                    DefaultListModel modelo = new DefaultListModel();
                    for (int i = 0; i < listF.size(); i++) {
                        String fnombre = listF.get(i);
                        modelo.addElement(fnombre);
                    }
                    jListar.setModel(modelo);
                    jLselector.setText("Funcion");
                    JFseleccionar.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe dicho Espectaculo, ingrese una correcta", "Error", JOptionPane.ERROR_MESSAGE);
                    JFseleccionar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ingreso ninfun espectaculo", "Error", JOptionPane.ERROR_MESSAGE);
                JFseleccionar.setText("");
            }
        } else if (jLselector.getText() == "Funcion") {
            if (JFseleccionar.getText().length() != 0) {
                if (sis.existeFuncionenE(e, JFseleccionar.getText())) {
                    f = JFseleccionar.getText();
                    jLselector.setText("Usuario");
                    List<DTUsuario> listesp = sis.listarEspectador();
                    DefaultListModel modelo = new DefaultListModel();
                    for (int i = 0; i < listesp.size(); i++) {
                        String pnombre = listesp.get(i).getNickname();
                        modelo.addElement(pnombre);
                    }
                    jListar.setModel(modelo);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe dicha Funcion, ingrese una correcta", "Error", JOptionPane.ERROR_MESSAGE);
                    JFseleccionar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ingreso ninguna Funcion", "Error", JOptionPane.ERROR_MESSAGE);
                JFseleccionar.setText("");
            }
        } else if (jLselector.getText() == "Usuario") {
            if (JFseleccionar.getText().length() != 0) {
                if (sis.existeEspectador(JFseleccionar.getText())) {
                    u=JFseleccionar.getText();
                    this.jPanel1.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe dicho Espectador, ingrese uno correcto", "Error", JOptionPane.ERROR_MESSAGE);
                    JFseleccionar.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ingreso ningun Usuario", "Error", JOptionPane.ERROR_MESSAGE);
                JFseleccionar.setText("");
            }
        }
    }//GEN-LAST:event_SelecsionarActionPerformed

    private void rejostroComunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejostroComunActionPerformed
        java.util.Date D = new java.util.Date();
        int resultado = sis.aceptarRegisto(p,e,f,u,D);
    }//GEN-LAST:event_rejostroComunActionPerformed

    private void selecsionarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecsionarRegistroActionPerformed
        
    }//GEN-LAST:event_selecsionarRegistroActionPerformed

    private void cambiarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarRegistrosActionPerformed
        
    }//GEN-LAST:event_cambiarRegistrosActionPerformed

    private void confirmarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarRegistroActionPerformed
        
    }//GEN-LAST:event_confirmarRegistroActionPerformed

    private void elimminarSelecsionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimminarSelecsionActionPerformed
        
    }//GEN-LAST:event_elimminarSelecsionActionPerformed

    public void listarp() {
        List<DTPlataforma> list = sis.listarPlataformas();
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < list.size(); i++) {
            String pnombre = list.get(i).getNombre();
            modelo.addElement(pnombre);
        }
        jListar.setModel(modelo);
        JFseleccionar.setText("");
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Canselar;
    private javax.swing.JTextField JFseleccionar;
    private javax.swing.JButton Selecsionar;
    private javax.swing.JButton cambiarRegistros;
    private javax.swing.JButton confirmarRegistro;
    private javax.swing.JButton elimminarSelecsion;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jListar;
    private javax.swing.JLabel jLselector;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton rejostroComun;
    private javax.swing.JButton selecsionarRegistro;
    // End of variables declaration//GEN-END:variables
}
