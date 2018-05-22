package entidade;

import java.util.Date;
import java.util.List;

public class Compra {
    private Integer codigo;
    private double valor;
    private Date dataCompra;
    private Fornecedor fornecedor;
    private List<ItensCompra> listaItens;

    public Compra() {
        fornecedor = new Fornecedor();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ItensCompra> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItensCompra> listaItens) {
        this.listaItens = listaItens;
    }
    
    
    
    
}
