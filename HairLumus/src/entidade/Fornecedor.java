package entidade;

public class Fornecedor extends Pessoa{
    private String cnpj;
    private String ie;
    private String nomeResp;

    public Fornecedor(Integer codigo, String nome, String endereco, String telefone, String celular) {
        super(codigo, nome, endereco, telefone, celular);
    }

    public Fornecedor() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getNomeResp() {
        return nomeResp;
    }

    public void setNomeResp(String nomeResp) {
        this.nomeResp = nomeResp;
    }
    
    
    
}
