package entidade;

public class ItensVenda {
    private Venda venda;
    private Produto produto;
    private int qtd;

    public ItensVenda() {
        venda = new Venda();
        produto = new Produto();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
}
