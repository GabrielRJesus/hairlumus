package control;

import entidade.Cliente;
import entidade.Fornecedor;
import entidade.Funcionario;
import entidade.Pessoa;
import exception.ControlException;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.Date;
import sql.Banco;

public class PessoaControl {
    
    Banco conSing = Banco.getInstancia();
    Connection con = conSing.getConexao();
    
    public int gravarPessoa(Integer codigo, String nome, String endereco, String telefone, String celular) throws ControlException{
        Pessoa p = new Pessoa();
        if(codigo!=null && codigo!=0)
            p.setCodigo(codigo);
        if(nome!=null && !nome.isEmpty())
            p.setNome(nome);
        if(endereco!=null && !endereco.isEmpty())
            p.setEndereco(endereco);
        if(telefone!=null && !telefone.isEmpty())
            p.setTelefone(telefone);
        if(celular!=null && !celular.isEmpty())
            p.setCelular(celular);
        
        try{
            if(codigo!=null && codigo!=0){
                int n =  p.update(con);
                return codigo;
            }
            else
                return p.insert(con);
        }catch(EntidadeException ex){
            throw new ControlException(ex.getMessage());
        }
    }
    
    public int gravarCliente(Integer codigo, String nome, String endereco, String telefone, String celular ,String cpf, String Rg, Date dtNasc, String sexo) throws ControlException{
        Cliente c = new Cliente();
        int chave,n;
        if(codigo==null || codigo==0){
            chave = gravarPessoa(codigo, nome, endereco, telefone, celular);
            c.setCodigo(chave);
        }
        else{
            n = gravarPessoa(codigo, nome, endereco, telefone, celular);
            c.setCodigo(codigo);
        }
        if(cpf!=null && !cpf.isEmpty())
            c.setCpf(cpf);
        if(Rg!=null && !Rg.isEmpty())
            c.setRg(Rg);
        if(dtNasc!=null)
            c.setDataNasc(dtNasc);
        if(sexo!=null && !sexo.isEmpty())
            c.setSexo(sexo);
        
        
        try{
            int p = c.insert(con);
            return c.getCodigo();
        }catch(EntidadeException ex){
            throw new ControlException(ex.getMessage());
        }
    }
    
    public int gravarFuncionario(Integer codigo, String nome, String endereco, String telefone, String celular ,String cpf, String Rg, Date dtNasc, String sexo,
                                 String login, String senha, String cargo, double salario) throws ControlException{
        
        Funcionario f = new Funcionario();
        int n = gravarCliente(codigo, nome, endereco, telefone, celular, cpf, Rg, dtNasc, sexo);
        if(login!=null && !login.isEmpty())
            f.setLogin(login);
        if(senha!=null && !senha.isEmpty())
            f.setSenha(senha);
        if(cargo!=null && !cargo.isEmpty())
            f.setCargo(cargo);
        if(salario>0)
            f.setSalario(salario, cargo);
        f.setCodigo(n);
        f.setCpf(cpf);
        
        try{
            return f.insert(con);
        }catch(EntidadeException ex){
            throw new ControlException(ex.getMessage());
        }
        
    }
    
    public int gravarFornecedor(Integer codigo, String nome, String endereco, String telefone, String celular, String cnpj, String ie, String nomeContato) throws ControlException{
        Fornecedor f = new Fornecedor();
        int chave,n;
        if(codigo==null || codigo!=0){
            chave = gravarPessoa(codigo, nome, endereco, telefone, celular);
            f.setCodigo(chave);
        }
        else{
            n = gravarPessoa(codigo, nome, endereco, telefone, celular);
            f.setCodigo(codigo);
        }
        if(cnpj!=null && !cnpj.isEmpty())
            f.setCnpj(cnpj);
        if(ie!=null && !ie.isEmpty())
            f.setIe(ie);
        if(nomeContato!=null && !nomeContato.isEmpty())
            f.setNomeResp(nomeContato);
        try{
            return f.insert(con);
        }catch(EntidadeException ex){
            throw new ControlException(ex.getMessage());
        }
    }
}
