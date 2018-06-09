package control;

import entidade.Cliente;
import entidade.Fornecedor;
import entidade.Pessoa;
import entidade.Produto;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import sql.Banco;

public abstract class TemplateMethod {
    
    Banco conSing = Banco.getInstancia();
    Connection con = conSing.getConexao();
    
    final void realizarFuncao(){
        String nome = null;
        List<Produto> listaprod = new ArrayList<>();
        int qtdparcelas = 0, qtd = 0;
        double soma = 0;
        int chave = 0;
        selecionarPessoa(nome);
        inserirProdutos(listaprod, qtd);
    }
    
    Pessoa selecionarPessoa(String nome){
        Cliente c = new Cliente();
        Pessoa p = new Pessoa(); 
        Fornecedor f = new Fornecedor();
        c.setNome(nome);
        try {
            c.select(con);
            if(c.getCodigo()!=null || c.getCodigo()!=0){
                p.setCodigo(c.getCodigo());
                p.select(con);
                return c;
            }
            else{
                f.setNome(nome);
                if(f.getCodigo()!=null || f.getCodigo()!=0){
                    p.setCodigo(f.getCodigo());
                    p.select(con);
                    return p;
                }
            }
        } catch (EntidadeException ex) {
            ex.getMessage();
        }
        return p;
    }
    abstract void inserirProdutos(List<Produto> listaprod, int qtd);
    
}
