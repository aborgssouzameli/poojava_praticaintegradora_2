package repositories;

import services.PessoaService;
import java.util.HashMap;

public class CircuitoAvancadoRepository implements CircuitoRepositoryInterface {
    final private int DISTANCIA_KM = 10;
    final private double VALOR_UNICO = 2800.00;
    private int numeroCamiseta = 0;
    private HashMap<Integer , FaturaRepository> listaPessoaCompetidora = new HashMap<>();
    @Override
    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        double valorFatura = VALOR_UNICO;
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
