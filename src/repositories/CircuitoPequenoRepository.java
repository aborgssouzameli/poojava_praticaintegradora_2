package repositories;

import services.PessoaService;
import java.util.HashMap;

public class CircuitoPequenoRepository implements CircuitoRepositoryInterface {
    final private int DISTANCIA_KM = 2;
    final private double VALOR_MENOR_IDADE = 1300.00;
    final private double VALOR_MAIOR_IDADE = 1500.00;
    private int numeroCamiseta = 0;
    private HashMap<Integer , FaturaRepository> listaPessoaCompetidora = new HashMap<>();

    @Override
    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        double valorFatura = pessoa.getIdade() > 18 ? VALOR_MAIOR_IDADE : VALOR_MENOR_IDADE ;
        FaturaRepository fatura = new FaturaRepository(valorFatura, pessoa.retornarInstanciaPessoa());
        listaPessoaCompetidora.put(++numeroCamiseta, fatura);
    }

    @Override
    public void excluirPessoaCompetidora(int codigoPessoaCompetidora) {
        listaPessoaCompetidora.remove(codigoPessoaCompetidora);
    }

    @Override
    public HashMap<Integer, FaturaRepository> listarPessoasInscritas() {
        return listaPessoaCompetidora;
    }
}
