package entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private Integer codigo;
    private double valor;
    private Date data;
    private Cliente cliente;
    List<ItensVenda> lista;

    public Venda() {
        lista = new ArrayList<>();
        cliente = new Cliente();
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensVenda> getLista() {
        return lista;
    }

    public void setLista(List<ItensVenda> lista) {
        this.lista = lista;
    }
    
}
