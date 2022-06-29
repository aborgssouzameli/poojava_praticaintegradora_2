package repositories;

public class FaturaRepository {

    private double valorFatura;
    private PessoaRepository pessoa;

    public FaturaRepository(double valorFatura, PessoaRepository pessoa) {
        this.valorFatura = valorFatura;
        this.pessoa = pessoa;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public PessoaRepository getPessoa() {
        return pessoa;
    }
}
