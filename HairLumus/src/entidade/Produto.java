package entidade;

import DAO.ProdutoDAO;
import exception.DAOException;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.List;

public class Produto {
    private Integer codigo;
    private String descricao;
    private double preco;
    private int estoque;
    private int estMin;
    private Marca marca;

    public Produto() {
        marca = new Marca();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstMin() {
        return estMin;
    }

    public void setEstMin(int estMin) {
        this.estMin = estMin;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public List<Produto> lista(Connection con) throws EntidadeException{
        try{
            return new ProdutoDAO().lista(this,con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public Produto select(Connection con) throws EntidadeException{
        try{
            return new ProdutoDAO().select(this,con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public int insert(Connection con) throws EntidadeException{
        try{
            return new ProdutoDAO().insert(this,con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
}
