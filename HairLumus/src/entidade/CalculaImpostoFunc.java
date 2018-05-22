package entidade;

public class CalculaImpostoFunc implements CalculaImposto{

    @Override
    public double calculaSalarioComImposto(Funcionario umFuncionario) {
        if (umFuncionario.getSalario()> 2000) {
                return umFuncionario.getSalario()* 0.85;
        }
        return umFuncionario.getSalario()* 0.9;
    }
    
}
