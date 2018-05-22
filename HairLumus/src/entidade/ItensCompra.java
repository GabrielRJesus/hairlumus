package entidade;

public class ItensCompra {
    private Compra comp;
    private Produto prod;
    private int qtde;

    public ItensCompra() {
        comp = new Compra();
        prod = new Produto();
    }

    public Compra getComp() {
        return comp;
    }

    public void setComp(Compra comp) {
        this.comp = comp;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    
}
