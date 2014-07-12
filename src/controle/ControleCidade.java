
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloCidade;


public class ControleCidade {
    ConectaBanco conCidade = new ConectaBanco();
    
    public void inserirCidade(ModeloCidade mod){
        conCidade.conexao();
        try{
            PreparedStatement pst =
            conCidade.conn.prepareStatement("insert into cidade (nome_cidade, id_estado)"
                    + "values(?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCod_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dato almacenado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        conCidade.desconecta();
    }
    
    public void excluiCidade(ModeloCidade mod){
        conCidade.conexao();
        try {
            PreparedStatement pst = conCidade.conn.prepareStatement("delete from cidade where id_cidade= ?");
            pst.setInt(1, mod.getCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar\n" + ex.getMessage());
        }
        conCidade.desconecta();
    }
}
