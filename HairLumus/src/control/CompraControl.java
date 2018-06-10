package control;


import entidade.Compra;
import entidade.Fornecedor;
import entidade.ItensCompra;
import entidade.Produto;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sql.Banco;

public class CompraControl extends TemplateMethod{
    
    Banco conSing = Banco.getInstancia();
    Connection con = conSing.getConexao();
    
    private List<ItensCompra> listaitens = new ArrayList<>();
    
    @Override
    public void inserirProdutos(Produto prod, int qtd) {
            ItensCompra ic = new ItensCompra();
            ic.setProd(prod);
            ic.setQtde(qtd);
            listaitens.add(ic);
    }
    
    public int gravaCompra(int codigo, double valor, Date data, Fornecedor f){
        Compra comp = new Compra();
        comp.setCodigo(codigo);
        comp.setValor(valor);
        comp.setDataCompra(data);
        comp.setFornecedor(f);
        comp.setListaItens(listaitens);
        listaitens.clear();
        try{
            return comp.insert(con);
        }catch(EntidadeException ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public double soma() throws EntidadeException {
        double soma = 0;
        for (int i = 0; i < listaitens.size(); i++) {
           soma+=listaitens.get(i).getQtde()*listaitens.get(i).getProd().getPreco();
        }
        return soma;
    }
    
    public Fornecedor selecionaFornecedor(String desc) throws EntidadeException{
        Fornecedor f = new Fornecedor();
        f = f.select(con);
        return f;
    }
    
    public Produto buscarP(String desc) throws EntidadeException{
        Produto p = new Produto();
        p = p.select(con);
        return p;
    }
    
}
