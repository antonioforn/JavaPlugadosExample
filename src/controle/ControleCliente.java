
package controle;

import modelo.ModeloCliente;


public class ControleCliente {
    ConectaBanco conex = new ConectaBanco();
    ModeloCliente cliente = new ModeloCliente();
    int codBairro, codCidade, codTel;
    String Bairro, Cidade, Telefone;
    
    public void Inserir(ModeloCliente mod){
        conex.conexao();
    }
    
}
