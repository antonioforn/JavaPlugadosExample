

package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloBairro;


public class ControleBairro {
    ConectaBanco conex = new ConectaBanco();
    ConectaBanco conexPesq= new ConectaBanco();
    int codCid;
    String cidade;
    
    public void Grava(ModeloBairro bairro){
        conex.conexao();
        try{
            conex.execSQLrs("select * from cidade where nome_cidade='" + bairro.getCidade() + "'");
            conex.rs.next();
            codCid= conex.rs.getInt("id_cidade");
            PreparedStatement pst = conex.conn.prepareStatement("insert into bairro(nome_bairro, id_cidade) values(?,?)");
            pst.setString(1, bairro.getNome());
            pst.setInt(2, codCid);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Datos insertados con éxito");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al grabar" + ex.toString());
        }
        conex.desconecta();
    }
    
    public ModeloBairro Primeiro(){
        ModeloBairro bairro = new ModeloBairro();
        conex.conexao();
        conexPesq.conexao();
        
        conex.execSQLrs("select * from bairro");
        
        try {
            conex.rs.next();
            conexPesq.execSQLrs("select * from cidade where id_cidade=" + conex.rs.getInt("id_cidade"));
            conexPesq.rs.next();
            cidade= conexPesq.rs.getString("nome_cidade");
            bairro.setId(conex.rs.getInt("id_bairro"));
            bairro.setNome(conex.rs.getString("nome_bairro"));
            bairro.setCidade(cidade);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer el primer registro" + ex);
        }
        
        conex.desconecta();
        conexPesq.desconecta();
        return bairro;
    }
    
    public ModeloBairro Ant(){
        ModeloBairro bairro = new ModeloBairro();
        conex.conexao();
        conexPesq.conexao();
        try {
            conex.rs.previous();
            conexPesq.execSQLrs("select * from cidade where id_cidade=" + conex.rs.getInt("id_cidade"));
            conexPesq.rs.next();
            cidade= conexPesq.rs.getString("nome_cidade");
            bairro.setId(conex.rs.getInt("id_bairro"));
            bairro.setNome(conex.rs.getString("nome_bairro"));
            bairro.setCidade(cidade);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error al traer el primer registro" + ex);
        }
        conex.desconecta();
        conexPesq.desconecta();        
        return bairro;
    }
    
    public ModeloBairro Prox(){
        ModeloBairro bairro = new ModeloBairro();
        conex.conexao();
        conexPesq.conexao();
        try {
            conex.rs.next();
            conexPesq.execSQLrs("select * from cidade where id_cidade=" + conex.rs.getInt("id_cidade"));
            conexPesq.rs.next();
            cidade= conexPesq.rs.getString("nome_cidade");
            bairro.setId(conex.rs.getInt("id_bairro"));
            bairro.setNome(conex.rs.getString("nome_bairro"));
            bairro.setCidade(cidade);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error al traer el primer registro" + ex);
        }
        conex.desconecta();
        conexPesq.desconecta();        
        return bairro;
    } 
    
    public ModeloBairro Ult(){
        ModeloBairro bairro = new ModeloBairro();
        conex.conexao();
        conexPesq.conexao();
        
        conex.execSQLrs("select * from bairro");
        
        try {
            conex.rs.last();
            conexPesq.execSQLrs("select * from cidade where id_cidade=" + conex.rs.getInt("id_cidade"));
            conexPesq.rs.next();
            cidade= conexPesq.rs.getString("nome_cidade");
            bairro.setId(conex.rs.getInt("id_bairro"));
            bairro.setNome(conex.rs.getString("nome_bairro"));
            bairro.setCidade(cidade);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer el último registro" + ex);
        }
        
        conex.desconecta();
        conexPesq.desconecta();
        return bairro;
    }    
    
    public void Editar(ModeloBairro bairro){
        conex.conexao();
        conexPesq.conexao();
        
        try {
            conexPesq.execSQLrs("select * from cidade where nome_cidade='" + bairro.getCidade() + "'");
            conexPesq.rs.next();
            codCid= conexPesq.rs.getInt("id_cidade"); //ERROR EN TUTO: codCid= conex.rs.getInt("id_cidade") /LINEA 130
            PreparedStatement pst = conex.conn.prepareStatement("update bairro set nome_bairro=?, id_cidade=? "
                    + "where id_bairro=?" );
            pst.setString(1, bairro.getNome());
            pst.setInt(2, codCid);
            pst.setInt(3, bairro.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos editados con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al editar datos" + ex);
        }
        
        conex.desconecta();
        conexPesq.desconecta();
    } 
    
    public void Excluir(ModeloBairro bairro){
        conex.conexao();
        try {
            PreparedStatement pst= conex.conn.prepareStatement("delete from bairro where id_bairro=?");
            pst.setInt(1, bairro.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos excluidos con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al excluir datos." +ex);
        }
        
        conex.desconecta();
    }
    
    public ModeloBairro retorna(int id){
        ModeloBairro bairro = new ModeloBairro();
        conex.conexao();
        conexPesq.conexao();
        
        conex.execSQLrs("select * from bairro where id_bairro= " + id);
        
        try {
            conex.rs.next();
            conexPesq.execSQLrs("select * from cidade where id_cidade=" + conex.rs.getInt("id_cidade"));
            conexPesq.rs.next();
            cidade= conexPesq.rs.getString("nome_cidade");
            bairro.setId(conex.rs.getInt("id_bairro"));
            bairro.setNome(conex.rs.getString("nome_bairro"));
            bairro.setCidade(cidade);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer el  registro" + ex);
        }
        
        conex.desconecta();
        conexPesq.desconecta();
        return bairro;
    }   
    
}
