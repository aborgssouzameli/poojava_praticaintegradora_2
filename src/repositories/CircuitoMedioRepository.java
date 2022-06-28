package repositories;

import services.PessoaService;
import java.util.HashMap;

public class CircuitoMedioRepository {
    final private int DISTANCIA_KM = 5;
    final private double VALOR_MENOR_IDADE = 2000.00;
    final private double VALOR_MAIOR_IDADE = 2300.00;
    private int numeroCamiseta = 0;
    private HashMap<Integer , FaturaRepository> listaPessoaCompetidora = new HashMap<>();
    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        double valorFatura = pessoa.getIdade() > 18 ? VALOR_MAIOR_IDADE : VALOR_MENOR_IDADE ;
        FaturaRepository fatura = new FaturaRepository(valorFatura, pessoa.retornarInstanciaPessoa());
        listaPessoaCompetidora.put(++numeroCamiseta, fatura);
    }

    public HashMap<Integer, FaturaRepository> listarPessoasInscritas() {
        return listaPessoaCompetidora;
    }
}
