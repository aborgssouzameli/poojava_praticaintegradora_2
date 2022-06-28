package repositories;

import services.PessoaService;
import java.util.LinkedList;
import java.util.List;

public class CircuitoAvancadoRepository {
    final private int DISTANCIA_KM = 10;
    final private double VALOR_UNICO = 2800.00;
    private int numeroCamiseta = 0;
    private List<FaturaRepository>  listaPessoaCompetidora = new LinkedList<FaturaRepository>();
    public void adicionarPessoaCompetidora(PessoaService pessoa) {
        double valorFatura = VALOR_UNICO;
        FaturaRepository fatura = new FaturaRepository(valorFatura, pessoa.retornarInstanciaPessoa());
        listaPessoaCompetidora.add(++numeroCamiseta, fatura);
    }
}
