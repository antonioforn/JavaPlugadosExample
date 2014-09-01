
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
    
    }

    public ModeloTelefone primeiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
