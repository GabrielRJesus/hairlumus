package entidade;

import java.util.Date;

public class Cliente extends Pessoa{
    private String cpf;
    private String rg;
    private Date dataNasc;
    private String sexo;

    public Cliente() {
    }

    public Cliente(String cpf, String rg, Date dataNasc, String sexo, Integer codigo, String nome, String endereco, String telefone, String celular) {
        super(codigo, nome, endereco, telefone, celular);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
    }
    
    public Cliente(Integer codigo, String nome, String endereco, String telefone, String celular) {
        super(codigo,nome,endereco,telefone,celular);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
