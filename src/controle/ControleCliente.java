
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;


public class ControleCliente {
    ConectaBanco conex = new ConectaBanco();
    ModeloCliente cliente = new ModeloCliente();
    int codBairro, codCidade, codTel;
    String strBairro, strCidade, strTelefone;
    
    public void Inserir(ModeloCliente cliente){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("insert into clientes (nome_cliente, endereco_cliente, rg_cliente, cpf_cliente, "
                    + "id_bairro) values(?,?,?,?,?)");
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEndereco());
            pst.setString(3, cliente.getRg());
            pst.setString(4, cliente.getCpf());
            buscaCod(cliente.getBairro(), cliente.getCidade(),cliente.getTelefone());
        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        conex.desconecta();
    }
    
    public void excluir(ModeloCliente cliente){
        conex.conexao();
        try {
            //exclui dados de tabelta tel_cli
            PreparedStatement pst = conex.conn.prepareStatement("delete from tel_cli where id_cliente=?");
            pst.setInt(1, cliente.getId());
            pst.execute();
            
            //exclui dados de tabela cliente
            pst= conex.conn.prepareStatement("delete from clientes where id_cliente=?");
            pst.setInt(1, cliente.getId());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusao! \nErro: " +ex);
        }
        conex.desconecta();
    } //fin excluir()
    
    public void alterar(ModeloCliente cliente){
        conex.conexao();
        try {
            //altera tabela tel_cli
            conex.execSQLrs("select * from telefone where numero_tel='" + cliente.getTelefone() +"'");
            conex.rs.next();
            codTel= conex.rs.getInt("id_telefone");
            PreparedStatement pst = conex.conn.prepareStatement("update tel_cli set id_tel=? where id_cliente=?");
            pst.setInt(1, codTel);
            pst.setInt(2, cliente.getId());
            pst.execute();
            //altera a tabela cliente
            pst= conex.conn.prepareStatement("update clientes set nome_cliente=?, endereco_cliente=?, rg_cliente=?, "
                    + "cpf_cliente=?, id_bairro=? where id_cliente=?");
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEndereco());
            pst.setString(3, cliente.getRg());
            pst.setString(4, cliente.getCpf());
            
            conex.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscaCod(String bairro, String cidade, String tel){
        try {
            conex.execSQLrs("select * from bairro where nome_bairro='" + bairro +"'");
            conex.rs.next();
            codBairro= conex.rs.getInt("id_bairro");
            conex.execSQLrs("select * from cidade where nome_cidade='" + cidade +"'");
            conex.rs.next();
            codCidade= conex.rs.getInt("id_cidade");            
            conex.execSQLrs("select * from telefone where numero_tel='" + tel +"'");
            conex.rs.next();
            codTel= conex.rs.getInt("id_telefone");                        
            
        } catch (SQLException ex) {
            //Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscaNomes(int codBairro, int codCid){
        try {
            conex.execSQLrs("select * from bairro where id_bairro=" +codBairro);
            conex.rs.next();
            strBairro= conex.rs.getString("nome_bairro");
            conex.execSQLrs("select * from cidade where id_cidade=" + codCid);
            conex.rs.next();
            strCidade = conex.rs.getString("nome_cidade");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao seleccionar os Nomes!\nErro: " + ex);
        }
        
    }
    
}