

package visao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import controle.ConectaBanco;
import controle.ControleCidade;
import controle.ModeloTabela;
import modelo.ModeloCidade;


public class FrmCidades extends javax.swing.JFrame {

    ConectaBanco conecta = new ConectaBanco();//para la tabla estados
    ConectaBanco conecta2 = new ConectaBanco();// para la tabla cidade
    ModeloCidade mod = new ModeloCidade();
    ControleCidade control = new ControleCidade();    
    javax.swing.JFrame padre;
    
    public FrmCidades() {
        initComponents();
        conecta.conexao();
        conecta2.conexao();
        preencherTabela("select * from cidade inner join estados on cidade.id_estado = estados.id_estado order by id_cidade");
        preencherCmbEstado();
        this.padre=null;
    }
    
    public FrmCidades(javax.swing.JFrame padre) {
        this.padre= padre;
        initComponents();
        conecta.conexao();
        conecta2.conexao();
       preencherTabela("select * from cidade inner join estados on cidade.id_estado = estados.id_estado order by id_cidade");
        preencherCmbEstado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnPrimer = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidades");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Código:");

        txtId.setEnabled(false);

        jLabel3.setText("Nome:");

        txtNome.setEnabled(false);

        jLabel4.setText("Estado");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_item.png"))); // NOI18N
        btnNovo.setToolTipText("Nuevo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_item.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove_item.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept_item.png"))); // NOI18N
        btnSalvar.setToolTipText("Guardar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right_arrow.png"))); // NOI18N
        jButton5.setToolTipText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_item.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1leftarrow.png"))); // NOI18N
        btnAnterior.setToolTipText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnPrimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2leftarrow.png"))); // NOI18N
        btnPrimer.setToolTipText("Ir al primero");
        btnPrimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimerActionPerformed(evt);
            }
        });

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1rightarrow.png"))); // NOI18N
        btnSiguiente.setToolTipText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2rightarrow.png"))); // NOI18N
        btnUltimo.setToolTipText("Ir al último");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(259, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrimer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPrimer)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnUltimo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(jButton5)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Cidades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            mod.setNome(txtNome.getText());
            conecta.execSQLrs("select * from estados where nome_estado like '"
                    + cmbEstado.getSelectedItem().toString() +"'");
            conecta.rs.next();
            mod.setCod_estado(conecta.rs.getInt("id_estado"));
            control.inserirCidade(mod);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        preencherTabela("select * from cidade inner join estados on cidade.id_estado = estados.id_estado order by id_cidade");
        if(padre!=null) FrmBairro.atualizaCombo();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            mod.setCod(Integer.parseInt(txtId.getText()));
            mod.setNome(txtNome.getText());
            mod.setCod_estado(conecta.rs.getInt("id_estado"));
            control.excluiCidade(mod);
            txtId.setText(null);
            txtNome.setText(null);
            txtNome.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnNovo.setEnabled(true);   
            btnEliminar.setEnabled(false);
            btnEditar.setEnabled(false);
            //preencherTabela("select * from estados order by id_estado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar registro.\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        txtId.setText(null);
        txtNome.setText(null);
        txtNome.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnNovo.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        txtId.setText(null);
        txtNome.setText(null);
        txtNome.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(true);        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try {
            conecta2.rs.previous();
            txtId.setText(String.valueOf(conecta2.rs.getInt("id_cidade")));
            txtNome.setText(conecta2.rs.getString("nome_cidade"));
            conecta.execSQLrs("select * from estados where id_estado = "
                    + conecta2.rs.getInt("id_estado"));
            conecta.rs.next();
            cmbEstado.setSelectedItem((Object) conecta.rs.getString("nome_estado"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al traer el registro. \n" + ex.getMessage() );
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al traer el registro. \n" + e.getMessage() );
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnPrimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimerActionPerformed
        try {
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtNome.setEnabled(true);
            cmbEstado.setEnabled(true);            
            conecta2.execSQLrs("select * from cidade order by id_cidade");
            conecta2.rs.first();
            txtId.setText(String.valueOf(conecta2.rs.getInt("id_cidade")));
            txtNome.setText(conecta2.rs.getString("nome_cidade"));
            conecta.execSQLrs("select * from estados where id_estado = "
                    + conecta2.rs.getInt("id_estado"));
            conecta.rs.next();
            cmbEstado.setSelectedItem((Object) conecta.rs.getString("nome_estado"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al traer el primer registro. \n" + ex.getMessage() );
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al traer el primer registro. \n" + e.getMessage() );
        }
    }//GEN-LAST:event_btnPrimerActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        try {
            conecta2.rs.next();
            txtId.setText(String.valueOf(conecta2.rs.getInt("id_cidade")));
            txtNome.setText(conecta2.rs.getString("nome_cidade"));
            conecta.execSQLrs("select * from estados where id_estado = "
                    + conecta2.rs.getInt("id_estado"));
            conecta.rs.next();
            cmbEstado.setSelectedItem((Object) conecta.rs.getString("nome_estado"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al traer el registro. \n" + ex.getMessage() );
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al traer el registro. \n" + e.getMessage() );
        }      
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        try {
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtNome.setEnabled(true);
            cmbEstado.setEnabled(true);                        
            conecta2.execSQLrs("select * from cidade order by id_cidade");
            conecta2.rs.last();
            txtId.setText(String.valueOf(conecta2.rs.getInt("id_cidade")));
            txtNome.setText(conecta2.rs.getString("nome_cidade"));
            conecta.execSQLrs("select * from estados where id_estado = "
                    + conecta2.rs.getInt("id_estado"));
            conecta.rs.next();
            cmbEstado.setSelectedItem((Object) conecta.rs.getString("nome_estado"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al traer el ultimo registro. \n" + ex.getMessage() );
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al traer el ultimo registro. \n" + e.getMessage() );
        }   
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            mod.setCod(Integer.parseInt(txtId.getText()));
            mod.setNome(txtNome.getText());
            conecta.execSQLrs("select * from estados where nome_estado like '"
                    + cmbEstado.getSelectedItem().toString() +"'");
            conecta.rs.next();
            mod.setCod_estado(conecta.rs.getInt("id_estado"));
            control.alterarCidade(mod);
            //JOptionPane.showMessageDialog(this, "Registro editado");
            preencherTabela("select * from cidade inner join estados on cidade.id_estado = estados.id_estado order by id_cidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al editar. \n" + ex.getMessage());        
        }
        
        txtId.setText(null);
        txtNome.setText(null);
        txtNome.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(true); 
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
          try {
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            txtNome.setEnabled(true);
            conecta2.execSQLrs("select * from cidade where id_cidade = " + tabela.getValueAt(tabela.getSelectedRow(), 0));
            conecta2.rs.next();
            txtId.setText(String.valueOf(conecta2.rs.getInt("id_cidade")));
            txtNome.setText(conecta2.rs.getString("nome_cidade"));
            conecta.execSQLrs("select * from estados where id_estado = "
                    + conecta2.rs.getInt("id_estado"));
            conecta.rs.next();
            cmbEstado.setSelectedItem((Object) conecta.rs.getString("nome_estado"));            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao mostrar dados \n" + ex.getMessage() );
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao mostrar dados \n" + e.getMessage() );
        }          
    }//GEN-LAST:event_tabelaMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if (padre != null){
            padre.setVisible(true);
            padre.setEnabled(true);
        }
    }//GEN-LAST:event_formWindowClosed

    public void preencherTabela(String sql){
        ArrayList datos= new ArrayList();
        String[] colunas = new String[]{"Id", "Nome", "Estado"}; 
        try{
            conecta2.execSQLrs(sql);
            while(conecta2.rs.next()){
                datos.add(new Object[]{conecta2.rs.getInt("id_cidade"),
                                        conecta2.rs.getString("nome_cidade"),
                                        conecta2.rs.getString("nome_estado")
                                        });
                
            }
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(this, "Error al cargar ArrayList. \n" + ex.getMessage());        
        }
    ModeloTabela modelo= new ModeloTabela(datos, colunas);
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(170);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
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
            java.util.logging.Logger.getLogger(FrmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimer;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void preencherCmbEstado() {
        conecta.execSQLrs("select * from estados order by nome_estado");
        cmbEstado.removeAllItems();
        try {
            while(conecta.rs.next()){
                cmbEstado.addItem(conecta.rs.getString("nome_estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar lista de Estados\n" + ex.getMessage());
        }
    }
}
