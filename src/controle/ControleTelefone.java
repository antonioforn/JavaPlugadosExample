
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloTelefone;


public class ControleTelefone {
    ConectaBanco connex = new ConectaBanco();
    ModeloTelefone telefone= new ModeloTelefone();
    
    
    public void inserir(ModeloTelefone telefone){
        connex.conexao();
        try {
            PreparedStatement pst = connex.conn.prepareStatement("insert into telefone (numero_tel) values (?)");
            pst.setString(1, telefone.getTel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!\nErro:" +ex);
        }
        connex.desconecta();
    }
    
    public void alterar(ModeloTelefone telefone){
        connex.conexao();
        try {
            PreparedStatement pst = connex.conn.prepareStatement("update telefone set numero_tel=? where id_telefone=?");
            pst.setString(1, telefone.getTel());
            pst.setInt(2, telefone.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar!\nErro:" +ex);
        }
        connex.desconecta();        
    }
    
    public void Excluir(ModeloTelefone telefone){
        connex.conexao();
        PreparedStatement pst;
        try {
            pst = connex.conn.prepareStatement("delete from telefone where id_telefone=?");
            pst.setInt(1, telefone.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos excluidos con suceso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error\n Erro: " +ex);
        }
        
        connex.desconecta();
    }

    public ModeloTelefone primeiro() {
        connex.conexao();
        connex.execSQLrs("select * from telefone");
        try {
            connex.rs.first();
            telefone.setCod(connex.rs.getInt("id_telefone"));
            telefone.setTel(connex.rs.getString("numero_tel"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: + ex");
        }
        connex.desconecta();
        return telefone;
    }
    
    public ModeloTelefone ultimo(){
        connex.conexao();
        connex.execSQLrs("select * from telefone");
        try {
            connex.rs.last();
            telefone.setCod(connex.rs.getInt("id_telefone"));
            telefone.setTel(connex.rs.getString("numero_tel"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: + ex");
        }
        connex.desconecta();
        return telefone;        
    }
    
}
