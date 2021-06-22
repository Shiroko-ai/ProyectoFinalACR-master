/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Cliente.Usuario;
import Server.ObjetoRemoto;
import Server.SolicitudesServidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author LAST_
 * Esta GUI es el menu principal una vez iniciada sesion
 */
public class JFrameCuenta extends javax.swing.JFrame {
    
    String Nombre;
    String Apellido;
    Usuario usu;
    SolicitudesServidor Serv;

    /**
     * Creates new form JFrameCuenta
     */
    public JFrameCuenta(Usuario u, SolicitudesServidor o) {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.Nombre = u.nombre;
        this.Apellido = u.apellido;
        usu = u;
        Serv = o;
        jLabel1.setText("Bienvenid@: " + Nombre + " " + Apellido);    
        
        init2();       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RetDep_Btn = new javax.swing.JButton();
        Detalles_btn = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel2.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenid@: \" + Nombre + \" \" + Apellido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 470, 30));

        RetDep_Btn.setBackground(new java.awt.Color(255, 255, 255));
        RetDep_Btn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        RetDep_Btn.setForeground(new java.awt.Color(102, 0, 0));
        RetDep_Btn.setText("Retiro/Deposito");
        RetDep_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetDep_BtnActionPerformed(evt);
            }
        });
        jPanel1.add(RetDep_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        Detalles_btn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Detalles_btn.setForeground(new java.awt.Color(102, 0, 0));
        Detalles_btn.setText("Detalles de cuenta");
        Detalles_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Detalles_btnActionPerformed(evt);
            }
        });
        jPanel1.add(Detalles_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 230, -1));

        Regresar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        Regresar.setForeground(new java.awt.Color(102, 0, 0));
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        jPanel1.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 230, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/FONDO.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Detalles_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Detalles_btnActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_Detalles_btnActionPerformed

    private void RetDep_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetDep_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RetDep_BtnActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_RegresarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Detalles_btn;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton RetDep_Btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void init2() {
        this.RetDep_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrameRetiroDeposito JR = new JFrameRetiroDeposito(usu, Serv);
                JR.setVisible(true);
            }

        });
        
        this.Detalles_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrameDetallesCuenta JD = new JFrameDetallesCuenta(usu, Serv);
                JD.setVisible(true);
            }

        });
        
        this.Regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JFrameLogin l = new JFrameLogin();
                l.setVisible(true);
            }

        });
        
    }
}
