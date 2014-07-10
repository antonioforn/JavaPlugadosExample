

package utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 
public class ConectaBanco {
    public Statement stm;
    public ResultSet rs;
    private String  driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/sistemavideoaula";
    private String usuario = "postgres";
    private String senha = "root";
    public Connection conn;
    
    public void conexao(){
        
        try { 
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conectado con suceso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexao. \nErro: " + ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try {
            stm= conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            stm.execute(sql);
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro de ExecutaSQL. \nErro: " + ex.getMessage());
        }
        
    }
    
    public void desconecta(){
        try { 
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao. \nErro: " + ex.getMessage());
        }
    }
    
    
}
