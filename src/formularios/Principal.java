

package formularios;

import javax.swing.JOptionPane;
import utilitarios.ConectaBanco;


public class Principal extends javax.swing.JFrame {

    ConectaBanco conexao= new ConectaBanco();
    
    public Principal() {
        initComponents();
        conexao.conexao();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        mnItEstados = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnCompra = new javax.swing.JMenu();
        mnVenda = new javax.swing.JMenu();
        mnRelatorios = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Vendas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        mnCadastros.setText("Cadastros");

        mnItEstados.setText("Estados");
        mnItEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItEstadosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnItEstados);

        jMenuItem2.setText("Cidades");
        mnCadastros.add(jMenuItem2);

        jMenuItem3.setText("Bairro");
        mnCadastros.add(jMenuItem3);

        jMenuItem4.setText("Telefones");
        mnCadastros.add(jMenuItem4);

        jMenuItem5.setText("Clientes");
        mnCadastros.add(jMenuItem5);

        jMenuItem6.setText("Fornecedores");
        mnCadastros.add(jMenuItem6);

        jMenuItem7.setText("Produtos");
        mnCadastros.add(jMenuItem7);

        jMenuBar1.add(mnCadastros);

        mnCompra.setText("Compra");
        jMenuBar1.add(mnCompra);

        mnVenda.setText("Venda");
        jMenuBar1.add(mnVenda);

        mnRelatorios.setText("Relatórios");
        jMenuBar1.add(mnRelatorios);

        jMenu5.setText("Sair");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        int resp= JOptionPane.showConfirmDialog(this, "¿Desea salir?", "Abandonar el sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        System.out.println("valor yes_no " + resp);
        if(resp == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        conexao.desconecta();
    }//GEN-LAST:event_formWindowClosed

    private void mnItEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItEstadosActionPerformed
        // TODO add your handling code here:
        FrmEstado frmEstado = new FrmEstado();
        frmEstado.setVisible(true);
    }//GEN-LAST:event_mnItEstadosActionPerformed

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
                if ("Windows".equals(info.getName())) {
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
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenu mnCompra;
    private javax.swing.JMenuItem mnItEstados;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JMenu mnVenda;
    // End of variables declaration//GEN-END:variables
}
